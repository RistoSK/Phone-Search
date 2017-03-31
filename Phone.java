import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.HashSet;
import java.lang.String;


public class Phone {
	Map<String, Set<String>> phoneNumbers = new HashMap<String, Set<String>>();
	Map<String, String> addresses = new HashMap<String, String>();
	Map<String,Set<String>> sortedPhoneNumbers = new TreeMap<String, Set<String>>(phoneNumbers);
	Map<String, String> sortedAddresses = new TreeMap<String, String>(addresses);
	private boolean found = false;

	public Phone(){
	
	}

	public void addNumber(Scanner input)
	{
		//Ask for the name of the contact
		System.out.println("Give me a name!");
		String name = input.nextLine();
		
		//Ask for the number of the contact
		System.out.println("Give me a number!");
		String number = input.nextLine();
		
		//Check if the name already exists and if it doesn't create a new key value with that name
		if(!phoneNumbers.containsKey(name))
		{
			phoneNumbers.put(name, new HashSet<String>());
		}
		
		//Add A set of numbers into that key value
		Set<String>Numbers = this.phoneNumbers.get(name);
		Numbers.add(number);
	}
	
	public void printNumber(Scanner input)
	{
		//Ask for a contact name
		System.out.println("Give me a name!");
		String name = input.nextLine();
		
		//Go through the phoneNumbers Map
		for(int i=0; i < phoneNumbers.size(); i++)
		{	
			//If the name is found inside the map
			if(phoneNumbers.keySet().toArray()[i].equals(name))
			{
				//Go through the Set that contains the phone numbers for that name
				for(String numbs : phoneNumbers.get(name))
				{
				System.out.println(numbs);
				}
			}
			else
			{
				System.out.println("Name unknown \n ");
			}
		}
	}
	
	public void printName(Scanner input)
	{
		System.out.println("Give me the phone number!");
		String number = input.nextLine();
		
		
				//Go through the phoneNumbers Map
				for(int i=0; i < phoneNumbers.size(); i++)
				{					
					//Compare all the numbers in the map with the number the user entered
					for(String numbs : phoneNumbers.get(phoneNumbers.keySet().toArray()[i]))
					{
						//if the number is found
						if(number.equals(numbs))
						{
						System.out.println(phoneNumbers.keySet().toArray()[i] + "\n " );
						found = true;
						}
					}
				}
				if(found == false)
				{
					System.out.println("Number doesn't exist");
				}
	}
		
	public void addAddress(Scanner input)
	{
		System.out.println("whose address: ");
		String name = input.nextLine();
		
		//Go through the phoneNumbers Map
		for(int i=0; i < phoneNumbers.size(); i++)
		{	
			//If the name is found inside the map
			if(phoneNumbers.keySet().toArray()[i].equals(name))
			{
				System.out.println("street: ");
				String street = input.nextLine();
				System.out.println("city: ");
				String city = input.nextLine();
				String pInfo = street + " " + city;
				
				addresses.put(name , pInfo);
			}
			else
			{
				System.out.println("Name doesn't exist \n");
			}
		}
		
	}
	
	public void searchPerson(Scanner input)
	{
		System.out.println("whose information: ");
		String name = input.nextLine();
		
		//Go through the phoneNumbers Map
		for(int i=0; i < phoneNumbers.size(); i++)
		{	
			//If the name is found inside the map
			if(phoneNumbers.keySet().toArray()[i].equals(name))
			{
				System.out.println("phone numbers: ");
				//Go through the Set that contains the phone numbers for that name
				for(String numbs : phoneNumbers.get(name))
				{
				System.out.println(numbs);
				}
				found = true;
			}
		}
		if (found == false)
		{
			System.out.println("phone number unknown");
		}
		//Go through the addresses Map
		for (int i=0; i< addresses.size(); i++)
		{
			found = false;
			//If the name is found inside of the map
			if(addresses.keySet().toArray()[i].equals(name))
			{
				System.out.println("address: " + addresses.get(name) + "\n ");
				found = true;
			}
		}
		if (found == false)
		{
			System.out.println("Address unknown \n ");
		}
		
	}
	
	public void deleteInfo(Scanner input)
	{
		System.out.println("whose information: ");
		String name = input.nextLine();
		
		//Go through the phoneNumbers Map
		for(int i=0; i < phoneNumbers.size(); i++)
		{	
			//If the name is found inside the map
			if(phoneNumbers.keySet().toArray()[i].equals(name))
			{
				phoneNumbers.remove(name);
			}
			else
			{
				System.out.println("Name doesn't exist");
			}
		}
		//Go through the addresses Map
		for(int i=0; i < addresses.size(); i++)
		{
			//If the name is found inside the map
			if(addresses.keySet().toArray()[i].equals(name))
			{
				addresses.remove(name);
			}
			else
			{
				System.out.println("Address doesn't exist \n ");
			}
		}
	}
	
	public void searchWord(Scanner input)
	{
		System.out.println("keyword (if empty, all listed): ");
		String search = input.nextLine();
		
		//Go through the sorted PhoneNumbers TreeMap
		for(int i=0; i < sortedPhoneNumbers.size(); i++)
		{	
			//If the letters given to us are found somewhere inside out list
			if(sortedPhoneNumbers.keySet().toArray()[i].toString().contains(search))
			{
				System.out.println(sortedPhoneNumbers.keySet().toArray()[i] + "\n address: " + sortedAddresses.get(sortedAddresses.keySet().toArray()[i]) + " \n phone number(s)" + sortedPhoneNumbers.get(sortedPhoneNumbers.keySet().toArray()[i]) + "\n ");
				found = true;
			}
		}
		//If they are not found we display the all information
		if(found == false)
		{
			for(int i=0; i < sortedPhoneNumbers.size(); i++)
			{
				System.out.println(sortedPhoneNumbers.keySet().toArray()[i] + "\n address: " + sortedAddresses.get(sortedAddresses.keySet().toArray()[i]) + " \n phone number(s)" + sortedPhoneNumbers.get(sortedPhoneNumbers.keySet().toArray()[i])+ "\n ");
			}
		}
		
	}
	
}