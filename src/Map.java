public class Map {
public Room startingRoom;
public Room finnishRoom;
public Map(){
    builMap();
}

public void builMap(){

    Room room1 = new Room("Room 1", "This is room 1");
    Room room2 = new Room("Room 2", "This is room 2");
    Room room3 = new Room("Room 3", "This is room 3");
    Room room4 = new Room("Room 4", "This is room 4");
    Room room5 = new Room("Room 5", "This is room 5");
    Room room6 = new Room("Room 6", "This is room 6");
    Room room7 = new Room("Room 7", "This is room 7");
    Room room8 = new Room("Room 8", "This is room 8");
    Room room9 = new Room("Room 9", "This is room 9");

    room1.setRightRoom(room2);
    room1.setDownRoom(room4);
    room2.setRightRoom(room3);
    room3.setDownRoom(room6);
    room4.setDownRoom(room7);
    room6.setDownRoom(room9);
    room7.setRightRoom(room8);
    room8.setUpRoom(room5);
    room8.setRightRoom(room9);

startingRoom = room1;
startingRoom.beenToTheRoom();
finnishRoom = room5;

}

}
