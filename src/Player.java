import java.util.ArrayList;
import java.util.Iterator;

public class Player {
    private Room roomPLayerIsIn;
    private ArrayList<Item> inventory;


    public Player(Room roomPLayerIsIn) {
        this.roomPLayerIsIn = roomPLayerIsIn;
        this.inventory = new ArrayList<Item>();

    }


    public Room getRoomPLayerIsIn() {
        return roomPLayerIsIn;
    }

    //----------------------------To move the player --------------------------------------------------------
    public void movePlayer(String direction) {
        switch (direction) {
            case "north" -> {
                if (getRoomPLayerIsIn().getUpRoom() != null) {
                    roomPLayerIsIn = roomPLayerIsIn.getUpRoom();
                    System.out.println("You moved to the room above");
                    roomPLayerIsIn.enterRoom();
                } else {
                    System.out.println("There are no rooms above");
                }
            }

            case "south" -> {
                if (roomPLayerIsIn.getDownRoom() != null) {
                    roomPLayerIsIn = roomPLayerIsIn.getDownRoom();
                    System.out.println("you moved to the rooms bellow");
                    roomPLayerIsIn.enterRoom();
                } else {
                    System.out.println("There are no rooms bellow");
                }
            }

            case "east" -> {
                if (roomPLayerIsIn.getRightRoom() != null) {
                    roomPLayerIsIn = roomPLayerIsIn.getRightRoom();
                    System.out.println("You moved to the room to the east");
                    roomPLayerIsIn.enterRoom();
                } else {
                    System.out.println("There are no rooms to the east");
                }
            }

            case "west" -> {
                if (roomPLayerIsIn.getLeftRoom() != null) {
                    roomPLayerIsIn = roomPLayerIsIn.getLeftRoom();
                    System.out.println("You moved to the room to the west");
                    roomPLayerIsIn.enterRoom();
                } else {
                    System.out.println("There are no rooms to the west");

                }
            }
        }
    }
    //----------------Items------------------------------------------

    public ArrayList<Item> getInventory() {
        return inventory;


    }


    public void showInventory() {
        for (Item i : inventory) {
            System.out.print(i.getName() + ", ");
        }

    }


    public void takeItem(String name) {
        boolean itemFound = false;
        Iterator<Item> iterator = roomPLayerIsIn.getItemsInRoom().iterator();

        while (iterator.hasNext()) {
            Item i = iterator.next();
            if (name.equalsIgnoreCase(i.getFindName())) {
                inventory.add(i);
                iterator.remove(); // Safely remove the item using the iterator
                itemFound = true;
                System.out.println("You have taken the " + name);
                break; // Exit the loop once the item is found and taken
            }
        }

        if (!itemFound) {
            System.out.println("There is not a " + name + " in this room");
        }
    }


    public void dropItem(String name) {
        boolean itemFound = false;
        for (int i = 0; i < inventory.size(); i++) {
            Item j = inventory.get(i);
            if (name.equalsIgnoreCase(j.getFindName())) {
                inventory.remove(j);
                roomPLayerIsIn.getItemsInRoom().add(j);
                itemFound = true;

            }
        }
        if (!itemFound) {
            System.out.println("You dont have a " + name + " in your inventory");
        }
    }

}




