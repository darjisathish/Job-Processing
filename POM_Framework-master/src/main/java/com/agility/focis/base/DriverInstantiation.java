package com.agility.focis.base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverInstantiation {
    public static WebDriver driver;

    public static void setDriver() throws IOException {
        String browser = getBrowserType();
        if (browser.equalsIgnoreCase("Chrome")) {
//            ChromeOptions options = new ChromeOptions();
            if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//                options.setPageLoadStrategy(PageLoadStrategy.EAGER);

            }
            driver = new ChromeDriver();

        }
    }

    
    public static WebDriver getDriver() {
        return driver;
    }

    public static String getBrowserType() throws IOException {
        String browserType = "Chrome";
        File properties = new File("src/test/resources/execution/executionProperties.properties");
        FileInputStream fileInputStream = new FileInputStream(properties);
        Properties prop = new Properties();
        prop.load(fileInputStream);
        browserType = prop.getProperty("Browser");
        return browserType;

    }

    public String loginURL() throws IOException {
        String loginURL = "";
        String profile = getProfile();
        try {
            File fXmlFile = new File("src/test/resources/config/profiles.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Profile");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getElementsByTagName("Name")
                            .item(0).getTextContent().equalsIgnoreCase(profile)) {
                        loginURL = eElement.getElementsByTagName("URL")
                                .item(0).getTextContent();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginURL;
    }

    public String getProfile() throws IOException {
        String profile = "";
        File properties = new File("src/test/resources/execution/executionProperties.properties");
        FileInputStream fileInputStream = new FileInputStream(properties);
        Properties prop = new Properties();
        prop.load(fileInputStream);
        profile = prop.getProperty("profile");
        return profile;
    }

    public String getUserName() throws IOException {
        String loginURL = "";
        String profile = getProfile();
        try {
            File fXmlFile = new File("src/test/resources/config/profiles.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Profile");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getElementsByTagName("Name")
                            .item(0).getTextContent().equalsIgnoreCase(profile)) {
                        loginURL = eElement.getElementsByTagName("UserName")
                                .item(0).getTextContent();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginURL;
    }

    public String getPassword() throws IOException {
        String loginURL = "";
        String profile = getProfile();
        try {
            File fXmlFile = new File("src/test/resources/config/profiles.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Profile");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getElementsByTagName("Name")
                            .item(0).getTextContent().equalsIgnoreCase(profile)) {
                        loginURL = eElement.getElementsByTagName("Password")
                                .item(0).getTextContent();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginURL;
    }
}
