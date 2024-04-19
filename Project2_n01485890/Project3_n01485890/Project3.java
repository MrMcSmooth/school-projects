import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Project3 {
	
	static String employeeFileName = "employee_data.csv";
	static String tier1TicketFileName = "tier1_ticket_data.csv";
	static String tier2TicketFileName = "tier2_ticket_data.csv";
	static String workOrderFileName = "workorder_data.csv";
	static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	static Queue<Ticket> tier1TicketList = new LinkedList<Ticket>();
	static Queue<Ticket> tier2TicketList = new LinkedList<Ticket>();
	static ArrayList<WorkOrder> workOrderList = new ArrayList<WorkOrder>();

	public static void main(String[] args)
	{
		
		System.out.println("Project 3 Work Order Generator \n");
		
		try
		{
			
			FileHandler.readEmployeeData(employeeFileName);
			tier1TicketList = FileHandler.readTicketData(tier1TicketFileName);
			tier2TicketList = FileHandler.readTicketData(tier2TicketFileName);

			
		} catch (FileNotFoundException e)
		{
			
			System.out.println("File Not Found");
			
		}
		
		createWorkOrders();
		FileHandler.writeData(workOrderFileName);
		
		
	}
	
	public static void createWorkOrders()
	{
		System.out.println("Creating Work Orders");
		for(int i = 0; i < tier2TicketList.size(); i++)
		{
			for(int j = 0; j < employeeList.size(); j++)
			{
				if(employeeList.get(j) instanceof Tier2Employee)
				{
					Tier2Employee empCast = (Tier2Employee)employeeList.get(j);
					WorkOrder newWorkOrder = new WorkOrder(empCast, tier2TicketList.poll(), CurrentDate.getCurrentDate());
					employeeList.remove(j);
					workOrderList.add(newWorkOrder);
					break;
				}
			}
		}
		
		for(int i = 0; i < tier1TicketList.size(); i++)
		{
			for(int j = 0; j < employeeList.size(); j++)
			{
				if(employeeList.get(j) instanceof Tier2Employee)
				{
				} else
				{
					WorkOrder newWorkOrder = new WorkOrder(employeeList.get(j), tier1TicketList.poll(), CurrentDate.getCurrentDate());
					employeeList.remove(j);
					workOrderList.add(newWorkOrder);
					break;
				}
			}
		}

		
	}

}
