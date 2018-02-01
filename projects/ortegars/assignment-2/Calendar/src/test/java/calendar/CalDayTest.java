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
		 
	 }
//add more unit tests as you needed	
}
