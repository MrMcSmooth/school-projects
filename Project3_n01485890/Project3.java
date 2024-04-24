import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The Class Project3.
 */
public class Project3 {
	
	/** The employee file name. */
	static String employeeFileName = "employee_data.csv";
	
	/** The tier 1 ticket file name. */
	static String tier1TicketFileName = "tier1_ticket_data.csv";
	
	/** The tier 2 ticket file name. */
	static String tier2TicketFileName = "tier2_ticket_data.csv";
	
	/** The work order file name. */
	static String workOrderFileName = "workorder_data.csv";
	
	/** The employee list. */
	static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	/** The tier 1 ticket list. */
	static Queue<Ticket> tier1TicketList = new LinkedList<Ticket>();
	
	/** The tier 2 ticket list. */
	static Queue<Ticket> tier2TicketList = new LinkedList<Ticket>();
	
	/** The work order list. */
	static ArrayList<WorkOrder> workOrderList = new ArrayList<WorkOrder>();

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
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
	
	/**
	 * Creates the work orders.
	 */
	public static void createWorkOrders()
	{
		System.out.println("Creating Work Orders");
		
		Queue<Employee> t1Emp = new LinkedList<Employee>();
		Queue<Tier2Employee> t2Emp = new LinkedList<Tier2Employee>();
		
		for(Employee e : employeeList)
		{
			if(e instanceof Tier2Employee)
			{
				Tier2Employee temp = (Tier2Employee) e;
				t2Emp.add(temp);
			}
			else
			{
				t1Emp.add(e);
			}
		}
		
		int size = tier2TicketList.size();
		
		for(int i = 0; i < size; i++)
		{
			for(;;)
			{
				Tier2Employee temp = t2Emp.poll();
				Ticket tTemp = tier2TicketList.poll();
				
				WorkOrder newWorkOrder = new WorkOrder(temp, tTemp, CurrentDate.getCurrentDate());
				
				t2Emp.offer(temp);
				workOrderList.add(newWorkOrder);
				break;
				
			}
		}
		
		size = tier1TicketList.size();
		
		for(int i = 0; i < size; i++)
		{
		
			for(;;)
			{
				Employee temp = t1Emp.poll();
				Ticket tTemp = tier1TicketList.poll();
				
				WorkOrder newWorkOrder = new WorkOrder(temp, tTemp, CurrentDate.getCurrentDate());
				t1Emp.offer(temp);
				workOrderList.add(newWorkOrder);
				
				break;
			}
		}

		
	}

}
