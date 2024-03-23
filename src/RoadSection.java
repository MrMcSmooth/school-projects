import java.util.*;

public class RoadSection
{	
	private RoadVolume roadVolume;
	private RoadSpeed roadSpeed;
	private int volumeTotal;
	private double volumeAvg;
	private double speedAvg;
	
	public RoadSection(RoadVolume roadVolume, RoadSpeed roadSpeed)
	{
		this.setRoadVolume(roadVolume);
		this.setRoadSpeed(roadSpeed);
		this.setVolumeTotal(calcVolumeTotal());
		this.setVolumeAvg(calcVolumeAvg());
		this.setSpeedAvg(calcSpeedAvg());
	}
	
	public String getFileData()
	{
		String fileData = roadVolume.getFileData();
	
		//removing date and time from speed data
		String temp = roadSpeed.getFileData();		
		String[] tempArr = temp.split(",");
		
		String[] newTempArr = new String[tempArr.length - 2];
		
		for(int i = 2; i < tempArr.length; i++)
		{
			String speedString = tempArr[i];
			fileData = fileData.concat("," + speedString);
		}
		
		
		
		
		//v total
		//v avg
		//s avg
		
		
		return fileData;
	}
	
	private int calcVolumeTotal()
	{
		int returnMe = 0;
		
		return returnMe;
	}
	
	private double calcVolumeAvg()
	{
		double returnMe = 0;
		
		return returnMe;
	}
	
	private double calcSpeedAvg()
	{
		double returnMe = 0;
		
		return returnMe;
	}

	public RoadVolume getRoadVolume()
	{
		return roadVolume;
	}

	public void setRoadVolume(RoadVolume roadVolume)
	{
		this.roadVolume = roadVolume;
	}

	public RoadSpeed getRoadSpeed()
	{
		return roadSpeed;
	}

	public void setRoadSpeed(RoadSpeed roadSpeed)
	{
		this.roadSpeed = roadSpeed;
	}

	public int getVolumeTotal()
	{
		return volumeTotal;
	}

	public void setVolumeTotal(int volumeTotal)
	{
		this.volumeTotal = volumeTotal;
	}

	public double getVolumeAvg()
	{
		return volumeAvg;
	}

	public void setVolumeAvg(double volumeAvg)
	{
		this.volumeAvg = volumeAvg;
	}

	public double getSpeedAvg()
	{
		return speedAvg;
	}

	public void setSpeedAvg(double speedAvg){
		this.speedAvg = speedAvg;
	}
}//end class
