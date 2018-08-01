package me.huqiao.smallcms.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.jfree.util.Log;

import me.huqiao.smallcms.common.entity.CommonFile;
import me.huqiao.smallcms.common.entity.CommonFolder;
import me.huqiao.smallcms.common.entity.enumtype.UseStatus;
import net.coobird.thumbnailator.Thumbnails;

/**
 * 文件操作工具类
 * @author NOVOTS
 * @version Version 1.0
 */
public class FileUtil {
	
	final static Logger log = Logger.getLogger(FileUtil.class);
	/**
	 * 获取文件扩展名
	 * @param originalFilename 初始文件名
	 * @return String 扩展名
	 */
	public static String getExtensionName(String originalFilename){
		if(originalFilename==null || originalFilename.trim().equals("")){
			return "";
		}
		return originalFilename.substring(originalFilename.lastIndexOf("."));
	}

	
	/**
	 * 保存文件到磁盘，如果该文件已经存在则将会被覆盖
	 * @param path 路径
	 * @param fileName 文件名
	 * @param data 数据
	 * @throws IOException 输入输出异常
	 */
	public static void saveFileOnDisk(String path,String fileName,byte[] data,ThumbInfo thumbInfo) throws IOException{
		File parentDir = new File(path);
		if(!parentDir.exists()){
			parentDir.mkdirs();
		}
		File file = new File(parentDir,fileName);
		if(!file.exists()){
			file.createNewFile();
		}
		saveFileOnDisk(file,data,thumbInfo);
	}
	
	/**
	 * 保存文件到磁盘，如果该文件已经存在则将会被覆盖
	 * @param path 路径
	 * @param fileName 文件名
	 * @param is 数据
	 * @throws IOException 输入输出异常
	 */
	public static List<CommonFile> saveFileOnDisk(String path,String fileName,InputStream is,ThumbInfo thumbInfo) throws IOException{
		File parentDir = new File(path);
		if(!parentDir.exists()){
			parentDir.mkdirs();
		}
		File file = new File(parentDir,fileName);
		if(!file.exists()){
			file.createNewFile();
		}
		return saveFileOnDisk(file,is,thumbInfo);
	}
	
	/**
	 * 保存文件到磁盘，如果该文件已经存在则将会被覆盖
	 * @param file 文件
	 * @param data 数据
	 * @throws IOException 输入输出异常
	 */
	public static List<CommonFile> saveFileOnDisk(File file,byte[] data,ThumbInfo thumbInfo) throws IOException{
		FileOutputStream fos = new FileOutputStream(file,false);
		fos.write(data);
		fos.close();
		
		if(thumbInfo!=null){
			List<CommonFile> cfiles = createThumbImage(file, thumbInfo);
			return cfiles;
		}else{
			return null;
		}
	}


	public static List<CommonFile> createThumbImage(File file, ThumbInfo thumbInfo)throws IOException {
		List<CommonFile> res = new ArrayList<CommonFile>();
		CommonFile xfile = createXFile(file, 
				file.getName() + "_x",
				thumbInfo.getExtensionName(),
				thumbInfo.getName(),
				thumbInfo.getFolder(),
				thumbInfo.getWidth(), 
				thumbInfo.getHeight());
		CommonFile big = createXFile(file, 
				file.getName() + "_big",
				thumbInfo.getExtensionName(),
				thumbInfo.getName(),
				thumbInfo.getFolder(),
				500, 
				500);
		CommonFile small = createXFile(file, 
				file.getName() + "_small",
				thumbInfo.getExtensionName(),
				thumbInfo.getName(),
				thumbInfo.getFolder(),
				150, 
				150);
		if(xfile!=null){
			res.add(xfile);
		}
		if(big!=null){
			res.add(big);
		}
		if(small!=null){
			res.add(small);
		}
		return res;
	}


