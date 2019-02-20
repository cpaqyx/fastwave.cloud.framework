/**
 * 描述：
 */
package fastwave.lib.common.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import fastwave.lib.common.callback.MethodCallback;
import fastwave.lib.common.collect.ListUtils;
import fastwave.lib.common.lang.DateUtils;
import fastwave.lib.common.lang.ObjectUtils;
import fastwave.lib.common.lang.StringUtils;
import fastwave.lib.common.reflect.ReflectUtils;
import fastwave.lib.common.utils.excel.annotation.ExcelField;
import fastwave.lib.common.utils.excel.annotation.ExcelFields;
import fastwave.lib.common.utils.excel.annotation.ExcelField.Type;

/**
 * 导入Excel文件（支持“XLS”和“XLSX”格式）
 * 
 * @author
 * @version 2014-8-19
 */
public class ExcelImport {

	private static Logger log = LoggerFactory.getLogger(ExcelImport.class);

	/**
	 * 工作薄对象
	 */
	private Workbook wb;

	/**
	 * 工作表对象
	 */
	private Sheet sheet;

	/**
	 * 标题行数
	 */
	private int headerNum;

	public List<String> headerDataList = new ArrayList<String>();
	//public Map<String, Object> dataMap = new HashMap<String, Object>();

	/**
	 * 构造函数
	 * 
	 * @param path
	 *            导入文件对象，读取第一个工作表
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ExcelImport(File file) throws InvalidFormatException, IOException {
		this(file, 0, 0);
	}

	/**
	 * 构造函数
	 * 
	 * @param path
	 *            导入文件对象，读取第一个工作表
	 * @param headerNum
	 *            标题行数，数据行号=标题行数+1
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ExcelImport(MultipartFile multipartFile, int headerNum) throws InvalidFormatException, IOException {
		this(multipartFile, headerNum, 0);
	}

	public ExcelImport(File file, int headerNum) throws InvalidFormatException, IOException {
		this(file, headerNum, 0);
	}

	/**
	 * 构造函数
	 * 
	 * @param path
	 *            导入文件对象
	 * @param headerNum
	 *            标题行数，数据行号=标题行数+1
	 * @param sheetIndexOrName
	 *            工作表编号或名称，从0开始
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ExcelImport(File file, int headerNum, Object sheetIndexOrName) throws InvalidFormatException, IOException {
		this(file.getName(), new FileInputStream(file), headerNum, sheetIndexOrName);
	}

	/**
	 * 构造函数
	 * 
	 * @param file
	 *            导入文件对象
	 * @param headerNum
	 *            标题行数，数据行号=标题行数+1
	 * @param sheetIndexOrName
	 *            工作表编号或名称，从0开始
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ExcelImport(MultipartFile multipartFile, int headerNum, Object sheetIndexOrName)
			throws InvalidFormatException, IOException {
		this(multipartFile.getOriginalFilename(), multipartFile.getInputStream(), headerNum, sheetIndexOrName);
	}

	/**
	 * 构造函数
	 * 
	 * @param path
	 *            导入文件对象
	 * @param headerNum
	 *            标题行数，数据行号=标题行数+1
	 * @param sheetIndexOrName
	 *            工作表编号或名称
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ExcelImport(String fileName, InputStream is, int headerNum, Object sheetIndexOrName)
			throws InvalidFormatException, IOException {
		if (StringUtils.isBlank(fileName)) {
			throw new ExcelException("导入文档为空!");
		} else if (fileName.toLowerCase().endsWith("xls")) {
			this.wb = new HSSFWorkbook(is);
		} else if (fileName.toLowerCase().endsWith("xlsx")) {
			this.wb = new XSSFWorkbook(is);
		} else {
			throw new ExcelException("文档格式不正确!");
		}
		this.setSheet(sheetIndexOrName, headerNum);
		log.debug("Initialize success.");
	}

	/**
	 * 添加到 annotationList
	 */
	private void addAnnotation(List<Object[]> annotationList, ExcelField ef, Object fOrM, Type type, String... groups) {
		// if (ef != null && (ef.type()==0 || ef.type()==type)){
		if (ef != null && (ef.type() == Type.ALL || ef.type() == type)) {
			if (groups != null && groups.length > 0) {
				boolean inGroup = false;
				for (String g : groups) {
					if (inGroup) {
						break;
					}
					for (String efg : ef.groups()) {
						if (StringUtils.equals(g, efg)) {
							inGroup = true;
							annotationList.add(new Object[] { ef, fOrM });
							break;
						}
					}
				}
			} else {
				annotationList.add(new Object[] { ef, fOrM });
			}
		}
	}

