package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void randomtest() throws Throwable {
		  try{
			  GregorianCalendar today = new GregorianCalendar(2018, 1, 23);
			  CalDay day = new CalDay(today);
			  long randomseed =System.currentTimeMillis();
			  Random random = new Random(randomseed);
			  int startHour=random.nextInt(41);
              int startMinute=random.nextInt(80);
              int startDay=random.nextInt(45);
              int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
              int startYear=random.nextInt(2500);
              String title="Birthday Party";
              String description="This is my birthday party.";
                               
              Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
			  int counter=0;
			  
			  for(int i = 0; i<1000; i++){
				  //if(ValuesGenerator.getBoolean(.75f, random)){
					  day.addAppt(appt);
					  if(appt.getValid()){ counter++;}
					  //System.out.println("CalDay size:"+counter+" Base:"+ day.getAppts().get(0).getStartHour()+" Appt: " +appt.getStartHour());}
				  //}
				  
				  assertEquals(day.getAppts().size(),counter);
				  
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
		  } catch(NullPointerException e){
		  }
		 
		 
		 
	 }


	
}
