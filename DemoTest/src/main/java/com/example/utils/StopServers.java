package com.example.utils;

import java.util.List;
/**
 * 停止服务，测试完成之后，可以run这个文件，关闭appium服务
 *
 */

public class StopServers {


    public static void main(String[] args){
        stopServers();
    }


    /**
     * 停止 服务
     */
    public static void stopServers(){
        try {
            List<String> pidList = ServerCtrl.getStartPidList(ServerCtrl.getStartPortList());

            for(String pid:pidList){
                //傻吊进程
                ServerCtrl.killServerByPid(pid);
            }

            //删除设备文件
            //FileCtrl.delFile(FileCtrl.getModulePath()+"devicesInfo.xml");

        } catch (Exception e) {
            System.out.println("停止服务时候获取运行服务对应的进程pid失败"+e.getMessage());
            e.printStackTrace();
        }
    }

}
