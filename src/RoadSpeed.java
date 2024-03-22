import java.util.Date;

public class RoadSpeed {
	
	private Date date;
	private String time = new String();
	private double speedSensor1;
	private double speedSensor2;
	
	public RoadSpeed(Date date, String time, double speedSensor1, double speedSensor2)
	{
		this.setDate(date);
		this.setTime(time);
		this.setSpeedSensor1(speedSensor1);
		this.setSpeedSensor2(speedSensor2);
	}
	
	public String getFileData()
	{
		String returnMe = new String();
		
		return returnMe;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getTime()
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}

	public double getSpeedSensor1()
	{
		return speedSensor1;
	}

	public void setSpeedSensor1(double speedSensor1)
	{
		this.speedSensor1 = speedSensor1;
	}

	public double getSpeedSensor2()
	{
		return speedSensor2;
	}

	public void setSpeedSensor2(double speedSensor2)
	{
		this.speedSensor2 = speedSensor2;
	}

}
