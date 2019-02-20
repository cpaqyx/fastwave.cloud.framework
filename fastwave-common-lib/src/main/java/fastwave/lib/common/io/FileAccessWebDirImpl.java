package fastwave.lib.common.io;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileAccessWebDirImpl implements IFileAccess {

	private static String ROOTPATH = "/uploadFile/";
	private static String DEFAULT_SUBDIR_PATH = "default/";
	private static String DEFAULT_PREVFIX = "thumb_";
	private static Boolean DEFAULT_FORCE = false;//建议该值为false
	private static Integer image_width =100;//缩略图宽  单位为像素
	private static Integer image_height = 150;//缩略图高  单位为像素
	
	@Override
	public String save(MultipartFile file) throws IOException {
		return save(file, DEFAULT_SUBDIR_PATH);
	}

	@Override
	public String save(MultipartFile file, String subDir) throws IOException {
		String fileName = file.getOriginalFilename();
		fileName = FileUtils.renameToUUID(fileName);
		String webRootDir = ResourceUtils.getURL("classpath:").getPath().substring(1) + "templates";
		
		//ApplicationHome webRootDir = new ApplicationHome(getClass());
		
		String absPath = webRootDir + ROOTPATH + subDir + fileName;
		String relaPath = ROOTPATH + subDir + fileName;
		
		System.out.println("absultion path:"+absPath);
		System.out.println("relative path:"+relaPath);

		File targetFile = new File(absPath);
		if (!targetFile.getParentFile().exists()) {
			targetFile.getParentFile().mkdirs();
		}

		file.transferTo(targetFile);
		FileUtils.thumbnailImage(absPath,image_width,image_height,DEFAULT_PREVFIX,DEFAULT_FORCE);
		return relaPath;
    }
	
	@Override
	public String save(MultipartFile file, String Dir, Boolean isDir) throws IOException {
		String fileName = file.getOriginalFilename();
		fileName = FileUtils.renameToUUID(fileName);
		String webRootDir = ResourceUtils.getURL("classpath:").getPath().substring(1) + "templates";
		
		
		String absPath = Dir+"/" + fileName;
		String relaPath = fileName;
		
		System.out.println("absultion path:"+absPath);
		System.out.println("relative path:"+relaPath);

		File targetFile = new File(absPath);
		if (!targetFile.getParentFile().exists()) {
			targetFile.getParentFile().mkdirs();
		}

		file.transferTo(targetFile);
		FileUtils.thumbnailImage(absPath,image_width,image_height,DEFAULT_PREVFIX,DEFAULT_FORCE);
		return relaPath;
    }
	@Override
	public boolean delete(String fullFileName) {
		File file = new File(fullFileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
