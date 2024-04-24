
/**
 * The Class WorkOrder.
 */
public class WorkOrder implements Printable
{
	
	/** The employee. */
	private Employee employee;
	
	/** The ticket. */
	private Ticket ticket;
	
	/** The created at. */
	private String createdAt;
	
	/**
	 * Instantiates a new work order.
	 *
	 * @param employee the employee
	 * @param ticket the ticket
	 * @param createdAt the created at
	 */
	public WorkOrder(Employee employee, Ticket ticket, String createdAt)
	{
		this.setEmployee(employee);
		this.setTicket(ticket);
		this.setCreatedAt(createdAt);
	}
	
	/**
	 * Gets the file data.
	 *
	 * @return the file data
	 */
	@Override
	public String getFileData()
	{
		String fileData = ticket.getFileData();
		fileData = fileData.concat("," + this.createdAt + "," + employee.getFileData());

		if(employee instanceof Tier2Employee)
		{
			Tier2Employee empCast = (Tier2Employee)employee;
			fileData = fileData.concat("," + empCast.getCertification());
		}
		
		return fileData;
	}
	
	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public Employee getEmployee()
	{
		return employee;
	}
	
	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
	
	/**
	 * Gets the ticket.
	 *
	 * @return the ticket
	 */
	public Ticket getTicket() 
	{
		return ticket;
	}
	
	/**
	 * Sets the ticket.
	 *
	 * @param ticket the new ticket
	 */
	public void setTicket(Ticket ticket)
	{
		this.ticket = ticket;
	}
	
	/**
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	public String getCreatedAt()
	{
		return createdAt;
	}
	
	/**
	 * Sets the created at.
	 *
	 * @param createdAt the new created at
	 */
	public void setCreatedAt(String createdAt)
	{
		this.createdAt = createdAt;
	}

}
