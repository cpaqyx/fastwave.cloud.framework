package fastwave.lib.common.utils.excel.template;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import fastwave.lib.common.utils.excel.ExcelImport;
import fastwave.lib.common.web.R;

public abstract class ExcelImportTemplate {

	private File tempFile;
	private MultipartFile multipartFile;

	public ExcelImport excel;
	private List<Row> successRows = new ArrayList<Row>();
	public List<Row> failureRows = new ArrayList<Row>();
	public Long userId;
	public Long customerId;
	public int rowCnt;
	public int successCnt=0;
	public int failureCnt=0;
	public int emptyCnt = 0;
	public Object[] singleRow;
	public Map<String, Object> dataMap = new HashMap<String, Object>();
	public List<String> failureRowsMessage = new ArrayList<String>();
	
	public String message;

	public ExcelImportTemplate() {
		
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}


	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	

	// 构造函数
	public ExcelImportTemplate(MultipartFile file) {
		this.multipartFile = file;
	}

	public ExcelImportTemplate(File file) {
		this.tempFile = file;
	}

	// 开始导入
	public R run() throws InvalidFormatException, IOException {
		// init var
		successCnt = 0;
		failureCnt = 0;
		emptyCnt = 0;
		successRows.clear();
		failureRows.clear();
		failureRowsMessage.clear();
		
		
		// 文件验证 to do
		//R result = checkFile();
		// if (!result.isOk()) {
		// return result;
		// }
		System.out.println("开始读取表格");
		// 读取数据
		excel = new ExcelImport(multipartFile, 1);
		rowCnt = excel.getLastDataRowNum();
		System.out.println("读取到的表格行数");
		
		R result_init = init();
		if(!result_init.isSuccess())
		{
			System.out.println("初始化失败！");
			return result_init;	
		}
		System.out.println("初始化成功");

		// 遍历每一条记录，进行验证和导入
		//rowCnt = excel.getLastDataRowNum();
		for (int i = excel.getDataRowNum(); i < rowCnt; i++) {
			System.out.println("开始验证第" + i + "条");
			Row row = excel.getRow(i);
			dataMap = excel.getRowDataMap(i);
			if (row == null) {
				emptyCnt++;
				continue;
			}
			//R rowR = customCheckRow(row);
			if (!customCheckRow(dataMap).checkRowDataOk()) {
				// 加入到失败队列中
				//System.out.println("导入失败，加入到失败队列");
				failureCnt++;
				failureRows.add(row);
				continue;
			} else {
				// 插入到数据库表中
				if (customInsertRow(dataMap).insertDataOk()) {
					//System.out.println("插入到数据库表中");
					successCnt++;
					successRows.add(row);
				} else {
					//System.out.println("插入数据错误");
					failureCnt++;
					failureRows.add(row);
					failureRowsMessage.add("插入数据错误");
				}
			}

		}

		// 导入时都返回成功状态(即使一条也没有成功),主要判断是数量值和失败队列
		message = String.format("共%d条,成功导入%d条,没有成功%d条", rowCnt-1-emptyCnt, successCnt, failureCnt);
		if(failureCnt==0) {
			return R.ok(message);
		}else {
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("message", message);
			map.put("successCnt", successCnt);
			map.put("failureCnt", failureCnt);
			return R.error(map);
		}
		
	}

	// 验证文件
	private R checkFile() {
		// 常规验证/////////////////////////////////////////////////////
		// 判断文件是否为空
		if (tempFile == null) {
			return R.error(500, "没有找到需要导入的文件");
		}

		// 获取文件名
		String fileName = tempFile.getName();

		// 验证文件名是否合格
		// if(!ExcelImportUtils.validateExcel(fileName)){
		// session.setAttribute("msg","文件必须是excel格式！");
		// return "redirect:toUserKnowledgeImport";
		// }

		// 进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
		// long size = tempFile.length();
		// if(StringUtils.isEmpty(fileName) || size==0){
		// session.setAttribute("msg","文件不能为空！");
		// return "redirect:toUserKnowledgeImport";
		// }

		// 自定义验证
		return customCheckFile();

		// //如果全部验证通过则返回OK
		// return R.ok();
	}
	
	// 自定义验证
	protected R init() {
		return R.ok();
	}

	// 自定义验证
	protected R customCheckFile() {
		return R.ok();
	}

	// 自定义验证某一行
	protected R customCheckRow(Row row) {
		
		return R.ok();
	}
	
	// 自定义验证某一行
	protected R customCheckRow(Map<String, Object> dataMap) {
		return R.ok();
	}


	// 插入某一行
	protected R customInsertRow(Row row) /* throws Exception */ {
		return R.ok();
	}
	
	// 插入某一行
	protected R customInsertRow(Map<String, Object> dataMap) /* throws Exception */ {
		return R.ok();
	}

}
