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
		  int startDay=rand.nextInt(28)+1;
		  int startMonth=rand.nextInt(12)+1;
		  int startYear=rand.nextInt(20)+2000;
		  String title="Test Appointment";
		  String description="A randomly generated appt";
		  
		  Appt appt = new Appt(startHour, 
			startMinute, 
			startDay, 
			startMonth, 
			startYear, 
			title, 
			description);
		  
		  Appt temp = new Appt(12, 35, 12, 1, 2008, "Counter appt", "Second test");
			
		for(int i = 0; i<50; i++){
			assertTrue(appt.getValid());
			assertEquals(-1*appt.compareTo(temp), temp.compareTo(appt));
			
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
				assertEquals(appt.toString(), "\t");
				//assertTrue(!appt.getValid());
			}
			else{
				appt.setRecurrence(null,0,0,0);
				assertEquals(0, appt.getRecurNumber());
				assertEquals(0, appt.getRecurBy());
				assertEquals(0, appt.getRecurIncrement());
				//assertEquals(null, appt.getRecurDays());
				//assertTrue(!appt.getValid());
			}
			
			appt.setStartHour(rand.nextInt(24));
			appt.setStartMinute(rand.nextInt(60));
			appt.setStartDay(rand.nextInt(28)+1);
			appt.setStartMonth(rand.nextInt(12)+1);
			appt.setStartYear(rand.nextInt(20)+2000);
		}
	 }
//add more unit tests as you needed
	
}
