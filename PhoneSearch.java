import java.util.Scanner;
public class PhoneSearch {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String choise = "";
		Phone myPhone = new Phone();
		do{
			System.out.println("Phone search \nAvailable operations: \n 1 add a number \n 2 search for a number \n 3 search for a person by phone number \n 4 add an address \n 5 search for personal information \n 6 delete personal information \n 7 filtered listing");
			choise = input.nextLine();
			switch(choise){
				case "1" : myPhone.addNumber(input);
						break;	
			
				case "2" : myPhone.printNumber(input);
						break;
						
				case "3" : myPhone.printName(input);
						break;
				
				case "4" : myPhone.addAddress(input);
						break;
						
				case "5" : myPhone.searchPerson(input);
						break;
						
				case "6" : myPhone.deleteInfo(input);
						break;
						
				case "7" : myPhone.searchWord(input);
						break;
						
				case "x" : break;
			}
		}while(!choise.equals("x"));
	}	
}
