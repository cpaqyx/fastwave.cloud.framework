package fastwave.common.auth;

//import java.security.NoSuchAlgorithmException;
//import java.util.Base64;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fastwave.service.auth.Application;

//import com.auth0.jwt.Algorithm;
//
//import fastwave.lib.common.codec.EncodeUtils;
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;

@SpringBootTest(classes=Application.class)
public class TokenAnalyse {
	@Test
	public void parseToken()
	{
//		//示例toke
//		String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYXlsb2FkIjoie1widXNlck5hbWVcIjpcImFkbWluXCIsXCJ1c2VySWRcIjoxLFwiY3VzdG9tZXJJZFwiOjEsXCJyb2xlc1wiOls3LDZdLFwiZGF0YUdyb3VwXCI6WzFdLFwidXNlclR5cGVcIjoxfSJ9.JD4VppLQDpUqpHKi_FC9Yk5rIeCZpddHmHH-q9NhpwE";
//		
//		// token 分析和展示
//		String[] tokenArray = token.split("\\.");
//		int index = 1;
//		for (String item : tokenArray)
//		{
//			System.out.println("第" + index++ + "段，长度为" + item.length() + "   内容：" + item);
//		}
//		
//		// 传化为明文,第三段为签名字符串,无法转换成可见文本
//		index = 1;
//		for (String item : tokenArray)
//		{
//			String decode = EncodeUtils.decodeBase64String(item);
//			System.out.println("第" + index++ + "段，长度为" + item.length() + "   明文内容：" + decode);
//		}
//		
//		// 把明文转为base64
//		String header = "{\"typ\":\"JWT\",\"alg\":\"HS256\"}";
//		String encodeHeader = EncodeUtils.encodeBase64(header);
//		System.out.println("第1段，长度为" + encodeHeader.length() + "   内容：" + encodeHeader);
//		
//		// 第一段和第二段加起来,生成一个签名
//		String secret = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";
//		Mac mac;
//		try {
//			Algorithm algorithm = Algorithm.HS256;
//			String algorithm2 = algorithm.getValue();
//			mac = Mac.getInstance("HS256");
//			mac.init(new SecretKeySpec(secret.getBytes(), "HS256"));
//			String msg = tokenArray[0] + "." + tokenArray[1];
//	        String signture = EncodeUtils.encodeBase64(mac.doFinal(msg.getBytes()));
//	        System.out.println("签名信息长度为:" + signture.length() + "   内容：" + signture);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
