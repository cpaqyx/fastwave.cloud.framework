package fastwave.lib.common.io;

public class FileAccessFactory {
	public static IFileAccess getDefaultFileAccess()
	{
		return new FileAccessWebDirImpl();
	}
	
	public static IFileAccess getCOSFileAccess()
	{
		return new FileAccessCOSImpl();
	}
	
	public static IFileAccess getWebDirAccess()
	{
		return new FileAccessWebDirImpl();
	}
}
