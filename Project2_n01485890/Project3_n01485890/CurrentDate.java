import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDate
{
	
	public static String getCurrentDate()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		Date date = new Date();
		
		return dateFormat.format(date);
	}
}
