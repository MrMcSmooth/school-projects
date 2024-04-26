import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler {
	
	private String surveyFile = "survey_results.csv";
	private FileWriter fileOutput;
	private PrintWriter printWriter;
	
	public FileHandler() throws IOException
	{
		fileOutput = new FileWriter(surveyFile);
		printWriter = new PrintWriter(fileOutput);
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
