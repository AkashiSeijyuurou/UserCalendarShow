package com.Akashi.Calendar.domain;

import java.util.Calendar;

public class YearCalendar extends MonthCalendar{
	
	public YearCalendar() {
		super();
	}
	
	public YearCalendar(int year) {
		super();
		Calendar cal = super.getCal();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.DATE, super.THEFIRSTDAY);
	}
	
	

	@Override
	public void add() {
		super.setCalYear(super.getYear() + 1);
	}
	
	@Override
	public void sub() {
		super.setCalYear(super.getYear() - 1);
	}
	
	@Override
	public void showCalendar() {
		Calendar cal = super.getCal();
		System.out.println(super.showYearHead());
		for(int i = 0; i < 12; i++) {
			cal.set(Calendar.MONTH, i);
			System.out.println(super.showMonthHead());
			super.showCalendarText();
			System.out.println("\n");
		}
	}
	
}
