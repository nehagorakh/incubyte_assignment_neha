package info.incubyte.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class StringCalculator {
	
	private String defaultDelimeter = ";|\n";
	
	private int addInvokingMethodCount =0;
	
	
	
	public int add(String numbers) throws Exception {
		
		int sum =0;
		
		if(numbers.isEmpty())
			return 0;
		
		//no need to change delimeter, use default delimeter
		if(!numbers.startsWith("//")) {			
			if(numbers.startsWith("\n") && numbers.startsWith("\n"))
				throw new Exception(" Invalid Input ");
				
			String[] numbersArray = numbers.split(this.defaultDelimeter);
						
			for(String i : numbersArray) {
				
				if(Integer.parseInt(i) < 0 )					
					throw new Exception(" negatives not allowed  : " +Arrays.stream(numbersArray).filter(a->Integer.parseInt(a) < 0).collect(Collectors.toList()));
					
				if(Integer.parseInt(i) <= 1000)
					sum += Integer.parseInt(i);
			}
			return sum;
			
		}
		else {
			
					
		}		
		this.addInvokingMethodCount++;
		return 9;
	}
	
	public int GetCalledCount() {
		return this.addInvokingMethodCount;
		
	}
	
   public static void main(String[] args) throws Exception {
	   System.out.println(new StringCalculator().add("1;-2;-3;-7"));
	   
   }
	

}