	/**
	 * 获取当前工作薄
	 * 
	 * @author
	 */
	public Workbook getWorkbook() {
		return wb;
	}

	/**
	 * 设置当前工作表和标题行数
	 * 
	 * @author
	 */
	public void setSheet(Object sheetIndexOrName, int headerNum) {
		if (sheetIndexOrName instanceof Integer || sheetIndexOrName instanceof Long) {
			this.sheet = this.wb.getSheetAt(ObjectUtils.toInteger(sheetIndexOrName));
		} else {
			this.sheet = this.wb.getSheet(ObjectUtils.toString(sheetIndexOrName));
		}
		if (this.sheet == null) {
			throw new ExcelException("没有找到‘" + sheetIndexOrName + "’工作表!");
		}
		this.headerNum = headerNum;
	}

	/**
	 * 获取行对象
	 * 
	 * @param rownum
	 * @return 返回Row对象，如果空行返回null
	 */
	public Row getRow(int rownum) {
		Row row = this.sheet.getRow(rownum);
		if(null == row)
		{
			return null;
		}
		// 验证是否是空行，如果空行返回null
		short cellNum = 0;
		short emptyNum = 0;
		Iterator<Cell> it = row.cellIterator();
		while (it.hasNext()) {
			cellNum++;
			Cell cell = it.next();
			if (StringUtils.isBlank(cell.toString())) {
				emptyNum++;
			}
		}
		if (cellNum == emptyNum) {
			return null;
		}
		return row;
	}

	/**
	 * 获取行对象
	 * 
	 * @param rownum
	 * @return 返回Row对象，如果空行返回null
	 */
	public Map<String, Object> getRowDataMap(int rownum) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Row row;
		if (headerDataList.size() == 0) {
			// headerData=
			row = this.sheet.getRow(0);
			int colnumNum = row.getLastCellNum();
			for (int i = 0; i < colnumNum; i++) {
				headerDataList.add(row.getCell(i).toString());
			}
		}
		
		row = this.sheet.getRow(rownum);
		if(null == row)
		{
			return null;
		}
		int headerFieldCount = headerDataList.size();
		int rowFieldCount = row.getLastCellNum();
		if(rowFieldCount > headerFieldCount)
		{
			rowFieldCount = headerFieldCount;
		}
		
		// 验证是否是空行，如果空行返回null
		for (int i = 0; i < rowFieldCount; i++) {
			//System.out.println(headerDataList.get(i));
			//System.out.println("listsize=" + headerDataList.size() + ",i=" + i);
			//System.out.println(getCellvalue(row.getCell(i)));
			dataMap.put(headerDataList.get(i), getCellvalue(row.getCell(i)));
		}

