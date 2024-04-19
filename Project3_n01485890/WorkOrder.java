
public class WorkOrder implements Printable
{
	private Employee employee;
	private Ticket ticket;
	private String createdAt;
	
	public WorkOrder(Employee employee, Ticket ticket, String createdAt)
	{
		this.setEmployee(employee);
		this.setTicket(ticket);
		this.setCreatedAt(createdAt);
	}
	
	@Override
	public String getFileData()
	{
		String fileData = ticket.getCustomer().getCustomerId();
		fileData = fileData.concat("," + ticket.getCustomer().getFirstName() + "," + ticket.getCustomer().getLastName() + "," + ticket.getTicketId() + "," + ticket.getCreatedAt());
		fileData = fileData.concat("," + this.createdAt + "," + employee.getEmployeeId() + "," + employee.getFirstName() + "," + employee.getLastName() + "," + employee.getClockedIn());
		if(employee instanceof Tier2Employee)
		{
			Tier2Employee empCast = (Tier2Employee)employee;
			fileData = fileData.concat(empCast.getCertification());
		}
		
		return fileData;
	}
	
	public Employee getEmployee()
	{
		return employee;
	}
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
	public Ticket getTicket() 
	{
		return ticket;
	}
	public void setTicket(Ticket ticket)
	{
		this.ticket = ticket;
	}
	public String getCreatedAt()
	{
		return createdAt;
	}
	public void setCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
	}

}
