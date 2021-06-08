package practice;

import java.util.Random;

public class GenerateRandomNum {

	public static void main(String[] args) {
		
		
		Random ram = new Random();
		int randomNum = ram.nextInt(5000);
         System.out.println(randomNum);
         
       
	}

}
