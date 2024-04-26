import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler {
	
	private String surveyFile = "survey_results.csv";
	private FileWriter fileOutput = new FileWriter(surveyFile);
	private PrintWriter printWriter = new PrintWriter(fileOutput);
	
	public FileHandler() throws IOException
	{
		printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
	}
	
	public void writeResults(String surveyData) throws IOException
	{
		printWriter.println(getCurrentDate() + surveyData);
	}
	
	private static String getCurrentDate()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		Date date = new Date();
		
		return dateFormat.format(date);
	}
	
}
