
import java.io.*;
import java.text.*;
import java.util.*;

public class FileHandler {
	
	public static ArrayList<RoadVolume> loadVolumeData(String fileName) throws FileNotFoundException, ParseException
	{
		ArrayList<RoadVolume> volumeData = new ArrayList<RoadVolume>();
		
			File f = new File(fileName);
			Scanner fr = new Scanner(f);
			
			String line = fr.nextLine();
			
			while(fr.hasNextLine())
			{
				line = fr.nextLine();
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
	
	public static ArrayList<RoadSpeed> loadSpeedData(String fileName) throws FileNotFoundException, ParseException
	{
		ArrayList<RoadSpeed> speedData = new ArrayList<RoadSpeed>();
		
		File f = new File(fileName);
		Scanner fr = new Scanner(f);
		
		String line = fr.nextLine();
		
		while(fr.hasNextLine())
		{
			line = fr.nextLine();
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
	
	public static void writeRoadSectionData(ArrayList<RoadSection> sectionList)
	{
		
	}
}//end class
