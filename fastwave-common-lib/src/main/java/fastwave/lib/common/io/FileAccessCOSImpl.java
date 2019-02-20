package fastwave.lib.common.io;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;

public class FileAccessCOSImpl implements IFileAccess {

	/*
	 * private static String regionName = "xxxxx"; private static String secretId =
	 * "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"; private static String secretKey =
	 * "xxxxxxxxxxxxxxxxxx";
	 * 
	 * private static String bucketName = "xxxxxxxxxxxxx"; //上传到COS的地址 //public
	 * static final String IMG_END_POINT =
	 * "http://kaonaer-1255712530.cosgz.myqcloud.com/"; //COS图片经过万象优图转化后的地址 public
	 * static final String IMG_END_POINT =
	 * "http://kaonaer-1255712530.picgz.myqcloud.com/";
	 */

	private static String regionName = "ap-guangzhou";
	private static String secretId = "AKIDVsGXs4GuZ8bxEJ784wCUbbVDk6Zvjp24";
	private static String secretKey = "60iEYgghNwKYcVldO0QdfdcUAg1CD2iW";
	private static String bucketName = "kaonaer-1255712530";

	// 上传到COS的地址
	// public static final String IMG_END_POINT =
	// "http://kaonaer-1255712530.cosgz.myqcloud.com/";
	// COS图片经过万象优图转化后的地址
	public static final String IMG_END_POINT = "http://kaonaer-1255712530.picgz.myqcloud.com/";

	public static String DEFAULT_SUBDIR_PATH = "default/";
	public static String TEMP_FILE_PATH = "tempfile/";

	@Override
	public String save(MultipartFile file) {
		return save(file, DEFAULT_SUBDIR_PATH);
	}

	@Override
	public String save(MultipartFile file, String subDir) {

		// // MultipartFile 转换为file
		// String filePath = subDir;
		// if (!file.isEmpty()) {
		// File dir = new File(filePath);
		// if (!dir.exists()) {
		// dir.mkdir();
		// }
		// }
		String tempFilePath = TEMP_FILE_PATH + FileUtils.renameToUUID(file.getOriginalFilename());
		File tempFile = null;
		try {
			tempFile = new File(tempFilePath);
			FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
		} catch (Exception e) {

		}

		// String img_url = null;
		//
		// COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		// ClientConfig clientConfig = new ClientConfig(new Region(regionName));
		// COSClient cosclient = new COSClient(cred, clientConfig);
		//
		// fullFileName = key + fullFileName;
		//
		// PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
		// fullFileName, upload);
		// //putObjectRequest.setStorageClass(StorageClass.Standard_IA);
		//
		// cosclient.putObject(putObjectRequest);
		// img_url = IMG_END_POINT + fullFileName;
		//
		// cosclient.shutdown();
		//
		// return img_url;

		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig clientConfig = new ClientConfig(new Region(regionName));
		COSClient cosclient = new COSClient(cred, clientConfig);

		String fileName = subDir + FileUtils.renameToUUID(file.getOriginalFilename());

		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, tempFile);
		// putObjectRequest.setStorageClass(StorageClass.Standard_IA);
		cosclient.putObject(putObjectRequest);
		cosclient.shutdown();
		String img_url = IMG_END_POINT + fileName;
		tempFile.delete();

		// delete(img_url);
		return img_url;
	}

	@Override
	public String save(MultipartFile file, String subDir, Boolean isDir ) {

		// // MultipartFile 转换为file
		// String filePath = subDir;
		// if (!file.isEmpty()) {
		// File dir = new File(filePath);
		// if (!dir.exists()) {
		// dir.mkdir();
		// }
		// }
		String tempFilePath = TEMP_FILE_PATH + FileUtils.renameToUUID(file.getOriginalFilename());
		File tempFile = null;
		try {
			tempFile = new File(tempFilePath);
			FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
		} catch (Exception e) {

		}

		// String img_url = null;
		//
		// COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		// ClientConfig clientConfig = new ClientConfig(new Region(regionName));
		// COSClient cosclient = new COSClient(cred, clientConfig);
		//
		// fullFileName = key + fullFileName;
		//
		// PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
		// fullFileName, upload);
		// //putObjectRequest.setStorageClass(StorageClass.Standard_IA);
		//
		// cosclient.putObject(putObjectRequest);
		// img_url = IMG_END_POINT + fullFileName;
		//
		// cosclient.shutdown();
		//
		// return img_url;

		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig clientConfig = new ClientConfig(new Region(regionName));
		COSClient cosclient = new COSClient(cred, clientConfig);

		String fileName = subDir + FileUtils.renameToUUID(file.getOriginalFilename());

		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, tempFile);
		// putObjectRequest.setStorageClass(StorageClass.Standard_IA);
		cosclient.putObject(putObjectRequest);
		cosclient.shutdown();
		String img_url = IMG_END_POINT + fileName;
		tempFile.delete();

		// delete(img_url);
		return img_url;
	}
	
	@Override
	public boolean delete(String fullFileName) {
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig clientConfig = new ClientConfig(new Region(regionName));
		COSClient cosclient = new COSClient(cred, clientConfig);
		String key = fullFileName.replace(IMG_END_POINT, "");
		cosclient.deleteObject(bucketName, key);
		cosclient.shutdown();
		return false;
	}

	// public static void main(String[] args) {
	// String fullFileName = SystemUtil.generateFileName() + ".jpg";
	// File upload = new File("/Users/Michael/Documents/test.jpg");
	// System.out.println(cosImageUpload(upload, fullFileName));
	//
	//
	// String url =
	// "http://kaonaer-1255712530.cosgz.myqcloud.com/files/img/20180124182848_594.jpg";
	// cosDeleteFile(url);
	// }

}