		return dataMap;
	}

	/**
	 * 获取数据行号
	 * 
	 * @return
	 */
	public int getDataRowNum() {
		return headerNum;
	}

	/**
	 * 获取最后一个数据行号
	 * 
	 * @return
	 */
	public int getLastDataRowNum() {
		// return this.sheet.getLastRowNum() + headerNum;
		return this.sheet.getLastRowNum() + 1;
	}

	/**
	 * 获取最后一个列号
	 * 
	 * @return
	 */
	public int getLastCellNum() {
		Row row = this.getRow(headerNum);
		return row == null ? 0 : row.getLastCellNum();
	}

	/**
	 * 获取单元格值
	 * 
	 * @param row
	 *            获取的行
	 * @param column
	 *            获取单元格列号
	 * @return 单元格值
	 */
	public Object getCellValue(Row row, int column) {
		if (row == null) {
			return row;
		}
		Object val = "";
		try {
			Cell cell = row.getCell(column);
			if (cell != null) {
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					val = cell.getNumericCellValue();
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						val = DateUtil.getJavaDate((Double) val); // POI Excel 日期格式转换
					} else {
						val = new DecimalFormat("0").format(val);
					}
				} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					val = cell.getStringCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
					try {
						val = cell.getStringCellValue();
					} catch (Exception e) {
						FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper()
								.createFormulaEvaluator();
						evaluator.evaluateFormulaCell(cell);
						CellValue cellValue = evaluator.evaluate(cell);
						switch (cellValue.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							val = cellValue.getNumberValue();
							break;
						case Cell.CELL_TYPE_STRING:
							val = cellValue.getStringValue();
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							val = cellValue.getBooleanValue();
							break;
						case Cell.CELL_TYPE_ERROR:
							val = ErrorEval.getText(cellValue.getErrorValue());
							break;
						default:
							val = cell.getCellFormula();
						}
					}
				} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
					val = cell.getBooleanCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
					val = cell.getErrorCellValue();
				}
			}
		} catch (Exception e) {
			return val;
		}
		return val;
	}

	/**
	 * 获取导入数据列表
	 * 
	 * @param cls
	 *            导入对象类型
	 * @param groups
	 *            导入分组
	 */
	public <E> List<E> getDataList(Class<E> cls, String... groups)
			throws InstantiationException, IllegalAccessException {
		return getDataList(cls, false, groups);
	}

	/**
	 * 获取导入数据列表
	 * 
	 * @param cls
	 *            导入对象类型
	 * @param isThrowException
	 *            遇见错误是否抛出异常
	 * @param groups
	 *            导入分组
	 */
	public <E> List<E> getDataList(Class<E> cls, final boolean isThrowException, String... groups)
			throws InstantiationException, IllegalAccessException {
		return getDataList(cls, new MethodCallback() {
			@Override
			public Object execute(Object... params) {
				if (isThrowException) {
					Exception ex = (Exception) params[0];
					int rowNum = (int) params[1];
					int columnNum = (int) params[2];
					throw new ExcelException("Get cell value [" + rowNum + "," + columnNum + "]", ex);
				}
				return null;
			}
		}, groups);
	}

	/**
	 * 获取导入数据列表
	 * 
	 * @param cls
	 *            导入对象类型
	 * @param isThrowException
	 *            遇见错误是否抛出异常
	 * @param groups
	 *            导入分组
	 */
	public <E> List<E> getDataList(Class<E> cls, MethodCallback exceptionCallback, String... groups)
			throws InstantiationException, IllegalAccessException {
		List<Object[]> annotationList = ListUtils.newArrayList();
		// Get annotation field
		Field[] fs = cls.getDeclaredFields();
		for (Field f : fs) {
			ExcelFields efs = f.getAnnotation(ExcelFields.class);
			if (efs != null && efs.value() != null) {
				for (ExcelField ef : efs.value()) {
					addAnnotation(annotationList, ef, f, Type.IMPORT, groups);
				}
			}
			ExcelField ef = f.getAnnotation(ExcelField.class);
			addAnnotation(annotationList, ef, f, Type.IMPORT, groups);
		}
		// Get annotation method
		Method[] ms = cls.getDeclaredMethods();
		for (Method m : ms) {
			ExcelFields efs = m.getAnnotation(ExcelFields.class);
			if (efs != null && efs.value() != null) {
				for (ExcelField ef : efs.value()) {
					addAnnotation(annotationList, ef, m, Type.IMPORT, groups);
				}
			}
			ExcelField ef = m.getAnnotation(ExcelField.class);
			addAnnotation(annotationList, ef, m, Type.IMPORT, groups);
		}
		// Field sorting
		Collections.sort(annotationList, new Comparator<Object[]>() {
			@Override
			public int compare(Object[] o1, Object[] o2) {
				return new Integer(((ExcelField) o1[0]).sort()).compareTo(new Integer(((ExcelField) o2[0]).sort()));
			};
		});
		// log.debug("Import column count:"+annotationList.size());
		// Get excel data
		List<E> dataList = ListUtils.newArrayList();
		for (int i = this.getDataRowNum(); i < this.getLastDataRowNum(); i++) {
			E e = (E) cls.newInstance();
			Row row = this.getRow(i);
			if (row == null) {
				continue;
			}
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < annotationList.size(); j++) {// Object[] os : annotationList){
				Object[] os = annotationList.get(j);
				ExcelField ef = (ExcelField) os[0];
				int column = (ef.column() != -1) ? ef.column() : j;
				Object val = this.getCellValue(row, column);
				if (val != null) {
					// If is dict type, get dict value
					if (StringUtils.isNotBlank(ef.dictType())) {
						try {
							Class<?> dictUtils = Class.forName("com.jeesite.modules.sys.utils.DictUtils");
							val = dictUtils.getMethod("getDictValue", String.class, String.class, String.class)
									.invoke(null, ef.dictType(), val.toString(), "");
						} catch (Exception ex) {
							log.info("Get cell value [" + i + "," + column + "] error: " + ex.toString());
							val = null;
						}
						// val = DictUtils.getDictValue(val.toString(), ef.dictType(), "");
						// log.debug("Dictionary type value: ["+i+","+colunm+"] " + val);
					}
					// Get param type and type cast
					Class<?> valType = Class.class;
					if (os[1] instanceof Field) {
						valType = ((Field) os[1]).getType();
					} else if (os[1] instanceof Method) {
						Method method = ((Method) os[1]);
						if ("get".equals(method.getName().substring(0, 3))) {
							valType = method.getReturnType();
						} else if ("set".equals(method.getName().substring(0, 3))) {
							valType = ((Method) os[1]).getParameterTypes()[0];
						}
					}
					// log.debug("Import value type: ["+i+","+column+"] " + valType);
					try {
						if (val != null) {
							if (valType == String.class) {
								String s = String.valueOf(val.toString());
								if (StringUtils.endsWith(s, ".0")) {
									val = StringUtils.substringBefore(s, ".0");
								} else {
									val = String.valueOf(val.toString());
								}
							} else if (valType == Integer.class) {
								val = Double.valueOf(val.toString()).intValue();
							} else if (valType == Long.class) {
								val = Double.valueOf(val.toString()).longValue();
							} else if (valType == Double.class) {
								val = Double.valueOf(val.toString());
							} else if (valType == Float.class) {
								val = Float.valueOf(val.toString());
							} else if (valType == Date.class) {
								if (val instanceof String) {
									val = DateUtils.parseDate(val);
								} else if (val instanceof Double) {
									val = DateUtil.getJavaDate((Double) val); // POI Excel 日期格式转换
								}
							} else {
								if (ef.fieldType() != Class.class) {
									val = ef.fieldType().getMethod("getValue", String.class).invoke(null,
											val.toString());
								} else {
									val = Class
											.forName(this.getClass().getName().replaceAll(
													this.getClass().getSimpleName(),
													"fieldtype." + valType.getSimpleName() + "Type"))
											.getMethod("getValue", String.class).invoke(null, val.toString());
								}
							}
						}
					} catch (Exception ex) {
						log.info("Get cell value [" + i + "," + column + "] error: " + ex.toString());
						val = null;
						// 参数：Exception ex, int rowNum, int columnNum
						exceptionCallback.execute(ex, i, column);
					}
					// set entity value
					if (os[1] instanceof Field) {
						ReflectUtils.invokeSetter(e, ((Field) os[1]).getName(), val);
					} else if (os[1] instanceof Method) {
						String mthodName = ((Method) os[1]).getName();
						if ("get".equals(mthodName.substring(0, 3))) {
							mthodName = "set" + StringUtils.substringAfter(mthodName, "get");
						}
						ReflectUtils.invokeMethod(e, mthodName, new Class[] { valType }, new Object[] { val });
					}
				}
				sb.append(val + ", ");
			}
			dataList.add(e);
			log.debug("Read success: [" + i + "] " + sb.toString());
		}
		return dataList;
	}

	public Object[] getRowData(Row row) {
		int columnNum = row.getLastCellNum() - row.getFirstCellNum();
		Object[] singleRow = new Object[columnNum];

		int n = 0;
		for (int i = 0; i < columnNum; i++) {
			Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BLANK:
					singleRow[n] = "";
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					singleRow[n] = Boolean.toString(cell.getBooleanCellValue());
					break;
				// 数值
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date date = cell.getDateCellValue();
						singleRow[n] = fastwave.lib.common.utils.excel.DateUtil.format(date);
					} else {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String temp = cell.getStringCellValue();
						// 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
						if (temp.indexOf(".") > -1) {
							DecimalFormat df = new DecimalFormat("###0.0#######################");// 最多保留几位小数，就用几个#，最少位就用0来确定
							String s = df.format(new Double(temp));
							if (s.endsWith("0")) {
								s = s.substring(0, s.length() - 1);
							}
							singleRow[n] = Double.parseDouble(s);
						} else {
							singleRow[n] = temp.trim();
						}
					}
					break;
				case Cell.CELL_TYPE_STRING:
					singleRow[n] = cell.getStringCellValue().trim();
					break;
				case Cell.CELL_TYPE_ERROR:
					singleRow[n] = "";
					break;
				case Cell.CELL_TYPE_FORMULA:
					cell.setCellType(Cell.CELL_TYPE_STRING);
					singleRow[n] = cell.getStringCellValue();
					if (singleRow[n] != null) {
						singleRow[n] = ((String) singleRow[n]).replaceAll("#N/A", "").trim();
					}
					break;
				default:
					singleRow[n] = "";
					break;
			}
			n++;
		}

		return singleRow;
	}

	public Object getCellvalue(Cell cell) {
		//System.out.println("读取的值为" + cell);
		Object obj;
		if(cell == null) {
			return null;
		}
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_BLANK:
				obj = "";
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				obj = Boolean.toString(cell.getBooleanCellValue());
				break;
			// 数值
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					obj = fastwave.lib.common.utils.excel.DateUtil.format(date);
				} else {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String temp = cell.getStringCellValue();
					// 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
					if (temp.indexOf(".") > -1) {
						DecimalFormat df = new DecimalFormat("###0.0#######################");// 最多保留几位小数，就用几个#，最少位就用0来确定
						String s = df.format(new Double(temp));
						if (s.endsWith("0")) {
							s = s.substring(0, s.length() - 1);
						}
						obj = Double.parseDouble(s);
					} else {
						obj = temp.trim();
					}
				}
				break;
			case Cell.CELL_TYPE_STRING:
				obj = cell.getStringCellValue().trim();
				break;
			case Cell.CELL_TYPE_ERROR:
				obj = "";
				break;
			case Cell.CELL_TYPE_FORMULA:
				cell.setCellType(Cell.CELL_TYPE_STRING);
				obj = cell.getStringCellValue();
				if (obj != null) {
					obj = ((String) obj).replaceAll("#N/A", "").trim();
				}
				break;
			default:
				obj = "";
				break;
		}
		return obj;
	}
	
	public void writeFailRowstoExcel(Workbook workBook,int sheetNum,List<Row> rowsList,List<String> failureRowsMessageList) {
			CellStyle style = workBook.createCellStyle();//生成样式,居中
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
			
			//设置字体

			HSSFFont font = null;
			XSSFFont fontX = null;
			CellStyle styleError = workBook.createCellStyle();//生成样式,居中
			try {
				font = (HSSFFont) workBook.createFont();
				font.setColor(HSSFFont.COLOR_RED); //字体颜色
				font.setFontName("黑体"); //字体
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //宽度
				
				styleError.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				styleError.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				styleError.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
				styleError.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
				styleError.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
				styleError.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				styleError.setFont(font);
				
			} catch (Exception e) {
				
				fontX = (XSSFFont) workBook.createFont();
				fontX.setColor(XSSFFont.COLOR_RED); //字体颜色
				fontX.setFontName("黑体"); //字体
				fontX.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD); //宽度
				
				styleError.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
				styleError.setAlignment(XSSFCellStyle.ALIGN_CENTER);
				styleError.setBorderBottom(XSSFCellStyle.BORDER_THIN); //下边框
				styleError.setBorderLeft(XSSFCellStyle.BORDER_THIN);//左边框
				styleError.setBorderTop(XSSFCellStyle.BORDER_THIN);//上边框
				styleError.setBorderRight(XSSFCellStyle.BORDER_THIN);//右边框
				//e.printStackTrace();
			}
			
			
			Sheet sheet = workBook.getSheetAt(0);
			Row row = null;
			
			//清空原数据
			for(int i=1;i<=sheet.getLastRowNum();i++) {
				if(null != sheet.getRow(i))
				{
					sheet.removeRow(sheet.getRow(i));
				}
			}
			//写入错误表头
			row =sheet.getRow(0);
			int lastColIndex = row.getLastCellNum();
			if(row.getCell(lastColIndex - 1).getStringCellValue() != null && 
					!row.getCell(lastColIndex - 1).getStringCellValue().equals("错误信息"))
			{
				Cell cell=row.createCell(lastColIndex);
				cell.setCellValue("错误信息");
				cell.setCellStyle(styleError);
			}
			else
			{
				lastColIndex = lastColIndex - 1;
			}
			//写入错误数据
