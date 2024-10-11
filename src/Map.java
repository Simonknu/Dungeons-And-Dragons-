import org.w3c.dom.ranges.Range;

public class Map {
    private Room startingRoom;
    private Enemy finalBoss;


    public Map() {
        builMap();
    }

    public void builMap() {

        //--------------------------create all the rooms---------------------------------------------

        Room room1 = new Room("the entrance", "It is a badly lighten room with nothing in it besides 2 doors");
        Room room2 = new Room("a hallway", "There is a window to the north lighting a dirty hallway with 2 more doors");
        Room room3 = new Room("a small divider", "You are in a small place in between 2 doors");
        Room room4 = new Room("the dinning room", "You stand across a long dinning and empty dinning table. a the other side of the table you can see 2 doors ");
        Room room5 = new Room("a storage room", "Looks like an abandoned storage room with old and rusty artifacts");
        Room room6 = new Room("the castles kitchen", "This is room 6");
        Room room7 = new Room("a big ball room", "you are in the middle of a majestic ballroom where you imagine all the people that have danced in here");
        Room room8 = new Room("the entrance to the kings room", "The only thing in the room is a gigantic door. You know the necromancer is in there");
        Room room9 = new Room("the kings room", "A big throne, a bunch of gold, and a menacing aura. This is where you will meet him", true);
        Room room10 = new Room("the laboratory", "You can see a bunch of twisted experiments with animals");

        //----------------------------------create layout of the room--------------------------------------
        startingRoom = room1;
        startingRoom.beenToTheRoom();


        room1.setRightRoom(room2);
        room1.setDownRoom(room3);
        room2.setDownRoom(room4);
        room3.setLeftRoom(room5);
        room4.setRightRoom(room6);
        room4.setDownRoom(room7);
        room6.setDownRoom(room10);
        room7.setRightRoom(room10);
        room7.setDownRoom(room8);
        room8.setLeftRoom(room9);
        //------------------------------------------Normal Items------------------------------------------------
        Item lamp = new Item("a broken lamp", "lamp");
        Item goldBar = new Item("shiny gold bar", "Gold");
        Item key = new Item("a worn out key", "key");

        room2.addItem(lamp);
        room7.addItem(goldBar);
        room10.addItem(key);
        //------------------------------------------- Good Food-------------------------------------------------------
        Food apple = new Food(20, false, "a ripe apple", "apple");
        Food chocolateBar = new Food(15, false, "a tasty looking chocolate bar", "chocolate");
        Food bagOfChips = new Food(10, false, "a bag of chips", "chips");

        room2.addItem(bagOfChips);
        room5.addItem(apple);
        room8.addItem(chocolateBar);
        //-------------------------------------------Bad Food----------------------------
        Food potato = new Food(-15, true, "a raw potato", "potato");
        Food bread = new Food(-5, true, "an old piece of bread", "bread");
        Food yoghurt = new Food(-20, true, "some interesting looking yoghurt", "yoghurt");

        room3.addItem(potato);
        room7.addItem(bread);
        room10.addItem(yoghurt);
        //-------------------------------------------------Weapons--------------------------------------------------
        MeleeWeapon sword = new MeleeWeapon("rusty Sword", "sword", 10);
        MeleeWeapon knife = new MeleeWeapon("a golden knife", "knife", 30);
        RangeWeapon shotgun = new RangeWeapon("The all killing shotgun", "shotgun", 20, 8);
        RangeWeapon paintballGun = new RangeWeapon("a paintball gun", "gun", 1, 1000);
        MeleeWeapon magicStaff = new MeleeWeapon("a magic staff", "staff", 40);
        MeleeWeapon apprenticeStaff = new MeleeWeapon("A copy of the necromancers magical artifact", "artifact", 20);


        room5.addItem(sword);
        room7.addItem(paintballGun);
        room10.addItem(shotgun);

        //----------------------------------------Enemies----------------------------------------------
        Enemy guard = new Enemy("Guard", "It look similar to the knight, however is twice as big. \n Royal Guard: No one will pass through this doors", "I have disappointed the master. ", 50, sword);
        Enemy knight = new Enemy("Knight", "It looks like blood was coming out of his armor but it already dried out. \n Knight: You should be here. Go back before you regret it.", "Knight: You won against me but it wont be this easy with the other ones.", 20, sword);
        Enemy civilian = new Enemy("Civilian", "It looks like a cadaver walking around \nDead Civilian: Trust me and run away. You dont want to end up like me.", "Thanks for ending my suffering!", 15, knife );
        Enemy apprentice = new Enemy("Apprentice", "Apprentice: You wont even beat me and my master is a tousand times stronger", "Apprentice: You will regret ever walking into this castle!!!", 40, sword);
        Enemy necromancer = new Enemy("Necromancer", "Necromancer: Lets just finnish this quickly so I can go back to reading my book", "Necromancer: I cant believe you killed me! I will find a way to haunt you for eternity", 60, magicStaff);

        finalBoss = necromancer;
        room2.addEnemy(knight);
        room4.addEnemy(civilian);
        room10.addEnemy(apprentice);
        room8.addEnemy(guard);
        room9.addEnemy(necromancer);
    }
        //------------------------------------Getter Methods------------------------------------------------

    public Room getStartingRoom() {
        return startingRoom;
    }

    public Enemy getFinalBoss(){
        return finalBoss;
    }

}
