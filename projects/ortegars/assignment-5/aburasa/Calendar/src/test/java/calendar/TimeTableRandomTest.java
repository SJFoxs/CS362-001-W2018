package calendar;
import java.util.*;
//import java.util.Calendar;
//import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {
		TimeTable tt = new TimeTable();
		
		long randomseed =System.currentTimeMillis();
		Random random = new Random(randomseed);
		int startHour=random.nextInt(41);
        int startMinute=random.nextInt(80);
        int startDay=random.nextInt(45);
        int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
        int startYear=random.nextInt(2500);
        String title="Birthday Party";
        String description="This is my birthday party.";
		
		int sz = 0;
		LinkedList<Appt>testList = new LinkedList<Appt>();
		LinkedList<Appt>listAppt = new LinkedList<Appt>();
		LinkedList<CalDay>testDays = new LinkedList<CalDay>();
                               
        Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
		Appt invAppt = new Appt(-10, -10, 1,1,2000, null, null);
		Appt vAppt = new Appt(10, 10, 1,1,2000, "valid", "appt");
		
		for(int i=0; i<100; i++){
			testList.add(appt);
			listAppt.add(appt);
			sz++;
			startHour=ValuesGenerator.getRandomIntBetween(random, 0, 25);
            startMinute=ValuesGenerator.getRandomIntBetween(random, -20, 60);
            startDay=ValuesGenerator.getRandomIntBetween(random, 23, 24);
			startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 2);
            startYear=ValuesGenerator.getRandomIntBetween(random, 2017, 2018);
				  
			appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
		}
		
		for(int i=0; i<100; i++){
			switch(ValuesGenerator.getRandomIntBetween(random, 0, 4)){
				case 0:
					listAppt = tt.deleteAppt(listAppt, null);
					break;
				case 1:
					listAppt = tt.deleteAppt(null, testList.get(ValuesGenerator.getRandomIntBetween(random, 0, sz-1)));
					break;
				case 2:
					listAppt = tt.deleteAppt(listAppt, invAppt);
					break;
				case 3:
					listAppt = tt.deleteAppt(listAppt, vAppt);
					break;
				default:
					listAppt = tt.deleteAppt(listAppt, testList.get(ValuesGenerator.getRandomIntBetween(random, 0, sz-1)));
			}
			
			if(listAppt == null)
				listAppt = new LinkedList(testList);
		}
		 
		 
		 
	 }
	 /*
	 @Test
	  public void randomtest01()  throws Throwable  {
		TimeTable tt = new TimeTable();
		
		long randomseed =System.currentTimeMillis();
		Random random = new Random(randomseed);
		int startHour=random.nextInt(41);
        int startMinute=random.nextInt(80);
        int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 14);
        int startMonth=1;//ValuesGenerator.getRandomIntBetween(random, 1, 12);
        int startYear=random.nextInt(2500);
        String title="Birthday Party";
        String description="This is my birthday party.";
		
		GregorianCalendar firstDay = new GregorianCalendar(2018, 1, ValuesGenerator.getRandomIntBetween(random, 1, 31));
		GregorianCalendar lastDay = new GregorianCalendar(2018, 1, ValuesGenerator.getRandomIntBetween(random, 1, 31));
		
		int sz = 0;
		LinkedList<Appt>testList = new LinkedList<Appt>();
		LinkedList<Appt>listAppt = new LinkedList<Appt>();
		LinkedList<CalDay>testDays = new LinkedList<CalDay>();
                               
        Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
		Appt invAppt = new Appt(-10, -10, 1,1,2000, null, null);
		Appt vAppt = new Appt(10, 10, 1,1,2000, "valid", "appt");
		
		for(int i=0; i<10; i++){
			testList.add(appt);
			listAppt.add(appt);
			sz++;
			startHour=ValuesGenerator.getRandomIntBetween(random, 0, 25);
            startMinute=ValuesGenerator.getRandomIntBetween(random, -20, 60);
            startDay=ValuesGenerator.getRandomIntBetween(random, 1, 14);
			startMonth=1;//ValuesGenerator.getRandomIntBetween(random, 1, 2);
            startYear=ValuesGenerator.getRandomIntBetween(random, 2017, 2018);
				  
			appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
		}
		for(int i=0; i<50; i++){
			if(firstDay.before(lastDay)){
				testDays=tt.getApptRange(testList, firstDay, lastDay);
			}
			
			firstDay = new GregorianCalendar(2018, 1, ValuesGenerator.getRandomIntBetween(random, 1, 31));
			lastDay = new GregorianCalendar(2018, 1, ValuesGenerator.getRandomIntBetween(random, 1, 31));
		}
	}*/


	
}
