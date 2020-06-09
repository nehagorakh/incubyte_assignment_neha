package info.incubyte.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class StringCalculator {
	
	private String defaultDelimeter = ";|\n";
	
	private int addInvokingMethodCount =0;
	
	
	
	public int add(String numbers) throws Exception {
	
		this.addInvokingMethodCount++;
		
		if(numbers.isEmpty())
			return 0;
		
		//no need to change delimeter, use default delimeter
		if(!numbers.startsWith("//")) {			
			if(numbers.startsWith("\n") && numbers.startsWith("\n"))
				throw new Exception(" Invalid Input ");
				
			String[] numbersArray = numbers.split(this.defaultDelimeter);
									
			return getSum(numbersArray);
			
		}
		//here we need to have provided delimeter for getting numbers array
		else {
			String[] sepratDelimeterAndNumbers = numbers.split("\n", 2);
			String delimeter = sepratDelimeterAndNumbers[0].substring(2);
			
			//for meta characters we need to add '\\' before delimeter
			delimeter = "\\"+delimeter;
			
			String[] numbersArray = sepratDelimeterAndNumbers[1].split(delimeter+"|\n");
			return getSum(numbersArray);								
		}
	}
	
	
	public int GetCalledCount() {
		return this.addInvokingMethodCount;
		
	}
	
	public int getSum(String[] numbersArray) throws Exception {
		int sum =0;
		for(String i : numbersArray) {
			
			if(Integer.parseInt(i) < 0 )					
				throw new Exception(" negatives not allowed  : " +Arrays.stream(numbersArray).filter(a->Integer.parseInt(a) < 0).collect(Collectors.toList()));
				
			if(Integer.parseInt(i) <= 1000)
				sum += Integer.parseInt(i);
		}
		return sum;
	}
	
   public static void main(String[] args) throws Exception {
	   System.out.println(new StringCalculator().add("//*\n1*2"));
	   
   }
	

}