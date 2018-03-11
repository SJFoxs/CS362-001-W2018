package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		GregorianCalendar today = new GregorianCalendar(2018, 1, 23);
		Appt temp = new Appt(12, 35, 23, 1, 2018, "Counter appt", "First test");
		Appt invalidAppt = new Appt(12, 71, 23, 1, 2018, "Invalid appt", "Second test");
		Appt tThree = new Appt(10, 35, 23, 1, 2018, "Counter appt", "Third test");
		
		CalDay testDay= new CalDay(today);
		CalDay invalidDay = new CalDay();
		
		assertTrue(testDay.isValid());
		assertTrue(!invalidDay.isValid());
		
		assertEquals(2018, testDay.getYear());
		assertEquals(1, testDay.getMonth());
		assertEquals(23, testDay.getDay());
		assertEquals(0, testDay.getSizeAppts());
		//testDay.setAppts(testDay.getAppts());
		testDay.addAppt(invalidAppt);
		testDay.addAppt(temp);
		testDay.addAppt(tThree);
		testDay.addAppt(temp);
		//invalidDay.addAppt(temp);
		String validateString = testDay.toString();
		validateString = invalidDay.toString();
		
		//Iterator<Appt> i = invalidDay.iterator();

	 }
	 @Test
	  public void test02()  throws Throwable  {
		  int startHour=14;
		  int startMinute=55;
		  int startDay=24;
		  int startMonth=2;
		  int startYear=2018;
		  String title="Test Appointment";
		  String description="A valid appointment";
		  GregorianCalendar date = new GregorianCalendar(2018, 2, 24);
		  		  
		  Appt appt = new Appt(startHour, 
		    startMinute, 
			startDay, 
			startMonth, 
			startYear,
			title,
			description);
			
		  Appt appt2 = new Appt(startHour, 
		    startMinute, 
			startDay, 
			startMonth, 
			startYear,
			title,
			description);
			
		  CalDay day = new CalDay(date);
		  assertNotNull(day.getAppts());
		  day.addAppt(appt);
		  assertNotNull(day.toString());
	 }
	 @Test
	  public void test03() throws Throwable  {
		  Appt validAppt = new Appt(12, 35, 23, 1, 2018, "Counter appt", "First test");
		  Appt invalidAppt = new Appt(11, 71, 23, 1, 2018, "Invalid appt", "Second test");
		  Appt vAppt = new Appt(10, 35, 23, 1, 2018, "Counter appt", "Third test");
		  Appt ivAppt = new Appt(24, 71, 23, 1, 2018, "Invalid appt", "Fourth test");
		  Appt vaAppt = new Appt(10, 45, 23, 1, 2018, "Counter appt", "Fifth test");
		  
		  GregorianCalendar date = new GregorianCalendar(2018, 1, 23);
		  
		  CalDay today = new CalDay(date);
		  CalDay ivDay = new CalDay();
		  //today.addAppt(invalidAppt);
		  CalDay testDay = new CalDay(date);
		  
		  
		  today.addAppt(validAppt);
		  today.addAppt(invalidAppt);
		  today.addAppt(vAppt);
		  
		  testDay.addAppt(vAppt);
		  testDay.addAppt(ivAppt);
		  testDay.addAppt(validAppt);
		  testDay.addAppt(invalidAppt);
		  testDay.addAppt(vAppt);
		  testDay.addAppt(vaAppt);
		  
		  assertEquals(testDay.getAppts().get(0), vAppt);
		  assertEquals(testDay.getAppts().size(), 4);
		  assertEquals(testDay.getAppts().get(2), vaAppt);
		  assertNotNull(testDay.iterator());
		  assertNull(ivDay.iterator());
		  assertNotNull(testDay.getAppts());
	  }
//add more unit tests as you needed	
}
