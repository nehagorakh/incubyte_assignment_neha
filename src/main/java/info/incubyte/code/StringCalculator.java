package info.incubyte.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
	
	private String defaultDelimeter = ";|\n";
	
	private static int addInvokingMethodCount =0;
	
	
	
	public int add(String numbers) throws Exception {
	
		String[] numbersArray;
		addInvokingMethodCount++;
		String[] multiDelimeter = null;
		if(numbers.isEmpty())
			return 0;
		
		if(numbers.startsWith("\n") && numbers.startsWith("\n"))
			throw new Exception(" Invalid Input ");
		
		//no need to change delimeter, use default delimeter
		if(!numbers.startsWith("//")) 		
			numbersArray = numbers.split(this.defaultDelimeter);
										
		//here we need to have provided delimeter for getting numbers array
		else {
			String[] sepratDelimeterAndNumbers = numbers.split("\n", 2);
			String delimeter = sepratDelimeterAndNumbers[0].substring(2);
			
			if(delimeter.contains("[")) {
				multiDelimeter = delimeter.split("\\[");
				delimeter = "[";
				for(String delim : multiDelimeter) {
					if(delim.equalsIgnoreCase(""))
						continue;
					delimeter += delim.replaceAll("]", "")+"|";
				}
				
				delimeter += "\n]";		
			}
			else
			//for meta characters we need to add '\\' before delimeter
			delimeter = "\\"+delimeter+"|\n";			
			numbersArray = sepratDelimeterAndNumbers[1].split(delimeter);
		}
		List<String> numberList = Arrays.asList(numbersArray);
		
		numberList = numberList.stream().filter(a-> (!a.equalsIgnoreCase("") && !(Integer.parseInt(a) > 1000))).collect(Collectors.toList());
		
		List<String> negativeNumbers = numberList.stream().filter(a-> Integer.parseInt(a) < 0).collect(Collectors.toList());
		
		if(negativeNumbers!=null && negativeNumbers.size() > 0)
			throw new Exception("Negative Numbers are not allowed : "+negativeNumbers);	
		return numberList.stream()
				  .mapToInt(x -> Integer.parseInt(x))
				  .sum();
	}
	
	
	public int GetCalledCount() {
		return addInvokingMethodCount;
		
	}
}