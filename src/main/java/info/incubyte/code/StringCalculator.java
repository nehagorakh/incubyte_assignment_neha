package info.incubyte.code;

public class StringCalculator {
	
	private String defaultDelimeter = ";";
	
	private int addInvokingMethodCount =0;
	
	public int add(String numbers) {
		
		int sum =0;
		if(numbers.isEmpty())
			return 0;
		//no need to change delimeter, use default delimeter
		if(!numbers.startsWith("//")) {
			
			if(numbers.sta)
			String[] numbersArray = numbers.split(this.defaultDelimeter);
			
			
			for(String i : numbersArray) {
				if()
				{
					String[] splitForNewLine =  
				}
				else
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
	
   public static void main(String[] args) {
	   System.out.println(new StringCalculator().add("1\n2;3"));
	   
   }
	

}
