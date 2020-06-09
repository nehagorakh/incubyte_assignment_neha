package info.incubyte.code;

public class StringCalculator {
	
	private String defaultDelimeter = ";";
	
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
				if(i.length() > 1){
					String[] splitForNewLine =  i.split("\n");
					for(String j : splitForNewLine)
						if(Integer.parseInt(j) <= 1000)
						sum += Integer.parseInt(j);
				}
				else if(Integer.parseInt(i) <= 1000)
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
	   System.out.println(new StringCalculator().add("1\n2;3;4\n4;5"));
	   
   }
	

}
