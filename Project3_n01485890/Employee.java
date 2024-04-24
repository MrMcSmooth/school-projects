

/**
 * The Class Employee.
 */
public class Employee extends Person
{
	
	/** The employee id. */
	private String employeeId;
	
	/** The clocked in. */
	private String clockedIn;
	
	/** The hired date. */
	private String hiredDate;
	
	/**
	 * Instantiates a new employee.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param address the address
	 * @param phoneNumber the phone number
	 * @param email the email
	 * @param employeeId the employee id
	 * @param clockedIn the clocked in
	 * @param hiredDate the hired date
	 */
	public Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeId, String clockedIn, String hiredDate)
	{
		super(firstName, lastName, address, phoneNumber, email);
		this.setEmployeeId(employeeId);
		this.setClockedIn(clockedIn);
		this.setHiredDate(hiredDate);
	}

	/**
	 * Gets the file data.
	 *
	 * @return the file data
	 */
	@Override
	public String getFileData()
	{
		String fileData = this.employeeId;
		fileData = fileData.concat("," + super.getFileData() + "," + this.clockedIn);
		
		return fileData;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public String getEmployeeId()
	{
		return employeeId;
	}
	
	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(String employeeId)
	{
		this.employeeId = employeeId;
	}
	
	/**
	 * Gets the clocked in.
	 *
	 * @return the clocked in
	 */
	public String getClockedIn()
	{
		return clockedIn;
	}
	
	/**
	 * Sets the clocked in.
	 *
	 * @param clockedIn the new clocked in
	 */
	public void setClockedIn(String clockedIn)
	{
		this.clockedIn = clockedIn;
	}
	
	/**
	 * Gets the hired date.
	 *
	 * @return the hired date
	 */
	public String getHiredDate()
	{
		return hiredDate;
	}
	
	/**
	 * Sets the hired date.
	 *
	 * @param hiredDate the new hired date
	 */
	public void setHiredDate(String hiredDate)
	{
		this.hiredDate = hiredDate;
	}

}
