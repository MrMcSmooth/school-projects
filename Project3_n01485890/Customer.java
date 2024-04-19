
public class Customer extends Person
{
	private String customerId;
	private String accountNumber;

	public Customer(String firstName, String lastName, String address, String phoneNumber, String email, String customerId, String accountNumber)
	{
		super(firstName, lastName, address, phoneNumber, email);
		this.setCustomerId(customerId);
		this.setAccountNumber(accountNumber);
	}
	@Override
	public String getFileData()
	{
		String fileData = super.getFileData();
		fileData = fileData.concat("," + this.customerId + "," + this.accountNumber);
		
		return fileData;
	}

	public String getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(String customerId)
	{
		this.customerId = customerId;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

}
