import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Player {
    private Room roomPLayerIsIn;
    private ArrayList<Item> inventory;
    private int health;
    private Weapon equipedWeapon;


    public Player(Room roomPLayerIsIn) {
        this.roomPLayerIsIn = roomPLayerIsIn;
        this.inventory = new ArrayList<Item>();
        this.health = 100;

    }


    public Room getRoomPLayerIsIn() {
        return roomPLayerIsIn;
    }

    public int getHealth() {
        return health;
    }

    //----------------------------To move the player --------------------------------------------------------
    public void movePlayer(String direction) {
        switch (direction) {
            case "north" -> {
                if (getRoomPLayerIsIn().getUpRoom() != null) {
                    roomPLayerIsIn = roomPLayerIsIn.getUpRoom();
                    System.out.println("> You moved to the room above");
                    roomPLayerIsIn.enterRoom();
                } else {
                    System.out.println("> There are no rooms north");
                }
            }

            case "south" -> {
                if (roomPLayerIsIn.getDownRoom() != null) {
                    roomPLayerIsIn = roomPLayerIsIn.getDownRoom();
                    System.out.println("> you moved to the room to the south");
                    roomPLayerIsIn.enterRoom();
                } else {
                    System.out.println("> There are no rooms south");
                }
            }

            case "east" -> {
                if (roomPLayerIsIn.getRightRoom() != null) {
                    roomPLayerIsIn = roomPLayerIsIn.getRightRoom();
                    System.out.println("> You moved to the room to the east");
                    roomPLayerIsIn.enterRoom();
                } else {
                    System.out.println("> There are no rooms east");
                }
            }

            case "west" -> {
                if (roomPLayerIsIn.getLeftRoom() != null) {
                    roomPLayerIsIn = roomPLayerIsIn.getLeftRoom();
                    System.out.println("> You moved to the room to the west");
                    roomPLayerIsIn.enterRoom();
                } else {
                    System.out.println("> There are no rooms west");

                }
            }
        }
    }
    //----------------Items------------------------------------------//

    public ArrayList<Item> getInventory() {
        return inventory;


    }


    public void showInventory() {
        ArrayList<String> itemNames = (ArrayList<String>) inventory.stream()
                .map(Item::getName)
                .collect(Collectors.toList());
        String result = String.join(", ", itemNames);
        System.out.println("> Inventory: \n" + result);

    }


    public String takeItem(String name) {
        Item remove = null;
        String result = "";
        boolean itemFound = false;

        for (Item i : roomPLayerIsIn.getItemsInRoom()) {
            if (name.equalsIgnoreCase(i.getFindName())) {
                inventory.add(i);
                remove = i;
                itemFound = true;
                result += "> You have taken the " + i.getName();

            }
        }
        roomPLayerIsIn.getItemsInRoom().remove(remove);
        if (!itemFound) {
            result += "> There is not a '" + name + "' in this room";
        }
        return result;
    }


    public String dropItem(String name) {
        Item remove = null;
        String result = "";
        boolean itemFound = false;

        for (Item i : inventory ) {
            if (name.equalsIgnoreCase(i.getFindName())) {
                remove = i;
                roomPLayerIsIn.getItemsInRoom().add(i);
                itemFound = true;
                result += "> You dropped the " + name;
            }
        }
        inventory.remove(remove);
        if (!itemFound) {
            result += "> You dont have a '" + name + "' in your inventory";
        }
        return result;
    }

    //---------------------------Food------------------------------------------

    public String eatFood(String name) {
        Item remove = null;
        String result = "";
        boolean itemFound = false;

        for (Item i: inventory){
            if (name.equalsIgnoreCase(i.getFindName())) {
                itemFound = true;
                if (i instanceof Food) {
                    Food foodItem = (Food) i;
                    health += foodItem.getHealthGain();
                    remove = foodItem;
                    result += (((Food) i).getPoison() ? "This is poisonous!! You took " + foodItem.getHealthGain()
                            + " points of damage" : "This tasted good! You gained " + foodItem.getHealthGain() + " point of health");
                } else {
                    result += "> That is not food";
                }
            }
        }
        inventory.remove(remove);
        if (!itemFound) {
            result += "> There is not a '" + name + "' int your inventory";
        }

        return result;


    }
    // ------------------------------Weapons---------------------------------------------------------------------//

    public String equipWeapon(String name) {
        Item weaponToRemove = null;
        String result = "";
        boolean itemFound = false;

        for (Item i : inventory) {
            if (name.equalsIgnoreCase(i.getFindName())) {
                itemFound = true;
                if (i instanceof Weapon) {
                    Weapon weapon = (Weapon) i;
                    weaponToRemove = weapon;
                    equipWeaponCheck();
                    equipedWeapon = weapon;
                    result += "You equiped " + name;
                    break;

                } else {
                    result += "> That is not a weapon";
                    break;
                }
            }
        }
        inventory.remove(weaponToRemove);
        if (!itemFound) {
            result += "> There is not a '" + name + "' in your inventory";
        }

        return result;

    }

    public void equipWeaponCheck() {
        if (equipedWeapon != null)
            inventory.add(equipedWeapon);

    }

    public String attack() {
        if (equipedWeapon != null) {
            return "You attacked!!!!!!";
        } else {
            return "You can attack without a weapon equiped!!";
        }
    }
}





