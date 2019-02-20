package fastwave.lib.common.websocket;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;


public class WebSocketUtils {

    private static Logger logger = LoggerFactory.getLogger(WebSocketUtils.class);

    private final static String WEB_SOCKET_URL = "http://118.126.95.57:8201/fastwave-service-website/websocket/sendFireAlarmMessage_notToken";
    private final static String WEB_SOCKET_CHECKJOB_URL = "http://118.126.95.57:8201/fastwave-service-website/websocket/sendUseTransportationMessage_notToken";

   
    
	public static boolean push(Map<String, Object> pushMap) {
		HttpURLConnection conn = null;
		OutputStream os = null;
		try {
			URL url = new URL(WEB_SOCKET_URL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Content-type","application/json");
			conn.setRequestMethod("POST");

			conn.setDoOutput(true);
			conn.setDoInput(true);

			os = conn.getOutputStream();
			os.write(JSON.toJSONBytes(pushMap));
			os.flush();
			BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String str = br.readLine();
			System.out.println("响应内容为:  " + str);

			conn.disconnect();
			os.close();
			return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			logger.error("WEB SOCKET推送 ERROR :", e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.error("WEB SOCKET推送 ERROR :", e);
		} catch (ProtocolException e) {
			e.printStackTrace();
			logger.error("WEB SOCKET推送 ERROR :", e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("WEB SOCKET推送 ERROR :", e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}

			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public static boolean pushCheckJob(Map<String, Object> pushMap) {
		HttpURLConnection conn = null;
		OutputStream os = null;
		try {
			URL url = new URL(WEB_SOCKET_CHECKJOB_URL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Content-type","application/json");
			conn.setRequestMethod("POST");

			conn.setDoOutput(true);
			conn.setDoInput(true);

			os = conn.getOutputStream();
			os.write(JSON.toJSONBytes(pushMap));
			os.flush();
			BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String str = br.readLine();
			System.out.println("响应内容为:  " + str);

			conn.disconnect();
			os.close();
			return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			logger.error("WEB SOCKET推送 ERROR :", e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.error("WEB SOCKET推送 ERROR :", e);
		} catch (ProtocolException e) {
			e.printStackTrace();
			logger.error("WEB SOCKET推送 ERROR :", e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("WEB SOCKET推送 ERROR :", e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}

			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
