package fastwave.lib.common.io;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IFileAccess {
	/**
	 * 
	 * @param file controller接收到的文件流
	 * @param subDir：
	 * @return
	 */
	public String save(MultipartFile file, String subDir) throws IOException;
	
	/**
	 * 
	 * @param file controller接收到的文件流
	 * @param subDir：
	 * @return
	 */
	public String save(MultipartFile file, String subDir, Boolean isDir ) throws IOException;
	
	/**
	 * 
	 * @param file controller接收到的文件流
	 * @param fullFileName：完整的文件名
	 * @return
	 */
	public String save(MultipartFile file) throws IOException;
	
	
	/**
	 * 
	 * @param fullFileName
	 * @return
	 */
	public boolean delete(String fullFileName);
}
