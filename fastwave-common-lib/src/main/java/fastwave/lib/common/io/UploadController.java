package fastwave.lib.common.io;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fastwave.lib.common.web.R;
@RestController
@RequestMapping(value = {"/file"}, produces="application/json;charset=UTF-8")
public class UploadController {
	
	@Value("${web.upload-path}")
	private String uploadPath;
	
	@Value("${web.upload-ip}")
	private String uploadIp;
	
	@Value("${server.port}")
	private String applicationPort;
	
	/**
	 * @Description 文件上报
	 * @param 文件
	 * @return 是否保存文件至指定位置
	 */
	@PostMapping("/upload_notCheck")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file) {
		//文件上传的格式限制，如果没有限制或者有别的限制请注释掉，下面是上传图片的格式！ 
		boolean result = FileUtils.isPhoto(file.getOriginalFilename());
		if(!result) {
			return R.error("文件并不符合图片的格式！请核实后在选择！");
		}
		//保存文件至指定位置，并返回操作结果
		IFileAccess fileAccess = FileAccessFactory.getDefaultFileAccess();
		try {
			//String fileName = fileAccess.save(file);
			String fileUrl="http://"+uploadIp+":"+applicationPort+"/";
			fileUrl += fileAccess.save(file,uploadPath,true);
			Map<String, Object> uploadmap =new HashMap<String, Object>();
			uploadmap.put("code", 200);
			uploadmap.put("message", "上传成功！");
			uploadmap.put("fileUrl", fileUrl);
			return uploadmap;
		} catch (IOException e) {
			e.printStackTrace();
			return  R.error("上传失败！请重新尝试！");
		}	
	}

}
