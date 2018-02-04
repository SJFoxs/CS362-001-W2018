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
		LinkedList<CalDay> apptRange = new LinkedList<CalDay>();
		GregorianCalendar today = new GregorianCalendar(2018, 1, 23);
		GregorianCalendar tomorrow = new GregorianCalendar(2018, 1, 24);
		
		Appt apptOne = new Appt(12, 35, 23, 1, 2018, "Counter appt", "First test");
		Appt apptTwo = new Appt(15, 35, 23, 1, 2018, "Counter appt", "Second test");
		Appt apptThree = new Appt(10, 35, 23, 1, 2018, "Counter appt", "Third test");
		Appt apptFour = new Appt(12, 35, 24, 1, 2018, "Counter appt", "Fourth test");
		Appt apptFive = new Appt(12, 71, 23, 1, 2018, "Invalid appt", "Fifth test");
		
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
		
		unsortedAppts = tt.deleteAppt(null, null);
		
		unsortedAppts = new LinkedList<Appt>();
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		
		unsortedAppts = tt.deleteAppt(unsortedAppts, apptTwo);
		
		unsortedAppts = tt.deleteAppt(unsortedAppts, apptTwo);
		
		unsortedAppts = new LinkedList<Appt>();
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		
		unsortedAppts = tt.deleteAppt(unsortedAppts, apptFive);
		
		
		
		
		//apptRange = tt.getApptRange(unsortedAppts, tomorrow, today);
	 }
	 @Test
	  public void test02()  throws Throwable  {
		TimeTable tt = new TimeTable();
		LinkedList<Appt> unsortedAppts = new LinkedList<Appt>();
		LinkedList<CalDay> apptRange = new LinkedList<CalDay>();
		GregorianCalendar today = new GregorianCalendar(2018, 1, 23);
		GregorianCalendar tomorrow = new GregorianCalendar(2018, 1, 24);
		
		Appt apptOne = new Appt(12, 35, 23, 1, 2018, "Counter appt", "First test");
		Appt apptTwo = new Appt(15, 35, 23, 1, 2018, "Counter appt", "Second test");
		Appt apptThree = new Appt(10, 35, 23, 1, 2018, "Counter appt", "Third test");
		Appt apptFour = new Appt(12, 35, 24, 1, 2018, "Counter appt", "Fourth test");
		Appt apptFive = new Appt(12, 71, 23, 1, 2018, "Invalid appt", "Fifth test");

		
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		apptRange = tt.getApptRange(unsortedAppts, today, tomorrow);
		//apptRange = tt.getApptRange(unsortedAppts, today, today);
		
		int []arr={1,0,2,3};
		unsortedAppts = tt.permute(unsortedAppts, arr);
		
		unsortedAppts.add(apptFive);
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		apptRange = tt.getApptRange(unsortedAppts, today, tomorrow);
		
		int []invArr={1,2,0};
		//unsortedAppts = tt.permute(unsortedAppts, invArr);
	 }
	 @Test
	  public void test03() throws Throwable{
		TimeTable tt = new TimeTable();
		LinkedList<Appt> unsortedAppts = new LinkedList<Appt>();
		LinkedList<CalDay> apptRange = new LinkedList<CalDay>();
		GregorianCalendar today = new GregorianCalendar(2018, 1, 23);
		GregorianCalendar tomorrow = new GregorianCalendar(2018, 1, 24);
		
		Appt apptOne = new Appt(12, 35, 23, 1, 2018, "Counter appt", "First test");
		Appt apptTwo = new Appt(15, 35, 23, 1, 2018, "Counter appt", "Second test");
		Appt apptThree = new Appt(10, 35, 23, 1, 2018, "Counter appt", "Third test");
		Appt apptFour = new Appt(12, 35, 24, 1, 2018, "Counter appt", "Fourth test");
		Appt apptFive = new Appt(12, 71, 23, 1, 2018, "Invalid appt", "Fifth test");
		
		int []recurDays={2,3,4};
				
		apptOne.setRecurrence(recurDays, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		
		unsortedAppts.add(apptFive);
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		apptRange = tt.getApptRange(unsortedAppts, today, tomorrow);
	 }
//add more unit tests as you needed
}
