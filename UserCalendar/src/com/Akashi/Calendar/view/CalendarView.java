package com.Akashi.Calendar.view;

import com.Akashi.Calendar.domain.MonthCalendar;
import com.Akashi.Calendar.domain.YearCalendar;
import com.Akashi.Calendar.util.CALUtility;

public class CalendarView {

	private MonthCalendar monthCal = new MonthCalendar();
	private YearCalendar yearCal = new YearCalendar();
	
	public void enterMainMenu() {
		boolean outLoopFlag = true;
		char firstMenu = '0';
		
		while(outLoopFlag) {
			System.out.println("----------------查看日历软件-------------------------------");
			if(firstMenu == '0') {
				monthCal.showCalendar();
				System.out.println();
			}
			
			System.out.print("1-显示某年年历   2-显示某月月历   3-退出  请选择（1-3）：");
			firstMenu = CALUtility.readMenuSelction();
			switch(firstMenu) {
			case '1': 
				showYearCalendar(yearCal);
				String yearChangeStr = "1-上一年   2-下一年    3-返回，请选择（1-3）：";
				secondMainMenu(yearCal, yearChangeStr);
				break;
				
			case '2':
				showMonthCalendar(monthCal);
				String monthStr = "1-上个月   2-下个月    3-返回，请选择（1-3）：";
				secondMainMenu(monthCal, monthStr);
				break;
				
			case '3':
				System.out.print("确认是否退出（Y/N）：");
				char isExit = CALUtility.readConfirmSelection();
				if(isExit == 'Y') {
					outLoopFlag = false;
				}
				break;
			}
		}
	}
	
	private void secondMainMenu(MonthCalendar cal, String changeStr) {
		boolean inLoopFlag = true;
		char secondMenu = '0';
		
		while(inLoopFlag) {
			System.out.print(changeStr);
		    secondMenu = CALUtility.readMenuSelction();
		    
		    if(cal.getClass() == YearCalendar.class) {
		    	cal = (YearCalendar)cal;
		    }
		    
		    switch(secondMenu) {
		    
		    case '1':
		    	cal.sub();
		    	cal.showCalendar();
		    	break;
		    	
		    case '2':
		    	cal.add();
		    	cal.showCalendar();
		    	break;
		    	
		    case '3':
		    	inLoopFlag = false;
		    	break;
		    }
		}
	}
	
	/**
	 * 
	 * Description 根据用户输入的年份，显示年历
	 * @author Akashi
	 * @date 2019年7月18日上午10:37:55
	 * @param cal
	 */
	private void showYearCalendar(MonthCalendar cal) {
		System.out.print("请输入需要显示年历的那一年：");
		int year = CALUtility.readYear();
		cal = new YearCalendar(year);
		if(cal instanceof YearCalendar) {
			cal = (YearCalendar)cal;
			cal.showCalendar();
		}
	}
	
	/**
	 * 
	 * Description 根据用户输入年份和月份，显示月历
	 * @author Akashi
	 * @date 2019年7月18日上午10:38:21
	 * @param cal
	 */
	private void showMonthCalendar(MonthCalendar cal) {
		System.out.print("请输入需要显示的月历的那一年：");
		int year = CALUtility.readYear();
		System.out.print("请输入需要显示" + year + "年的那一个月：");
		int month = CALUtility.readMonth();
		cal.setCalYear(year);
		cal.setCalMonth(month);
		cal.showCalendar();
	}
	
	
	public static void main(String[] args) {
		CalendarView view = new CalendarView();
		view.enterMainMenu();
	}
	
}
