
/**
 * The Class Tier2Employee.
 */
public class Tier2Employee extends Employee
{
	
	/** The certification. */
	private String certification;

	/**
	 * Instantiates a new tier 2 employee.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param address the address
	 * @param phoneNumber the phone number
	 * @param email the email
	 * @param employeeId the employee id
	 * @param clockedIn the clocked in
	 * @param hiredDate the hired date
	 * @param certification the certification
	 */
	public Tier2Employee(String firstName, String lastName, String address, String phoneNumber, String email,
			String employeeId, String clockedIn, String hiredDate, String certification)
	{
		super(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate);
		this.setCertification(certification);
	}

	/**
	 * Gets the file data.
	 *
	 * @return the file data
	 */
	@Override
	public String getFileData()
	{
		String fileData = super.getFileData();
		fileData = fileData.concat("," + this.certification);
		
		return fileData;
	}

	/**
	 * Gets the certification.
	 *
	 * @return the certification
	 */
	public String getCertification()
	{
		return certification;
	}

	/**
	 * Sets the certification.
	 *
	 * @param certification the new certification
	 */
	public void setCertification(String certification)
	{
		this.certification = certification;
	}

}
