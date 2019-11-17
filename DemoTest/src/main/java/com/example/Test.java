package com.example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by LITP on 2016/9/21.
 */

public class Test  {

    @BeforeMethod
    public void BeforeMethod() throws IOException {

    }

    @BeforeClass
    public void beforeClass() {
    }


    @BeforeGroups
    public void beforeGroups() {

    }


    @BeforeSuite
    public void beforeSuite() throws MalformedURLException {

    }


    @BeforeTest
    public void beforeTest() {


    }


    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() {

    }

    @AfterGroups
    public void afterGroups() {

    }

    @AfterSuite
    public void afterSuite() {

    }

    @AfterTest
    public void afterTest() {

    }
}