//		for (int i = 0; i < rowsList.size(); i++) {
//			row =sheet.createRow(i+1);
//			Object[] singleRow = getRowData(rowsList.get(i));
//			for (int j=0;j<=singleRow.length;j++){
//				cell=row.createCell(j);
//				
//				if(j==singleRow.length) {
//					cell.setCellValue(failureRowsMessageList.get(i));
//					cell.setCellStyle(styleError);
//				}else {
//					cell.setCellValue(singleRow[j].toString());
//					cell.setCellStyle(style);
//				}
//				
//				sheet.autoSizeColumn(j, true);
//			}
//			
//		}
			Cell cell = null;
			for (int i = 0; i < rowsList.size(); i++) {
				//System.out.println("开始导出" + i + "条");
				row =sheet.createRow(i+1);
				Object[] singleRow = getRowData(rowsList.get(i));
				for (int j=0;j<singleRow.length;j++){
					cell=row.createCell(j);
					cell.setCellValue(singleRow[j].toString());
					cell.setCellStyle(style);
					//sheet.autoSizeColumn(j, true);
				}
				sheet.setColumnWidth(lastColIndex, 50*256);
				cell=row.createCell(lastColIndex);
				cell.setCellValue(failureRowsMessageList.get(i));
				cell.setCellStyle(styleError);
			}
		
	}
	
	/**
	 * 导入测试
	 */
	public static void main(String[] args) throws Throwable {

		File file = new File("D:\\spring-tool-suite\\xhc_ailiyun528\\fastwave-common-lib\\target\\export.xlsx");

		ExcelImport ei = new ExcelImport(file, 1);

		for (int i = ei.getDataRowNum(); i < ei.getLastDataRowNum(); i++) {
			Row row = ei.getRow(i);
			if (row == null) {
				continue;
			}
			for (int j = 0; j < ei.getLastCellNum(); j++) {
				Object val = ei.getCellValue(row, j);
				System.out.print(val + ", ");
			}
			System.out.print("\n");
		}

	}

}
