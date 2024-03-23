
/**
 * The Class RoadSection.
 */
public class RoadSection
{	
	
	/** The road volume. */
	private RoadVolume roadVolume;
	
	/** The road speed. */
	private RoadSpeed roadSpeed;
	
	/** The volume total. */
	private int volumeTotal;
	
	/** The volume avg. */
	private double volumeAvg;
	
	/** The speed avg. */
	private double speedAvg;
	
	/**
	 * Instantiates a new road section.
	 *
	 * @param roadVolume the road volume
	 * @param roadSpeed the road speed
	 */
	public RoadSection(RoadVolume roadVolume, RoadSpeed roadSpeed)
	{
		this.setRoadVolume(roadVolume);
		this.setRoadSpeed(roadSpeed);
		this.setVolumeTotal(calcVolumeTotal());
		this.setVolumeAvg(calcVolumeAvg());
		this.setSpeedAvg(calcSpeedAvg());
	}
	
	/**
	 * Gets the file data.
	 *
	 * @return the file data
	 */
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
		//adding totals and avgs to file data
		fileData = fileData.concat("," + calcVolumeTotal());
		
		fileData = fileData.concat("," + calcVolumeAvg());
		
		fileData = fileData.concat("," + calcSpeedAvg());
		
		return fileData;
	}
	
	/**
	 * Calc volume total.
	 *
	 * @return the int
	 */
	private int calcVolumeTotal()
	{
		int volumeTotal = 0;
		String volume = roadVolume.getFileData(); 
		String[] roadVolumeArr = volume.split(",");
		
		for(int i = 2; i < roadVolumeArr.length; i++)
		{
			volumeTotal += Integer.parseInt(roadVolumeArr[i]);
		}
		
		return volumeTotal;
	}
	
	/**
	 * Calc volume avg.
	 *
	 * @return the double
	 */
	private double calcVolumeAvg()
	{
		
		double volumeAvg = calcVolumeTotal() / 4.0;//4 is number of sensors
		
		return volumeAvg;
	}
	
	/**
	 * Calc speed avg.
	 *
	 * @return the double
	 */
	private double calcSpeedAvg()
	{
		double speedAvg = 0;
		
		String speeds = roadSpeed.getFileData(); 
		String[] roadSpeedsArr = speeds.split(",");
		
		for(int i = 2; i < roadSpeedsArr.length; i++)
		{
			speedAvg += Double.parseDouble(roadSpeedsArr[i]);
		}
	
		return speedAvg / 2.0;//2 is # of sensors
	}

	/**
	 * Gets the road volume.
	 *
	 * @return the road volume
	 */
	public RoadVolume getRoadVolume()
	{
		return roadVolume;
	}

	/**
	 * Sets the road volume.
	 *
	 * @param roadVolume the new road volume
	 */
	public void setRoadVolume(RoadVolume roadVolume)
	{
		this.roadVolume = roadVolume;
	}

	/**
	 * Gets the road speed.
	 *
	 * @return the road speed
	 */
	public RoadSpeed getRoadSpeed()
	{
		return roadSpeed;
	}

	/**
	 * Sets the road speed.
	 *
	 * @param roadSpeed the new road speed
	 */
	public void setRoadSpeed(RoadSpeed roadSpeed)
	{
		this.roadSpeed = roadSpeed;
	}

	/**
	 * Gets the volume total.
	 *
	 * @return the volume total
	 */
	public int getVolumeTotal()
	{
		return volumeTotal;
	}

	/**
	 * Sets the volume total.
	 *
	 * @param volumeTotal the new volume total
	 */
	public void setVolumeTotal(int volumeTotal)
	{
		this.volumeTotal = volumeTotal;
	}

	/**
	 * Gets the volume avg.
	 *
	 * @return the volume avg
	 */
	public double getVolumeAvg()
	{
		return volumeAvg;
	}

	/**
	 * Sets the volume avg.
	 *
	 * @param volumeAvg the new volume avg
	 */
	public void setVolumeAvg(double volumeAvg)
	{
		this.volumeAvg = volumeAvg;
	}

	/**
	 * Gets the speed avg.
	 *
	 * @return the speed avg
	 */
	public double getSpeedAvg()
	{
		return speedAvg;
	}

	/**
	 * Sets the speed avg.
	 *
	 * @param speedAvg the new speed avg
	 */
	public void setSpeedAvg(double speedAvg){
		this.speedAvg = speedAvg;
	}
}//end class