	private static CommonFile createXFile(File file, String key,String ext,String name,CommonFolder folder,int width,int height)
			throws IOException {
		CommonFile cfile = new CommonFile();
		cfile.setInuse(UseStatus.UnUse);
		cfile.setCreateDate(new Date());
		cfile.setManageKey(key);
		cfile.setExtensionName(ext);
		cfile.setName(name);
		cfile.setStoreName("");
		cfile.setFolder(folder);
		BufferedImage bimg = null;
		if(file.getName().indexOf(".")<0){
			File tmp = new File(file.getAbsolutePath() + (ext.indexOf(".") >=0 ? "" : ".") + ext);
			if(!tmp.exists()){
				tmp.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(tmp);
			FileInputStream fis = new FileInputStream(file);
			IOUtils.copy(fis, fos);
			fis.close();
			fos.close();
			try{
				bimg = Thumbnails.of(tmp).size(width,height).keepAspectRatio(true).asBufferedImage();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else{
			try{
				bimg = Thumbnails.of(file).size(width,height).keepAspectRatio(true).asBufferedImage();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(ext.startsWith(".")){
			ext = ext.substring(1);
		}
		if(bimg!=null){
			ImageIO.write(bimg, ext, new File(cfile.getFullName()));
			log.info("create file:" + cfile.getFullName());
			return cfile;
		}else{
			return null;
		}
	}
	
	/**
	 * 保存文件到磁盘，如果该文件已经存在则将会被覆盖
	 * @param file 文件
	 * @param is 数据
	 * @throws IOException 输入输出异常
	 */
	public static List<CommonFile> saveFileOnDisk(File file,InputStream is,ThumbInfo thumbInfo) throws IOException{
		FileOutputStream fos = new FileOutputStream(file,false);
		byte[] buffer = new byte[1024*1024*10];
		int len;
		try{
			while((len=is.read(buffer))!=-1){
				fos.write(buffer,0,len);
			}
		}catch(Exception e){}finally{
			try{
				fos.close();
			}catch(Exception e){}finally{
				try{
					is.close();
				}catch(Exception e){}
			}
		}

		if(thumbInfo!=null){
			List<CommonFile> cfiles = createThumbImage(file, thumbInfo);
			return cfiles;
		}else{
			return null;
		}
	}
	
	
	/**
	 * 保存文件到磁盘，如果该文件已经存在则将会被覆盖
	 * @param file 文件
	 * @param data 数据
	 * @throws IOException 输入输出异常
	 */
	public static void saveFileOnDisk(File file,String data,ThumbInfo thumbInfo) throws IOException{
		saveFileOnDisk(file,data.getBytes(),thumbInfo);
	}
	
	
	/**
	 * 删除文件，可以是单个文件或文件夹 
	 * @param fileName 文件名
	 * @return boolean 操作是否成功
	 */
    public static boolean delete(String fileName){
        File file = new File(fileName);
        if(!file.exists()){
            return false;
        } else {
            if(file.isFile())
                return deleteFile(fileName);  
            else
                return deleteDirectory(fileName);
        }
    }
    
    /**
     * 删除目录（文件夹）以及目录下的文件  
     * @param dir 目录
     * @return boolean 操作结果
     */
    private static boolean deleteDirectory(String dir) {
        //如果dir不以文件分隔符结尾，自动添加文件分隔符
        if(!dir.endsWith(File.separator))  
            dir = dir+File.separator;
        File dirFile = new File(dir);
        //如果dir对应的文件不存在，或者不是一个目录，则退出    
        if(!dirFile.exists() || !dirFile.isDirectory()){ 
            return false;
        }
        boolean flag = true;     
        //删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for(File file : files){
            //删除子文件
            if(file.isFile()){  
                flag = deleteFile(file.getAbsolutePath()); 
                if(!flag)
                    break;
            }
           //删除子目录
            else {
                flag = deleteDirectory(file.getAbsolutePath()); 
                if(!flag)
                    break;
            }
        }
        if(!flag)
            return false;
        //删除当前目录
        if(dirFile.delete())
            return true;
        else
            return false;
    }
   
    /**
     * 删除单个文件 
     * @param fileName 要删除文件名
     * @return boolean 删除结果
     */
    private static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if(file.isFile() && file.exists()){
            file.delete();
            return true; 
        } else {
            return false;
        }
    }
    
    /**
     * 根据文件路径判断文件是否为图片
     * @param filePath 文件路径
     * @return boolean 是否为图片
     */
    public static boolean isImage(String filePath){
    	boolean valid = true;
    	try {
    	    BufferedImage image=ImageIO.read(new File(filePath));
    	    if (image == null) {
    	        valid = false;
    	    }
    	} catch(IOException ex) {
    	    valid=false;
    	}
    	return valid;
    }
}
