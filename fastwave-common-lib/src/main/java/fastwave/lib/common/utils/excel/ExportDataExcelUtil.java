package fastwave.lib.common.utils.excel;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormat;

public class ExportDataExcelUtil<T> {
	public void exportExcel(HSSFWorkbook workBook, String sheetName,
			String[] headers, List<T> dataList, int sheetNum, String flag) {
		Pattern p1 = Pattern.compile("^-?[1-9]{1,}\\d*$");// 用于判断正负整数
		Pattern p2 = Pattern.compile("^-?\\d*\\.\\d*|0$"); // 用于判断正负浮点数，正整数和负整数除外(0.00是true)

		DataFormat format = workBook.createDataFormat();

		HSSFCellStyle style = workBook.createCellStyle();// 生成样式,居中
		style.setVerticalAlignment(HSSFCellStyle.ALIGN_RIGHT);
		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		style.setDataFormat(format
				.getFormat("_ * #,##0.00_ ;_ * -#,##0.00_ ;_ * \"-\"??_ ;_ @_ "));

		HSSFCellStyle style1 = workBook.createCellStyle();// 生成样式,居中
		style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFSheet sheet = workBook.createSheet();// 生成一张或多张sheet
		workBook.setSheetName(sheetNum, sheetName);

		HSSFRow row = sheet.createRow(0);// 产生标题行
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(style1);
			sheet.setColumnWidth(i, 30 * 256);// 设置统一列宽
		}
		if (dataList != null && !dataList.isEmpty()) {
			// 遍历集合产生数据行
			Iterator<T> it = dataList.iterator();
			int index = 0;
			while (it.hasNext()) {
				index++;
				row = sheet.createRow(index);
				T t = (T) it.next();
				// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
				Field[] fields = t.getClass().getDeclaredFields();
				for (int i = 0; i < headers.length; i++) {// 遍历标题行，防止javaBean中的属性和生成的excel中的字段数量不一致
					HSSFCell cell = row.createCell(i);
					Field field = fields[i];
					String fieldName = field.getName();
					Class tCls = t.getClass();
					try {
						PropertyDescriptor pd = new PropertyDescriptor(
								fieldName, tCls);
						Method getMethod = pd.getReadMethod();// 获取get方法
						Object getMethodValue = getMethod.invoke(t,
								new Object[] {});
						if (getMethodValue != null) {
							String value = getMethodValue.toString();
							Matcher matcher1 = p1.matcher(value);
							Matcher matcher2 = p2.matcher(value);
							if (matcher1.matches() && !matcher2.matches()
									&& !"-".equals(value)) {
								cell.setCellValue(Long.parseLong(value));
								cell.setCellStyle(style1);
							} else if (matcher2.matches()) {
								cell.setCellValue(Double.parseDouble(value));
								cell.setCellStyle(style);
							} else {
								cell.setCellValue(value);
								cell.setCellStyle(style1);
							}
						}
					} catch (IntrospectionException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
