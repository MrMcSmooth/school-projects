import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class CurrentDate.
 */
public class CurrentDate
{
	
	/**
	 * Gets the current date.
	 *
	 * @return the current date
	 */
	public static String getCurrentDate()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		Date date = new Date();
		
		return dateFormat.format(date);
	}
}
