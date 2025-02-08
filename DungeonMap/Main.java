// Michael McCarthy
// N01485890
// Assignment 6

import java.util.*;
import java.io.*;

public class Main
{

	public static void main(String[] args)
	{
		try(Scanner scn = new Scanner(new File("dungeonmap1.txt")))
		{
			int numRooms = scn.nextInt();
			DungeonMap dungeonMap = new DungeonMap();
			
			for(int ii = 0; ii < numRooms; ii++)
			{
				int roomId = scn.nextInt();
				int numNeighbors = scn.nextInt();
				Room room = new Room(roomId);
				
				for(int jj = 0; jj < numNeighbors; jj++)
				{
					int neighborId = scn.nextInt();
					int dangerLevel = scn.nextInt();
					room.addNeighbor(neighborId, dangerLevel);
				}
				dungeonMap.addRoom(room);
			}
			
			List<int[]> connections = new ArrayList<>();
			for(Room room : dungeonMap.getRooms().values())
			{
				for(Room.Neighbor neighbor : room.getNeighbors())
				{
					connections.add(new int[]{room.getId(), neighbor.getId(), neighbor.getDangerLevel()});
				}
			}
			
			for (int[] connection : connections) {
			    dungeonMap.connectRooms(connection[0], connection[1], connection[2]);
			}
			
			int startId = 1;
			int endId = numRooms;
			List<Integer> path = dungeonMap.findSafestPath(startId, endId);
			
			if (path.isEmpty()) {
                System.out.println("No safe path exist. You're trapped! D;");
                return;
            }

            System.out.println("Safest Escape Path:\n");

            int totalDanger = 0;
            for (int i = 0; i < path.size() - 1; i++) {
                int currentRoom = path.get(i);
                int nextRoom = path.get(i + 1);
                int dangerLevel = dungeonMap.getDangerLevel(currentRoom, nextRoom);
                totalDanger += dangerLevel;
                System.out.println("Room " + currentRoom + " -> Room " + nextRoom + " (Danger Level: " + dangerLevel + ")");
            }

            System.out.println("\nTotal Danger Level: " + totalDanger);
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

	
	
	
	
	
	
	
	

}















