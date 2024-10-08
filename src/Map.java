public class Map {
    private Room startingRoom;
    private Room finnishRoom;


    public Map() {
        builMap();
    }

    public void builMap() {

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
        //------------------------------------------Items------------------------------------------------
        Item lamp = new Item("old lamp", "lamp");
        Item torch = new Item("worn out torch", "torch");
        //-------------------------------------------Food-------------------------------------------------------
        Food apple = new Food(10, false, "A good looking apple", "apple");
        Food pear = new Food(-15, true, "A not so good looking pear", "pear");
//-------------------------------------------------Weapons--------------------------------------------------
        MeleeWeapon sword = new MeleeWeapon("rusty Sword", "sword");
        RangeWeapon bow = new RangeWeapon("professional bow", "bow", 10);
        //------------------------------------ add the items in the rooms----------------------------------------
        room2.addItem(lamp);
        room2.addItem(torch);
        room3.addItem(apple);
        room3.addItem(pear);
        room4.addItem(sword);
        room4.addItem(bow);


        startingRoom = room1;
        startingRoom.beenToTheRoom();
        finnishRoom = room5;

    }

    // get methods
    public Room getStartingRoom() {
        return startingRoom;
    }

    public Room getFinnishRoom() {
        return finnishRoom;
    }

}
