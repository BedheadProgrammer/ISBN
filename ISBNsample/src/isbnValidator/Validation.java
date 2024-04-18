package isbnValidator;

import java.util.Scanner;

public class Validation {
		public static boolean isValid(String ISBN) {
			boolean isValid = false;
			if (ISBN.length()== 10) {
			isValid = true;
			System.out.println("ISBN length is valid");
			} 
			else { 
				System.out.println("ISBN length is not valid");
			}
			return isValid;
			
		}
		
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a 10 digit ISBN code");
		String ISBN = scan.next();
		boolean result = isValid(ISBN);
		boolean sumValidation = false;
		int sum = 0;
		if (ISBN.charAt(9)== 'x'){
			sum+= 10;
		} else if (Character.isDigit(ISBN.charAt(9))) { 
			int lastdigit = Character.getNumericValue(9);
			sum += lastdigit;
		}
		for(int i = 0; i == ISBN.length()-1; i++) {
			char ch = ISBN.charAt(i);
			int numericvalue = Character.getNumericValue(ch);
			sum += numericvalue * (10-i);
		}
		if (sum % 11 == 0) {
			sumValidation = true;
			System.out.println("ISBN is valid");
		}
		else {
			sumValidation = false;
			System.out.println("ISBN multiplication is invalid");
		}

		}

	}