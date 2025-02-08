// Michael McCarthy 
// N01485890
// Assignment 6


import java.util.*;

public class Room
{
	
	 private int id;
	 private List<Neighbor> neighbors;
	 
	 
	public Room(int id)
	{
		this.setId(id);
		this.setNeighbors(new ArrayList<>());
	}
	
	public void addNeighbor(int neighborId, int dangerLevel)
	{
		neighbors.add(new Neighbor(neighborId, dangerLevel));
	}
	
	public List<Neighbor> getNeighbors()
	{
		return neighbors;
	}

	public void setNeighbors(List<Neighbor> neighbors)
	{
		this.neighbors = neighbors;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	 public int getDangerLevel(int neighborId) {
	        for (Neighbor neighbor : neighbors) {
	            if (neighbor.getId() == neighborId) {
	                return neighbor.getDangerLevel();
	            }
	        }
	        return 0;
	    }
	
	public static class Neighbor 
	{
		private int id;
		private int dangerLevel;
		
		public Neighbor(int id, int dangerLevel)
		{
			this.setId(id);
			this.setDangerLevel(dangerLevel);
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getDangerLevel() {
			return dangerLevel;
		}

		public void setDangerLevel(int dangerLevel) {
			this.dangerLevel = dangerLevel;
		}
	}
}
