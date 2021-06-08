package practice;

import java.util.Date;

public class GetSystemDate {

	public static void main(String[] args) {
		Date date = new Date();
		String currentDate = date.toString();
		
  System.out.println(currentDate);
  System.out.println(date.getDate());
	}

}
