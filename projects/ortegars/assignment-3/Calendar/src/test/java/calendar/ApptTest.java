package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;
import java.util.Random;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void test02()  throws Throwable  {
		  Random rand = new Random();
		  int startHour=rand.nextInt(24);
		  int startMinute=rand.nextInt(60);
		  int startDay=rand.nextInt(27)+1;
		  int startMonth=rand.nextInt(12)+1;
		  int startYear=rand.nextInt(20)+2000;
		  String title="Test Appointment";
		  String description="A randomly generated appt";
		  String testString;
		  
		  Appt appt = new Appt(startHour, 
			startMinute, 
			startDay, 
			startMonth, 
			startYear, 
			title, 
			description);
		  
		  Appt temp = new Appt(12, 35, 12, 1, 2008, "Counter appt", "Second test");
			
		for(int i = 0; i<10000; i++){
			assertTrue(appt.getValid());
			assertEquals(-1*appt.compareTo(temp), temp.compareTo(appt));
			
			testString=appt.toString();
			
			if(appt.getStartDay()>15){
				appt.setStartDay(appt.getStartDay()+18);
				assertTrue(!appt.getValid());
			}
			else{
				appt.setStartDay(appt.getStartDay()-18);
				assertTrue(!appt.getValid());
			}
			if(appt.getStartHour()>12){
				appt.setStartHour(appt.getStartDay()+12);
				assertTrue(!appt.getValid());
			}
			else{
				appt.setStartHour(appt.getStartDay()-12);
				assertTrue(!appt.getValid());
			}
			if(appt.getStartMinute()>30){
				appt.setStartMinute(appt.getStartMinute()+30);
				assertTrue(!appt.getValid());
			}
			else{
				appt.setStartMinute(appt.getStartMinute()-30);
				assertTrue(!appt.getValid());
			}
			if(appt.getStartMonth()>6){
				appt.setTitle(null);
				appt.setDescription(null);
				testString=appt.toString();
				//assertTrue(testString);
				
				//assertEquals(appt.toString(), "\t");
				//assertTrue(!appt.getValid());
			}
			else{
				appt.setRecurrence(null,0,0,0);
				assertEquals(0, appt.getRecurNumber());
				assertEquals(0, appt.getRecurBy());
				assertEquals(0, appt.getRecurIncrement());
				assertTrue(!appt.isRecurring());
				//assertEquals(null, appt.getRecurDays());
				//assertTrue(!appt.getValid());
			}
			
			appt.setStartHour(rand.nextInt(24));
			appt.setStartMinute(rand.nextInt(60));
			appt.setStartDay(rand.nextInt(27)+1);
			appt.setStartMonth(rand.nextInt(12)+1);
			appt.setStartYear(rand.nextInt(20)+2000);/*
			startHour=rand.nextInt(24);
			startMinute=rand.nextInt(60);
			startDay=rand.nextInt(28)+1;
			startMonth=rand.nextInt(12)+1;
			startYear=rand.nextInt(20)+2000;
			
			appt = new Appt(startHour, 
			  startMinute, 
			  startDay, 
			  startMonth, 
			  startYear, 
			  title, 
			  description);*/
		}
	 }
	 
	 @Test
	  public void test03() throws Throwable{
		  int startHour=14;
		  int startMinute=55;
		  int startDay=25;
		  int startMonth=2;
		  int startYear=2018;
		  String title="Test Appointment";
		  String description="A valid appointment";
		  String testString;
		  
		  int[] recurDays = {26,27,28};
		  int recurBy = 28;
		  int recurIncrement = 1;
		  int recurNumber = 3;
		  
		  Appt appt = new Appt(startHour, 
		    startMinute, 
			startDay, 
			startMonth, 
			startYear,
			title,
			description);
		  Appt appt2 = new Appt(10, 
		    50, 
			24, 
			1, 
			2017,
			title,
			description);
		  assertNotNull(appt.getRecurBy());
		  appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
		  
		  assertNotNull(appt.getRecurDays());
		  assertNotNull(appt.toString());
		  assertEquals(appt.compareTo(appt2), 12);
		  assertEquals(appt.getRecurNumber(), 3);
		  assertEquals(appt.getRecurBy(), 28);
		  assertEquals(appt.getRecurIncrement(), 1);
		  assertArrayEquals(appt.getRecurDays(), recurDays);
		  assertTrue(appt.isRecurring());
		  
		  assertEquals(appt.toString(), "\t2/25/2018 at 2:55pm ,Test Appointment, A valid appointment\n");
		  appt.setStartHour(11);
		  assertEquals(appt.toString(), "\t2/25/2018 at 11:55am ,Test Appointment, A valid appointment\n");
		  appt.setStartHour(26);
		  assertNull(appt.toString());
	 }
//add more unit tests as you needed
	
}
