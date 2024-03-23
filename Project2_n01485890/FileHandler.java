
import java.io.*;
import java.text.*;
import java.util.*;

/**
 * The Class FileHandler.
 */
public class FileHandler
{
	
	/**
	 * Load volume data.
	 *
	 * @param fileName the file name
	 * @return the array list
	 * @throws FileNotFoundException the file not found exception
	 * @throws ParseException the parse exception
	 */
	public static ArrayList<RoadVolume> loadVolumeData(String fileName) throws FileNotFoundException, ParseException
	{
		ArrayList<RoadVolume> volumeData = new ArrayList<RoadVolume>();
		
			File f = new File(fileName);
			Scanner fr = new Scanner(f);
			
			String fileHeader = fr.nextLine();
			
			while(fr.hasNextLine())
			{
				String line = fr.nextLine();
				String[] temp = line.split(",");
				
				SimpleDateFormat currentFormat = new SimpleDateFormat("MM/dd/yy");
				SimpleDateFormat newFormat = new SimpleDateFormat("MM/dd/yyyy"); 
								
				Date dateObject = currentFormat.parse(temp[0]);
				String dateString = newFormat.format(dateObject);
					
				Date newDate = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
				int vs1 = Integer.parseInt(temp[2]);
				int vs2 = Integer.parseInt(temp[3]);
				int vs3 = Integer.parseInt(temp[4]);
				int vs4 = Integer.parseInt(temp[5]);
					
				RoadVolume newRoadVolume = new RoadVolume(newDate, temp[1], vs1, vs2, vs3, vs4);
				volumeData.add(newRoadVolume);
			}
		return volumeData;
	}
	
	/**
	 * Load speed data.
	 *
	 * @param fileName the file name
	 * @return the array list
	 * @throws FileNotFoundException the file not found exception
	 * @throws ParseException the parse exception
	 */
	public static ArrayList<RoadSpeed> loadSpeedData(String fileName) throws FileNotFoundException, ParseException
	{
		ArrayList<RoadSpeed> speedData = new ArrayList<RoadSpeed>();
		
		File f = new File(fileName);
		Scanner fr = new Scanner(f);
		
		String fileHeader = fr.nextLine();
		
		while(fr.hasNextLine())
		{
			String line = fr.nextLine();
			String[] temp = line.split(",");
			
			SimpleDateFormat currentFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat newFormat = new SimpleDateFormat("MM/dd/yyyy"); 
							
			Date dateObject = currentFormat.parse(temp[0]);
			String dateString = newFormat.format(dateObject);
				
			Date newDate = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
			double vs1 = Double.parseDouble(temp[2]);
			double vs2 = Double.parseDouble(temp[3]);
			
			RoadSpeed newRoadSpeed = new RoadSpeed(newDate, temp[1], vs1, vs2);
			speedData.add(newRoadSpeed);
		}
		return speedData;
	}
	
	/**
	 * Write road section data.
	 *
	 * @param sectionList the section list
	 */
	public static void writeRoadSectionData(ArrayList<RoadSection> sectionList)
	{
		try
		{
			FileWriter fw = new FileWriter("Road_Section_Data.csv", true);
			fw.write("Date,Time,Volume_Sensor_2003,Volume_Sensor_2004,Volume_Sensor_2005,Volume_Sensor,Speed_Sensor_2282,Speed_Sensor_2293,Volume_Total,Volume_Avg,Speed_Avg");
			for(int i = 0; i < sectionList.size(); i++)
			{
				fw.append("\n" + sectionList.get(i).getFileData());
			}
			fw.close();
			System.out.println("Road Section Data Created");
		} catch (IOException e)
		{
			
			String msg = e.getMessage();
			System.out.println(msg);
		}
	}
}//end class
