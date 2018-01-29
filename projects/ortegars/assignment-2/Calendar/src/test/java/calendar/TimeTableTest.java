package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		TimeTable tt = new TimeTable();
		LinkedList<Appt> unsortedAppts = new LinkedList<Appt>();
		
		Appt apptOne = new Appt(12, 35, 23, 1, 2018, "Counter appt", "First test");
		Appt apptTwo = new Appt(15, 35, 23, 1, 2018, "Counter appt", "Second test");
		Appt apptThree = new Appt(10, 35, 23, 1, 2018, "Counter appt", "Third test");
		Appt apptFour = new Appt(12, 35, 24, 1, 2018, "Counter appt", "Fourth test");
		
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		
		unsortedAppts = tt.deleteAppt(unsortedAppts, null);
		
		unsortedAppts = new LinkedList<Appt>();
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		unsortedAppts = tt.deleteAppt(null, apptOne);
		
		unsortedAppts = new LinkedList<Appt>();
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		 
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed
}
