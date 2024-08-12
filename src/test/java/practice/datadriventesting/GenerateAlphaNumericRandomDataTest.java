package practice.datadriventesting;

public class GenerateAlphaNumericRandomDataTest {

	public static void main(String[] args) {
		int n=20;
		
		//choose a character random from this string
		String AlphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		//create String buffer size of AlphaNumericString
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<n;i++) {
			
			//generate random number between o to AlphaNumericString variable length
			int index =(int)(AlphaNumericString.length()*Math.random());
			
			//add character one by one in the end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		System.out.println(sb);
		
	}

}
