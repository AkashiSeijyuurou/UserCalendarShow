package com.Akashi.Calendar.util;

import java.util.Scanner;

public class CALUtility {

	public static Scanner scan = new Scanner(System.in);
	
	/**
	 * 
	 * Description 该方法读取键盘，如果用户键入’1’-’3’中的任意字符，则方法返回。返回值为用户键入字符。
	 * @author Akashi
	 * @date 2019年7月17日下午10:13:31
	 * @return year 
	 */
	public static char readMenuSelction() {
		char c;
		for(; ;) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if(c != '1' && c != '2' && c != '3') {
				System.out.print("选择错误，请重新输入：");
			}else break;
		}
		return c;
	}
	
	/**
	 * 
	 * Description 从键盘读取‘Y’或’N’，并将其作为方法的返回值。
	 * @author Akashi
	 * @date 2019年7月17日下午11:28:01
	 * @return
	 */
	public static char readConfirmSelection() {
		char c;
		for(; ;) {
			String str = readKeyBoard(1, false).toUpperCase();
			c = str.charAt(0);
			if(c == 'Y' || c == 'N') {
				break;
			}else {
				System.out.println("选择错误，请重新输入：");
			}
		}
		
		return c;
	}
	
	/**
	 * 
	 * Description  该方法从键盘读取一个长度不超过10位的整数作为年份，并将其作为方法的返回值。
	 * @author Akashi
	 * @date 2019年7月17日下午11:15:04
	 * @return month
	 */
	public static int readYear() {
		int year;
		for(; ;) {
			String str = readKeyBoard(10, false);
			try {
				year = Integer.parseInt(str);
				if(year < 1970) {
					System.out.print("输入年份过小，请重新输入：");
				}else {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.print("输入格式有误，请重新输入：");
			}
		}
		
		return year;
	}
	
	/**
	 * 
	 * Description 该方法从键盘读取一个长度不超过2位的整数作为月份，并将其作为方法的返回值。
	 * @author Akashi
	 * @date 2019年7月17日下午11:24:28
	 * @return
	 */
	public static int readMonth() {
		int month;
		for(; ;) {
			String str = readKeyBoard(2, false);
			try {
				month = Integer.parseInt(str);
				if(month > 12 || month <= 0) {
					System.out.print("输入月份不在合理范围中，请重新输入：");
				}else break;
			} catch (NumberFormatException e) {
				System.out.print("输入格式有误，请重新输入：");
			}	
		}
		
		return month;
	}
	
	/**
	 * 
	 * Description 从键盘中读取信息，限制limit长度，blankReturn表示是否确认读取空字符。
	 * @author Akashi
	 * @date 2019年7月17日下午10:35:39
	 * @param limit
	 * @param blankReturn
	 * @return
	 */
	private static String readKeyBoard(int limit, boolean blankReturn) {
		String line = "";
		
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			if(line.length() == 0) {
				if(blankReturn) return line;
				else continue;
			}
			
			if(line.length() < 1 || line.length() > limit) {
				System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
				continue;
			}
			break;
		}
		
		return line;
	}
}
