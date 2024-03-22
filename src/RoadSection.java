
public class RoadSection {
	
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
	
	private int calcVolumeTotal()
	{
		int returnMe;
		
		return returnMe;
	}
	
	private double calcVolumeAvg()
	{
		double returnMe;
		
		return returnMe;
	}
	
	private double calcSpeedAvg()
	{
		double returnMe;
		
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
}
