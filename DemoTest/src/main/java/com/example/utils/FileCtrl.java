package com.example.utils;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

/**
 *文件的控制类,获取log，xml文件的路径
 */


public class FileCtrl {
    /**
     * 获取桌面路径
     * @return
     */
    private static String getDesktopPath(){
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com=fsv.getHomeDirectory();    //这便是读取桌面路径的方法了
        return com.getAbsolutePath();
    }
    /**
     * 获取当前项目路径
     * @return
     */
    public  static String getProjectPath(){
        return System.getProperty("user.dir")+"autotest/src/main/java/com/example/utils/";
    }

    public  static String getModulePath(){
        return System.getProperty("user.dir")+"/autotest/";
    }

    public  static String getLogsPath(){
        return getModulePath()+"src/main/java/com/example/logs/";
    }

    public  static String getPackageName(){
        return "com.example.cases.";
    }


    /**
     * 删除文件
     * @return
     */
    public static boolean delFile(String filePth){
        boolean flag = false;
        File file = new File(filePth);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            if(file.delete()){
                flag = true;
                System.out.println("删除文件成功:"+filePth);
            }else{
                System.out.println("删除文件失败:"+filePth);
            }
        }
        return flag;
    }

}
