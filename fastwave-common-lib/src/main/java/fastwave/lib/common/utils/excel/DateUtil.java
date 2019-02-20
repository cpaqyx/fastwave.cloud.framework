package fastwave.lib.common.utils.excel;

import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;

import org.apache.commons.lang3.StringUtils;  
 


//import org.apache.commons.lang.StringUtils;  
 
/** 
* ����Util�� 
 *  
 * @author calvin 
 */  
public class DateUtil  
{  
    private static String defaultDatePattern = "yyyy-MM-dd HH:mm:ss";  
  
    /** 
     * ���Ĭ�ϵ� date pattern 
     */  
    public static String getDatePattern()  
    {  
        return defaultDatePattern;  
    }
    
    public static int getCurrentMilliSecond()
    {
    	Calendar Cld = Calendar.getInstance();
    	return Cld.get(Calendar.MILLISECOND);
    }
  
    /** 
     * ����Ԥ��Format�ĵ�ǰ�����ַ��� 
     */  
    public static String getToday()  
    {  
        Date today = new Date();  
        return format(today);  
    }  
  
    /** 
     * ʹ��Ԥ��Format��ʽ��Date���ַ��� 
     */  
    public static String format(Date date)  
    {  
        return date == null ? " " : format(date, getDatePattern());  
    }  
  
    /** 
     * ʹ�ò���Format��ʽ��Date���ַ��� 
     */  
    public static String format(Date date, String pattern)  
    {  
        return date == null ? " " : new SimpleDateFormat(pattern).format(date);  
    }  
  
    /** 
     * ʹ��Ԥ���ʽ���ַ���תΪDate 
     */  
    public static Date parse(String strDate) throws ParseException  
    {  
        return StringUtils.isBlank(strDate) ? null : parse(strDate,  
                getDatePattern());  
    }  
  
    /** 
     * ʹ�ò���Format���ַ���תΪDate 
     */  
    public static Date parse(String strDate, String pattern)  
            throws ParseException  
    {  
        return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(  
                pattern).parse(strDate);  
    }  
  
    /** 
     * �������������������� 
     */  
    public static Date addMonth(Date date, int n)  
    {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        cal.add(Calendar.MONTH, n);  
        return cal.getTime();  
    }  
  
    public static String getLastDayOfMonth(String year, String month)  
    {  
        Calendar cal = Calendar.getInstance();  
        // ��   
        cal.set(Calendar.YEAR, Integer.parseInt(year));  
        // �£���ΪCalendar������Ǵ�0��ʼ������Ҫ-1   
        // cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);   
        // �գ���Ϊһ��   
        cal.set(Calendar.DATE, 1);  
        // �·ݼ�һ���õ��¸��µ�һ��   
        cal.add(Calendar.MONTH, 1);  
        // ��һ���¼�һΪ�������һ��   
        cal.add(Calendar.DATE, -1);  
        return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));// �����ĩ�Ǽ���   
    }  
  
    public static Date getDate(String year, String month, String day)  
            throws ParseException  
    {  
        String result = year + "- "  
                + (month.length() == 1 ? ("0 " + month) : month) + "- "  
                + (day.length() == 1 ? ("0 " + day) : day);  
       return parse(result);  
    }  
    
    
    /**
    * ��ȡ�����µ����һ��
    * 
    * @param date
    * @return
    */
    public static String getLastdayOfMonth(Date date) {
    	Calendar ca = Calendar.getInstance();
    	ca.setTime(date);// someDate Ϊ��Ҫ��ȡ���Ǹ��µ�ʱ��
    	ca.set(Calendar.DAY_OF_MONTH, 1);
    	ca.add(Calendar.MONTH, 1);
    	ca.add(Calendar.DAY_OF_MONTH, -1);
    	// ���һ��
    	Date lastDate = ca.getTime();
    	return format(lastDate, "yyyy-MM-dd");
    }
    public static String getLastdayOfMonth(String strDate,String pattern) throws ParseException {
    	Date date  = parse(strDate, pattern);
    	return getLastdayOfMonth(date);
    }
    
    public static String getFirstdayOfMonth(String strDate,String pattern) throws ParseException {
    	Date date  = parse(strDate, pattern);
    	return getFirstdayOfMonth(date);
    }
    
    public static String getFirstdayOfNextMonth(String strDate,String pattern) throws ParseException {
    	Date date  = parse(strDate, pattern);
    	return getFirstdayOfNextMonth(date);
    }
    
    public static String getFirstdayOfPreMonth(String strDate,String pattern) throws ParseException {
    	Date date  = parse(strDate, pattern);
    	return getFirstdayOfPreMonth(date);
    }
    
    public static String getYearMonthTitle(String date) {
    	//yyyy-MM-dd
    	return date.substring(0,4) + "��" + date.substring(5,7) +"��";
    }

    /**
    * ��ȡ�����µĵ�һ��
    * 
    * @param date
    * @return
    */
    public static String getFirstdayOfMonth(Date date) {
    	Calendar ca = Calendar.getInstance();
    	ca.setTime(date);// someDate Ϊ��Ҫ��ȡ���Ǹ��µ�ʱ��
    	ca.set(Calendar.DAY_OF_MONTH, 1);
    	// ��һ��
    	Date firstDate = ca.getTime();
    	return format(firstDate, "yyyy-MM-dd");
    } 
    
    /**
     * ��ȡ���������µĵ�һ��
     * 
     * @param date
     * @return
     */
     public static String getFirstdayOfNextMonth(Date date) {
     	Calendar ca = Calendar.getInstance();
     	ca.setTime(date);// someDate Ϊ��Ҫ��ȡ���Ǹ��µ�ʱ��
     	ca.set(Calendar.DAY_OF_MONTH, 1);
     	//�·ݼ�1
     	ca.add(Calendar.MONTH, 1);
     	// ��һ��
     	Date firstDate = ca.getTime();
     	return format(firstDate, "yyyy-MM-dd");
     } 
     
     /**
      * ��ȡ���������µĵ�һ��
      * 
      * @param date
      * @return
      */
      public static String getFirstdayOfPreMonth(Date date) {
      	Calendar ca = Calendar.getInstance();
      	ca.setTime(date);// someDate Ϊ��Ҫ��ȡ���Ǹ��µ�ʱ��
      	ca.set(Calendar.DAY_OF_MONTH, 1);
      	//�·ݼ�1
      	ca.add(Calendar.MONTH, -1);
      	// ��һ��
      	Date firstDate = ca.getTime();
      	return format(firstDate, "yyyy-MM-dd");
      } 
	 public static void main(String[] args) throws Exception 
	    {
			//System.out.println(DateUtil.parse("2016-06-01"));
		 // System.out.println(DateUtil.getLastdayOfMonth("201609","yyyyMM"));
		 //System.out.println(DateUtil.getYearMonthTitle("2016-10-31"));
		 System.out.println(DateUtil.getFirstdayOfNextMonth("201612","yyyyMM"));

	    }
}  

