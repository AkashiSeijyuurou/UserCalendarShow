package com.Akashi.Calendar.domain;

import java.util.Calendar;

public class MonthCalendar {

	private Calendar cal;
	public static final int[] DAYCOUNTOFMONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final int THEFIRSTDAY = 1;
	
	public MonthCalendar() {
		cal = Calendar.getInstance();
		cal.set(Calendar.DATE, THEFIRSTDAY);
	}
	
	
	public MonthCalendar(int month, int year) {
		this();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, THEFIRSTDAY);
	}
	
	public Calendar getCal() {
		return this.cal;
	}
	
	public void setCalMonth(int month) {
		cal.set(Calendar.MONTH, month - 1);
	}
	
	public int getMonth() {
		return cal.get(Calendar.MONTH) + 1;
	}
	
	public void setCalYear(int year) {
		cal.set(Calendar.YEAR, year);
	}
	
	public int getYear() {
		return cal.get(Calendar.YEAR);
	}
	
	/**
	 * 
	 * Description 下个月
	 * @author Akashi
	 * @date 2019年7月18日下午3:36:02
	 */
	public void add() {
		this.setCalMonth(this.getMonth() + 1);
	}
	
	/**
	 * 
	 * Description 上个月
	 * @author Akashi
	 * @date 2019年7月18日下午3:36:19
	 */
	public void sub() {
		this.setCalMonth(this.getMonth() - 1);
	}
	
	public String showYearHead() {
		return "\t\t   " + cal.get(Calendar.YEAR) + "年";
	}
	
	public String showMonthHead() {
		return  "\t\t    " + (cal.get(Calendar.MONTH) + 1) + "月";
	}
	
	public void showCalendarText(){
		//日历头
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		
		//日历填充
		int totalDayOfMonth = DAYCOUNTOFMONTH[month - 1];
		if((month == 2) && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
				totalDayOfMonth++;
		}
		
		int firstDayWeekday = cal.get(Calendar.DAY_OF_WEEK) - 1;
		int weekdayCounter = 0;//用于计算填充的天数，用于换行
		for(int i = 0; i < firstDayWeekday; i++) {
			System.out.print("  \t");
			weekdayCounter++;
		}
		

		for(int i = 1; i <= totalDayOfMonth; i++) {
			System.out.print(i + "\t");
			if(++weekdayCounter % 7 == 0) {
				weekdayCounter %= 7;
				System.out.println();
			}
		}
		
	}
	
	public void showCalendar() {
		System.out.println(this.showYearHead());
		System.out.println(this.showMonthHead());
		this.showCalendarText();
		System.out.println();
	}
	
}
