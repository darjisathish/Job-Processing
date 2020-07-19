package com.agility.focis.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class RenameTheEmailReport {

	@Test
	public static void withTimestamp() {
		
		// To get time stamp along with time
				String timestamp = new SimpleDateFormat("YYYYMMdd HH:mm:ss").format(Calendar.getInstance().getTime()).replaceAll(":", "-");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String reportFullPath = System.getProperty("user.dir") + "\\test-output\\" + timestamp + ".html";
				System.out.println(reportFullPath);

		        // To get the current report folder
				File oldName = 
						new File(System.getProperty("user.dir")+"\\test-output\\emailable-report"+".html"); 

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				
				File newName =

						new File(System.getProperty("user.dir") + "\\test-output\\"+timestamp+".html");



				if (oldName.renameTo(newName)) 
				{
					System.err.println("Renamed successfully");         

				}
				else {

					System.err.println("not yet");
				}

				System.err.println("End");

			}
	}

