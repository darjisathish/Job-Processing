package com.agility.focis.utility;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LogsTest {

	static Logger mainLogger = LogManager.getLogger(LogsTest.class.getName());
	
    public static void logsGeneration(Object object)
    {
    	BasicConfigurator.configure();
    	
    	ConsoleAppender appender = new ConsoleAppender();
    	 mainLogger.addAppender(appender);
    	 mainLogger.info(object);
    }
  
    }