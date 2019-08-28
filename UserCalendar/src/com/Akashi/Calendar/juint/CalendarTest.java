package com.Akashi.Calendar.juint;

import java.util.Calendar;

import org.junit.Test;

import com.Akashi.Calendar.domain.MonthCalendar;
import com.Akashi.Calendar.domain.YearCalendar;

public class CalendarTest {

	@Test
	public void testMyCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2019);
		cal.set(Calendar.MONTH, 7 - 1);
		cal.set(Calendar.DATE, 17);
		int weekDay = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(weekDay - 1);
		System.out.println(Calendar.FEBRUARY);
	}
	
	@Test
	public void testMyCalendar2() {
//		MonthCalendar monthcal = new MonthCalendar(2, 2019);
//		monthcal.showCalendar();
		
		MonthCalendar monthcal = new MonthCalendar();
		monthcal.setCalMonth(12);
		monthcal.setCalYear(2016);
		monthcal.add();
		monthcal.showCalendar();
		
//		MonthCalendar yearCal = new YearCalendar();
//		yearCal.setCalYear(2019);
//		yearCal.showCalendar();
//		yearCal.add();
//		yearCal.showCalendar();
//		System.out.println(yearCal.getClass() == YearCalendar.class);
		
		
	}
	
	public static void main(String[] args) {
		YearCalendar yearCal = new YearCalendar(2019);
		yearCal.showCalendar();
	}
}
