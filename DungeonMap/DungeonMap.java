// Michael McCarthy 
// N01485890
// Assignment 6

import java.util.*;

public class DungeonMap
{
	private Map<Integer, Room> rooms;
	
	public DungeonMap()
	{
		this.rooms = new HashMap<>();
		
	}
	
	public void addRoom(Room room)
	{
		rooms.put(room.getId(), room);
	}
	
	public Map<Integer, Room> getRooms()
	{
	    return rooms;
	}
	

    public Room getRoom(int roomId)
    {
        return rooms.get(roomId);
    }
	
	public int getDangerLevel(int room1Id, int room2Id)
	{
        Room room1 = getRoom(room1Id);
        if (room1 != null)
        {
            return room1.getDangerLevel(room2Id);
        }
        return 0;
    }
	
	public void connectRooms(int room1Id, int room2Id, int dangerLevel)
	{
		Room room1 = rooms.get(room1Id);
		Room room2 = rooms.get(room2Id);
		if(room1 != null && room2 != null)
		{
			room1.addNeighbor(room2Id, dangerLevel);
			room2.addNeighbor(room1Id, dangerLevel);
		}
	}
	
	private List<Integer> reconstructPath(Map<Integer, Integer> predecessors, int startId, int endId)
	{
		List<Integer> path = new ArrayList<>();
		for(int ii = endId; ii != startId; ii = predecessors.getOrDefault(ii, -1))
		{
			if(ii == -1)
			{
				return new ArrayList<>();
			}
			path.add(ii);
		}
		path.add(startId);
		Collections.reverse(path);
		return path;
	}
	
	public List<Integer> findSafestPath(int startId, int endId)
	{
		
		Map<Integer, Integer> dangerLevels = new HashMap<>();
        Map<Integer, Integer> predecessors = new HashMap<>();
        PriorityQueue<int[]> pQueue = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        
        for(int roomId : rooms.keySet())
        {
        	dangerLevels.put(roomId, Integer.MAX_VALUE);
        }
        dangerLevels.put(startId, 0);
        pQueue.add(new int[]{startId, 0});
        
        while(!pQueue.isEmpty())
        {
        	int[] current = pQueue.poll();
        	int currentRoom = current[0];
        	int currentDanger = current[1];
        	
        	if(currentDanger > dangerLevels.get(currentRoom))
        	{
        		continue;
        	}
	
        	for(Room.Neighbor neighbor : rooms.get(currentRoom).getNeighbors())
        	{
        		int neighborId = neighbor.getId();
        		int pathDanger = currentDanger + neighbor.getDangerLevel();
        		
        		if(pathDanger < dangerLevels.get(neighborId))
        		{
        			dangerLevels.put(neighborId, pathDanger);
        			predecessors.put(neighborId, currentRoom);
        			pQueue.add(new int[]{neighborId, pathDanger});
        		}
        	}
        }
        
        return reconstructPath(predecessors, startId, endId);
        
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
