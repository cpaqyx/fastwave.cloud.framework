package fastwave.lib.common.utils.excel.template;

public class ExcelImportUtils {
	 public static boolean isExcel(String fileName)
	    {
	    	String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
	    	return "xls|xlsx".indexOf(ext) >= 0;
	    }

}
