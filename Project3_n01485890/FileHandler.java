import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * The Class FileHandler.
 */
public class FileHandler
{
	
	/**
	 * Writes fileData to new Work Order file.
	 *
	 * @param workOrderFileName the work order file name
	 */
	public static void writeData(String workOrderFileName)
	{
		System.out.println("Writing Work Order Data File");
		try
		{
			FileWriter fw = new FileWriter(workOrderFileName, true);
			
			logger("Writing Work Order Data File");
			
			fw.write("customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt,employee_id,employee_first_name,employee_last_name,clocked_in,certification");
			
			for(int i = 0; i < Project3.workOrderList.size(); i++)
			{
				fw.append("\n" + Project3.workOrderList.get(i).getFileData());
				logger(Project3.workOrderList.get(i).getFileData());
			}
			fw.close();
			System.out.println("Work Orders Created. Program Exiting");
			logger("Work Orders Created. Program Exiting");
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads employee data.
	 *
	 * @param employeeFileName the employee file name
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void readEmployeeData(String employeeFileName) throws FileNotFoundException
	{
		System.out.println("Loading Employee Data");
		
		File f = new File(employeeFileName);
		Scanner fr = new Scanner(f);
		
		String fileHeader = fr.nextLine();
		
		logger("Loading Employee Data");
		
		while(fr.hasNextLine())
		{
			String line = fr.nextLine();
			String[] employeeData = line.split(",");
			
			String firstName = employeeData[1];
			String lastName = employeeData[2];
			String address = employeeData[4];
			String phoneNumber = employeeData[5];
			String email = employeeData[3];
			String employeeId = employeeData[0];
			String clockedIn = employeeData[6];
			String hiredDate = employeeData[7];
			String certification = employeeData[9];
			
			String tier = employeeData[8];
			
			if(tier.equals("tier1"))
			{
				Employee newEmployee = new Employee(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate);
				Project3.employeeList.add(newEmployee);
			} else if (tier.equals("tier2"))
			{
				Employee newEmployee = new Tier2Employee(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate, certification);
				Project3.employeeList.add(newEmployee);
			}
			
		}
	}
	
	/**
	 * Reads ticket data.
	 *
	 * @param ticketFileName the ticket file name
	 * @return the linked list
	 * @throws FileNotFoundException the file not found exception
	 */
	public static LinkedList<Ticket> readTicketData(String ticketFileName) throws FileNotFoundException
	{
		System.out.println("Loading Ticket Data");
		
		File f = new File(ticketFileName);
		Scanner fr = new Scanner(f);
		
		String fileHeader = fr.nextLine();
		
		LinkedList<Ticket> ticketList = new LinkedList<Ticket>();
		
		logger("Loading Ticket Data");
		
		while(fr.hasNextLine())
		{
			String line = fr.nextLine();
			String[] ticketData = line.split(",");

			String firstName = ticketData[1];
			String lastName = ticketData[2];	
			String address = ticketData[4];
			String phoneNumber = ticketData[5];
			String email = ticketData[3];
			String customerId = ticketData[0];
			String accountNumber = ticketData[6];
			
			Customer newCustomer = new Customer(firstName, lastName, address, phoneNumber, email, customerId, accountNumber);
			
			String createdAt = ticketData[8];
			String ticketId	= ticketData[7];
			
			Ticket newTicket = new Ticket(newCustomer, createdAt, ticketId);
			
			ticketList.add(newTicket);
		}
		
		return ticketList;
	}
	
	/**
	 * Logs time and what is written.
	 *
	 * @param log the log
	 */
	private static void logger(String log)
	{
		try
		{
			FileWriter fw = new FileWriter("log.txt", true);
			fw.write("log: " + CurrentDate.getCurrentDate() + " : " + log + "\n");
			fw.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
