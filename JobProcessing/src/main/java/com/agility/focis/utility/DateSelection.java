package com.agility.focis.utility;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateSelection {

     public static String usingCalendar(int days) {
    	 
    	 SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
 		Calendar cal = Calendar.getInstance();
 		//System.out.println("Current Date: "+sdf.format(cal.getTime()));
 		//Adding 1 Day to the current date
 		cal.add(Calendar.DAY_OF_MONTH, days);
 		//Date after adding one day to the current date
 		String newDate = sdf.format(cal.getTime());
 		//Displaying the new Date after addition of 1 Day
 		return newDate.toString();
     }
     
     public static String timeInHHMM(){

 		LocalTime time = LocalTime.now();
 		String t = time.format(DateTimeFormatter.ofPattern("HH:mm"));
 		return t;
 		

 	}
     
     public static String addTimeInHHMM(int hrs) {
    	 
    	 LocalTime time = LocalTime.now();
  		String t = time.format(DateTimeFormatter.ofPattern("HH:mm"));
  		
  		
  		String[] hours=t.split(":");
  		
  		if(hrs<24) {
  		//System.err.println(hours);
  		 hrs=Integer.valueOf(hours[0])+hrs;
  		// System.out.println(Integer.toString(hrs));
  		}
  		else {
  			
  			System.err.println("Time hours should be with in the 24hrs");
  		}
  		 return Integer.toString(hrs)+":"+hours[1];
  		
  		 
     }


}
