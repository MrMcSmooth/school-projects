import java.text.*;
import java.util.*;

/**
 * The Class RoadSpeed.
 */
public class RoadSpeed
{
	
	/** The date. */
	private Date date;
	
	/** The time. */
	private String time = new String();
	
	/** The speed sensor 1. */
	private double speedSensor1;
	
	/** The speed sensor 2. */
	private double speedSensor2;
	
	/**
	 * Instantiates a new road speed.
	 *
	 * @param date the date
	 * @param time the time
	 * @param speedSensor1 the speed sensor 1
	 * @param speedSensor2 the speed sensor 2
	 */
	public RoadSpeed(Date date, String time, double speedSensor1, double speedSensor2)
	{
		this.setDate(date);
		this.setTime(time);
		this.setSpeedSensor1(speedSensor1);
		this.setSpeedSensor2(speedSensor2);
	}
	
	/**
	 * Gets the file data.
	 *
	 * @return the file data
	 */
	public String getFileData()
	{
		Date date = this.date;
		SimpleDateFormat newFormat = new SimpleDateFormat("MM/dd/yyyy"); 
		String strDate = newFormat.format(date);
		String fileData = strDate;
		//adding time
		fileData = fileData.concat("," + getTime());
		//adding sensors
		String vs1 = Double.toString(getSpeedSensor1());
		String vs2 = Double.toString(getSpeedSensor2());
		fileData = fileData.concat("," + vs1).concat("," + vs2);
		
		return fileData;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public String getTime()
	{
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time the new time
	 */
	public void setTime(String time)
	{
		this.time = time;
	}

	/**
	 * Gets the speed sensor 1.
	 *
	 * @return the speed sensor 1
	 */
	public double getSpeedSensor1()
	{
		return speedSensor1;
	}

	/**
	 * Sets the speed sensor 1.
	 *
	 * @param speedSensor1 the new speed sensor 1
	 */
	public void setSpeedSensor1(double speedSensor1)
	{
		this.speedSensor1 = speedSensor1;
	}

	/**
	 * Gets the speed sensor 2.
	 *
	 * @return the speed sensor 2
	 */
	public double getSpeedSensor2()
	{
		return speedSensor2;
	}

	/**
	 * Sets the speed sensor 2.
	 *
	 * @param speedSensor2 the new speed sensor 2
	 */
	public void setSpeedSensor2(double speedSensor2)
	{
		this.speedSensor2 = speedSensor2;
	}
}//end class
