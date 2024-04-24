
/**
 * The Class Person.
 */
public class Person implements Printable
{
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The address. */
	private String address;
	
	/** The phone number. */
	private String phoneNumber;
	
	/** The email. */
	private String email;
	
	/**
	 * Instantiates a new person.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param address the address
	 * @param phoneNumber the phone number
	 * @param email the email
	 */
	public Person(String firstName, String lastName, String address, String phoneNumber, String email)
	{
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
	}

	/**
	 * Gets the file data.
	 *
	 * @return the file data
	 */
	@Override
	public String getFileData()
	{
		String fileData = this.firstName;
		fileData = fileData.concat("," + this.lastName);
		
		return fileData;
	}


	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

}
