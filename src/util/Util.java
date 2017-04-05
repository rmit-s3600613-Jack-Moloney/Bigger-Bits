package util;

import user.User;

public class Util {

	public boolean validateCancel(String input){

		if(input.toUpperCase().equals("C")){
			System.out.println("Returning to menu");
			return false;
		}
		else{
			return true;
		}
	}
	public boolean validateComma(String input){

		if(input.indexOf(',') >= 0){
			System.out.println("The character ',' is not allowed, please try again");
			return false;
		}
		else{
			return true;
		}
	}

}
