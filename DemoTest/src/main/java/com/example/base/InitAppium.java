package com.example.base;

import org.apache.http.util.TextUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * 测试用例的父类
 * Created by LITP on 2016/9/7.
 */
@Listeners({com.example.base.AssertionListener.class})
public class InitAppium {
    //调试设备名字
    public static String deviceName = "minote";
    //调试设备系统版本
    public static String platformVersion = "4.4.2";
    //app路径
    public static String appPath = System.getProperty("user.dir") + "/src/main/java/apps/shouhu2.2.3.apk";

    //包名
    public static String appPackage = "com.minstone.mdoctor";

    //是否需要重新安装
    public static String noReset = "True";

    //是否不重新签名
    public static String noSign = "True";

    //是否使用unicode输入法，真是支持中文
    public static String unicodeKeyboard = "True";

    //是否祸福默认呢输入法
    public static String resetKeyboard = "True";

    //要启动的Activity
    //public static String appActivity = appPackage + ".activity.login.WelcomeActivity";
    public static String appActivity = "";

    public static  AndroidDriver<AndroidElement> driver = null;


    //构造方法
    public InitAppium() {
        this(new Builder());
    }

    public InitAppium(Builder builder) {

        appActivity = builder.appActivity;
        appPackage = builder.appPackage;
        appPath = builder.appPath;
        deviceName = builder.deviceName;
        noReset = builder.noReset;
        noSign = builder.noSign;
        unicodeKeyboard = builder.unicodeKeyboard;
        resetKeyboard = builder.resetKeyboard;
    }

    /**
     * appium启动参数
     *
     * @throws MalformedURLException
     */
    @BeforeSuite
    public void beforeSuite() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("app", new File(appPath).getAbsolutePath());
        capabilities.setCapability("appPackage", appPackage);
        //支持中文
        capabilities.setCapability("unicodeKeyboard", unicodeKeyboard);
        //运行完毕之后，变回系统的输入法
        capabilities.setCapability("resetKeyboard", resetKeyboard);
        //不重复安装
        capabilities.setCapability("noReset", noReset);
        //不重新签名
        capabilities.setCapability("noSign", noSign);
        //打开的activity
        if(!TextUtils.isEmpty(appActivity)){
            capabilities.setCapability("appActivity", appActivity);
        }

        //启动Driver
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @AfterClass
    public void afterClass(){
        //每一个用例完毕结束这次测试
        //driver.quit();
    }

    /**
     * 打印字符
     *
     * @param str 要打印的字符
     */
    public <T> void print(T str) {
        if (!TextUtils.isEmpty(String.valueOf(str))) {
            System.out.println(str);
        } else {
            System.out.println("输出了空字符");
        }
    }

}
