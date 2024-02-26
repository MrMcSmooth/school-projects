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
					System.out.print("Enter a set of names, with each name seperated by comma: ");
					nameList = newList(names);
					continue;
				case 0:
					System.out.println("Bye Bye!");
					quitProgram = false;
				
				}//end switch
				
			}//end if
			
		}//end for

	}//end main

	/**
	 * namesOrdered organizes a give userString array into 
	 * alphabetical order ignoring case
	 * @param userString is a string split into an array
	 */
	static void namesOrdered(String[] userString)
	{
		Arrays.sort(userString, String.CASE_INSENSITIVE_ORDER);
		System.out.print(Arrays.toString(userString));
	}//end namesOrdered

	/**
	 * fullNames prints all full names including a space 
	 * @param userString is a string split into an array
	 */
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

	/**
	 * singleNames prints all one word names
	 * @param userString is a string split into an array
	 */
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

	/**
	 * nameStats prints out multiple pieces of about a name set
	 * including: the total number of items in the set, the total 
	 * character length, the average name length, the shortest name, 
	 * and the longest name, then finally returns the population
	 * standard deviation between the whole set
	 * @param userString is a string split into an array
	 */
	static void nameStats(String[] userString)
	{
		int namesLength = userString.length;
		int letterCount = 0;
		double avgLength = 0;
		String shortestName = userString[0];
		String longestName = userString[0];
		double standardDeviation = 0;
		
		int greatestLength = userString[0].length();
		int leastLength = userString[0].length();
		if(userString[0].contains(" "))
		{
			greatestLength--;
			leastLength--;
		}
		for (String i : userString)
		{
			int iLength = i.length();
			if(i.contains(" "))
			{
				iLength--;
			}
			
			letterCount += iLength;
			if (greatestLength < iLength)
			{
				longestName = i;
			} else if(leastLength > iLength)
			{
				shortestName = i;
			}
		}
		avgLength = letterCount / 1.0 / namesLength;
		for(String i : userString)
		{
			int iLength = i.length();
			if(i.contains(" "))
			{
				iLength--;
			}
			
			standardDeviation += Math.pow(iLength - avgLength, 2);
		}
		standardDeviation = Math.sqrt(standardDeviation / namesLength);
		System.out.println("Name Count: " + namesLength);
		System.out.println("Letter Count Total: " + letterCount);
		System.out.println("Avg Name Length: " + avgLength);
		System.out.println("Shortest Name: " + shortestName);
		System.out.println("Longest Name: " + longestName);
		System.out.printf("Population Standard Deviation: %.2f%n", standardDeviation);
		
	} 

	/**
	 * evenNames prints all names with an even length, excluding spaces
	 * @param userString is a string split into an array
	 */
	static void evenNames(String[] userString)
	{
		for(int ii = 0; ii <= userString.length - 1; ii++)
		{
			int length = userString[ii].length();
			if(userString[ii].contains(" "))
			{
				length--;
			}
			if(length % 2 == 0) 
			{
				System.out.println(userString[ii]);
			}
		}//end ii
	}

	/**
	 * oddNames prints all names with an odd length, excluding spaces
	 * @param userString is a string split into an array
	 */
	static void oddNames(String[] userString)
	{
		for(int ii = 0; ii <= userString.length - 1; ii++)
		{
			int length = userString[ii].length();
			if(userString[ii].contains(" "))
			{
				length--;
			}
			if(length % 2 != 0) 
			{
				System.out.println(userString[ii]);
			}
		}//end ii
	}

	/**
	 * nonCapitals prints all names that are non-capital, including
	 * those put in full names
	 * @param userString is a string split into an array
	 */
	static void nonCapitals(String[] userString)
	{
	
		for(int ii = 0; ii <= userString.length - 1; ii++)
		{
			String[] capsCheck = userString[ii].split(" ");
			for(String lower : capsCheck)
			{
				if(!Character.isUpperCase(lower.charAt(0)))
				{
					System.out.println(lower);
				}//end if
			}//end for each
		}//end ii
	}

	/**
	 * mostFrequent prints the most frequent name of the data set,
	 * while printing that there is no frequent name if no name
	 * repeats
	 * @param userString is a string split into an array
	 */
	static void mostFrequent(String[] userString)
	{
		int greatestFreq = 0;
		String mostFrequent = "";
		for(String i : userString)
		{
			int frequency = 0;
			for(String j : userString)
			{
				if(i.equalsIgnoreCase(j))
				{
					frequency++;
					if(frequency >= greatestFreq)
					{
						greatestFreq = frequency;
						mostFrequent = i;
					}//end freq
				}//end compare
			}//end j
		}//end i
		if (greatestFreq >= 2) {
			System.out.println("Most Frequent Name: " + mostFrequent);
		} else
		{
			System.out.println("No Most Frequent Name");
		}
		
	}

	/**
	 * newList takes in a new set of names to be used in a 
	 * program where you need a set of names each separated into their
	 * own element
	 * @param names original set of names to be replaced
	 * @return new set of names in String array
	 */
	static String[] newList(String names)
	{	
		Scanner scnr = new Scanner(System.in);
		names = scnr.nextLine();
		String[] nameList = names.split(",");
		return nameList;
	}

}//end class
