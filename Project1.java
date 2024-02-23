import java.util.*;

public class Project1 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		System.out.print("Enter a set of names, with each name seperated by comma: ");

		String names = scnr.nextLine();
		String[] nameList = names.split(",");
		int userOption = 0;
		boolean quitProgram = true;

		for(;;) 
		{
			if(quitProgram)
			{
				System.out.println();
				System.out.println("1: Display List Ordered");
				System.out.println("2: Display Full Names");
				System.out.println("3: Display Single Names");
				System.out.println("4: Display Name Statistics");
				System.out.println("5: Display Names with Even Length");
				System.out.println("6: Display Names with Odd Length");
				System.out.println("7: Display Names not Capitalized");
				System.out.println("8: Display Most Frequent Name");
				System.out.println("9: Enter new list of Names");
				System.out.println("0: Quit Program");

				userOption = scnr.nextInt();

				switch(userOption)
				{
				default:
					System.out.println("Error: Not an option");
					System.out.println();
					continue;
				case 1:
					namesOrdered(nameList);
					continue;
				case 2:
					fullNames(nameList);
					continue;
				case 3:
					singleNames(nameList);
					continue;
				case 4:
					nameStats(nameList);
					continue;
				case 5:
					evenNames(nameList);
					continue;
				case 6:
					oddNames(nameList);
					continue;
				case 7:
					nonCapitals(nameList);
					continue;
				case 8:
					mostFrequent(nameList);
					continue;
				case 9:
					newList();
					continue;
				case 0:
					System.out.println("Bye Bye!");
					quitProgram = false;
				
				}//end switch
				
			}//end if
			
		}//end for

	}//end main

	static void namesOrdered(String[] userString)
	{
		Arrays.sort(userString, String.CASE_INSENSITIVE_ORDER);
		System.out.print(Arrays.toString(userString));
	}//end namesOrdered

	static void fullNames(String[] userString)
	{
		for(int ii = 0; ii <= userString.length - 1; ii++)
		{
			if(userString[ii].contains(" "))
			{
				System.out.println(userString[ii]);
			}//end if
		}//end ii
	}//end fullNames

	static void singleNames(String[] userString)
	{
		for(int ii = 0; ii <= userString.length - 1; ii++)
		{
			if(!userString[ii].contains(" "))
			{
				System.out.println(userString[ii]);
			}//end if
		}//end ii
	}//end singleNames

	static void nameStats(String[] userString)
	{
		
	} 

	static void evenNames(String[] userString)
	{
		for(int ii = 0; ii <= userString.length - 1; ii++)
		{
			if(userString[ii].contains(" "))
			{//make new string without space
				
			} else
			{
				
			}
		}//end ii
	}

	static void oddNames(String[] userString)
	{
		for(int ii = 0; ii <= userString.length - 1; ii++)
		{
			if(userString[ii].contains(" "))
			{//make new string without space
				
			} else 
			{
				
			}
		}//end ii
	}

	static void nonCapitals(String[] userString)
	{
		for(int ii = 0; ii <= userString.length - 1; ii++)
		{
			
		}//end ii
	}

	static void mostFrequent(String[] userString)
	{

	}

	static void newList()
	{

	}

}//end class
