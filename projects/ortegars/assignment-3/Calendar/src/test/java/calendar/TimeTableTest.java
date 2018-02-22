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
		Appt apptFive = new Appt(12, 71, 23, 1, 2018, "Invalid appt", "Fifth test");
		
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		
		unsortedAppts = tt.deleteAppt(unsortedAppts, null);
		assertNull(unsortedAppts);
		
		unsortedAppts = new LinkedList<Appt>();
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		unsortedAppts = tt.deleteAppt(null, apptOne);
		assertNull(unsortedAppts);
		
		unsortedAppts = new LinkedList<Appt>();
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		
		unsortedAppts = tt.deleteAppt(null, null);
		assertNull(unsortedAppts);
		
		unsortedAppts = new LinkedList<Appt>();
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		
		unsortedAppts = tt.deleteAppt(unsortedAppts, apptTwo);
		
		unsortedAppts = tt.deleteAppt(unsortedAppts, apptTwo);
		assertNull(unsortedAppts);
		
		unsortedAppts = new LinkedList<Appt>();
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		
		unsortedAppts = tt.deleteAppt(unsortedAppts, apptFive);
		assertNull(unsortedAppts);
		
		unsortedAppts = new LinkedList<Appt>();
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		
		unsortedAppts = tt.deleteAppt(unsortedAppts, apptTwo);
		assertNotNull(unsortedAppts);
		
		unsortedAppts = new LinkedList<Appt>();
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		
		assertNull(tt.deleteAppt(unsortedAppts, apptFour));
		
		unsortedAppts = new LinkedList<Appt>();
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptTwo);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		LinkedList<Appt> copyAppt = new LinkedList<Appt>();
		copyAppt.add(apptOne);
		copyAppt.add(apptTwo);
		copyAppt.add(apptFour);
		
		assertEquals(tt.deleteAppt(unsortedAppts, apptThree), copyAppt);
	 }
	 @Test
	  public void test02()  throws Throwable  {
		TimeTable tt = new TimeTable();
		LinkedList<Appt> unsortedAppts = new LinkedList<Appt>();
		LinkedList<CalDay> apptRange = new LinkedList<CalDay>();
		LinkedList<Appt> testRange = new LinkedList<Appt>();
		GregorianCalendar firstDay = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar lastDay = new GregorianCalendar(2018, 1, 28);
		
		Appt apptOne = new Appt(12, 35, 23, 1, 2018, "Counter appt", "First test");
		Appt apptTwo = new Appt(15, 35, 23, 1, 2018, "Counter appt", "Second test");
		Appt apptThree = new Appt(10, 35, 23, 1, 2018, "Counter appt", "Third test");
		Appt apptFour = new Appt(12, 35, 24, 1, 2018, "Counter appt", "Fourth test");
		Appt apptFive = new Appt(12, 71, 23, 1, 2018, "Invalid appt", "Fifth test");

		assertNotNull(tt.getApptRange(unsortedAppts, firstDay, lastDay));
		unsortedAppts.add(apptOne);
		unsortedAppts.add(apptThree);
		unsortedAppts.add(apptFour);
		unsortedAppts.add(apptTwo);
		testRange.add(apptOne);
		testRange.add(apptTwo);
		testRange.add(apptThree);
		testRange.add(apptFour);
		int []pv = {3, 2, 2, 3};
		assertNotNull(tt.permute(unsortedAppts, pv));
	 }
	 @Test
	  public void test03() throws Throwable{
		TimeTable tt = new TimeTable();
		LinkedList<Appt> sortedAppts = new LinkedList<Appt>();
		//LinkedList<CalDay> apptRange = new LinkedList<CalDay>();
		LinkedList<CalDay> testRange = new LinkedList<CalDay>();
		GregorianCalendar oneDay = new GregorianCalendar(2018, 2, 1);
		GregorianCalendar twoDay = new GregorianCalendar(2018, 2, 28);
		GregorianCalendar day = new GregorianCalendar(2018, 2, 2);
		
		Appt apptOne = new Appt(12, 35, 1, 2, 2018, "Counter appt", "First test");
		Appt apptTwo = new Appt(15, 35, 2, 2, 2018, "Counter appt", "Second test");
		Appt apptThree = new Appt(10, 35, 3, 2, 2018, "Counter appt", "Third test");
		Appt apptFour = new Appt(12, 35, 5, 2, 2018, "Counter appt", "Fourth test");
		Appt apptFive = new Appt(12, 71, 4, 2, 2018, "Invalid appt", "Fifth test");
		
		int []recurDays={4};
				
		apptOne.setRecurrence(recurDays, Appt.RECUR_BY_WEEKLY, 1, 1);
		
		assertEquals((tt.getApptRange(sortedAppts, oneDay, day)).size(), 1);
		
		sortedAppts.add(apptOne);
		sortedAppts.add(apptTwo);
		sortedAppts.add(apptThree);
		sortedAppts.add(apptFour);
		sortedAppts.add(apptFive);
		
		testRange = tt.getApptRange(sortedAppts, oneDay, twoDay);
		assertEquals((testRange.get(2)).getAppts().get(0), apptTwo);
		assertNotNull((testRange.get(2)).getAppts().get(0));
		assertEquals((testRange.get(0)).getAppts().get(0), apptOne);
		assertEquals((testRange.get(0)).getAppts().get(0), (testRange.get(12)).getAppts().get(0));
	 }
//add more unit tests as you needed
}
