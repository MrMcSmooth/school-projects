import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class FileHandler.
 */
public class FileHandler {
	
	/** The survey file. */
	private String surveyFile = "survey_results.csv";
	
	/** The file output. */
	private FileWriter fileOutput;
	
	/** The print writer. */
	private PrintWriter printWriter;
	
	/**
	 * Instantiates a new file handler.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public FileHandler() throws IOException
	{
		fileOutput = new FileWriter(surveyFile);
		fileOutput.write("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight\n");
	}
	
	/**
	 * Write results.
	 *
	 * @param surveyData the survey data
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void writeResults(String surveyData) throws IOException
	{
		printWriter = new PrintWriter(fileOutput, true);
		printWriter.println(getCurrentDate() + "," + surveyData);
		//printWriter.close();
	}
	
	/**
	 * Gets the current date.
	 *
	 * @return the current date
	 */
	private static String getCurrentDate()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		Date date = new Date();
		
		return dateFormat.format(date);
	}
	

}
