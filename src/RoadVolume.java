import java.util.Date;

public class RoadVolume {
	
	private Date date;
	private String time = new String();
	private int volumeSensor1;
	private int volumeSensor2;
	private int volumeSensor3;
	private int volumeSensor4;
	
	public RoadVolume(Date date, String time, int volumeSensor1, int volumeSensor2, int volumeSensor3, int volumeSensor4)
	{
		this.setDate(date);
		this.setTime(time);
		this.setVolumeSensor1(volumeSensor1);
		this.setVolumeSensor2(volumeSensor2);
		this.setVolumeSensor3(volumeSensor3);
		this.setVolumeSensor4(volumeSensor4);
	}
	
	public String getFileData()
	{
		String fileData = new String();
		
		return fileData;
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

	public int getVolumeSensor1()
	{
		return volumeSensor1;
	}

	public void setVolumeSensor1(int volumeSensor1)
	{
		this.volumeSensor1 = volumeSensor1;
	}

	public int getVolumeSensor2()
	{
		return volumeSensor2;
	}

	public void setVolumeSensor2(int volumeSensor2)
	{
		this.volumeSensor2 = volumeSensor2;
	}

	public int getVolumeSensor3()
	{
		return volumeSensor3;
	}

	public void setVolumeSensor3(int volumeSensor3)
	{
		this.volumeSensor3 = volumeSensor3;
	}

	public int getVolumeSensor4()
	{
		return volumeSensor4;
	}

	public void setVolumeSensor4(int volumeSensor4)
	{
		this.volumeSensor4 = volumeSensor4;
	}

	
}
