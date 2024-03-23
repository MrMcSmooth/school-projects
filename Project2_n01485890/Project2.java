/*
 * Author:		Michael McCarthy
 * Course:		COP3503
 * Project #:	2
 * Title:		Input/Output
 * Due Date:	3/24/2024
 * 
 * Inputs two file regarding speed and 
 * volume of cars during different days
 * and times, then outputs one file on
 * that section of road with the combined
 * data.
 */

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * The Class Project2.
 */
public class Project2
{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args)
	{
	
		String fileName = new String();
		ArrayList<RoadVolume> volumeData = new ArrayList<RoadVolume>();
		ArrayList<RoadSpeed> speedData = new ArrayList<RoadSpeed>();
		Scanner scnr = new Scanner(System.in);
		Boolean f = true;
		
		
		//loading volume data
		while(f)
		{
			System.out.println("Enter Path and Name of Volume Data File");
			try
			{
				
			fileName = scnr.nextLine();
			volumeData = FileHandler.loadVolumeData(fileName);
			
			f = false;
			}catch (FileNotFoundException e)
			{
				System.out.println(fileName + " (The system cannot find the file specified)");
				System.out.println();
				
				continue;
			} catch (ParseException e)
			{	
				String msg = e.getMessage();
				System.out.println(msg);
				continue;
			}
		}
		//loading speed data enter path
		while(!f)
		{
			System.out.println("Enter Path and Name of Speed Data File");
			
			try
			{
				fileName = scnr.nextLine();
				speedData = FileHandler.loadSpeedData(fileName);
				f = true;
			} catch (FileNotFoundException e) {
				System.out.println(fileName + " (The system cannot find the file specified)");
				System.out.println();
				continue;
			} catch (ParseException e)
			{
				String msg = e.getMessage();
				System.out.println(msg);
				continue;
			}	
		}//end while
		createRoadSections(volumeData, speedData);
		
	}//end main
	
	
	/**
	 * Creates the road sections.
	 *
	 * @param volumeList the volume list
	 * @param speedList the speed list
	 */
	public static void createRoadSections(ArrayList<RoadVolume> volumeList, ArrayList<RoadSpeed> speedList)
	{
		ArrayList<RoadSection> sectionData = new ArrayList<RoadSection>();
		for(int i = 0; i < volumeList.size(); i++)
		{
			for(int j = 0; j < speedList.size(); j++)
			{
				if(volumeList.get(i).getDate().compareTo(speedList.get(j).getDate()) == 0 && volumeList.get(i).getTime().equals(speedList.get(j).getTime()))
				{
					RoadSection newRoadSection = new RoadSection(volumeList.get(i), speedList.get(j));
					sectionData.add(newRoadSection);
				}//end if
			}//end j
		}//end i
		
		FileHandler.writeRoadSectionData(sectionData);
		
	}//end method
}//end class
