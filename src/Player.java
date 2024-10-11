import java.util.ArrayList;
import java.util.stream.Collectors;

public class Player {
    private Room roomPLayerIsIn;
    private ArrayList<Item> inventory;
    private int health;
    private Weapon equipedWeapon;
    private boolean hasKey;


    public Player(Room roomPLayerIsIn) {
        this.roomPLayerIsIn = roomPLayerIsIn;
        this.inventory = new ArrayList<Item>();
        this.health = 50;
        this.hasKey = false;

    }


    public Room getRoomPLayerIsIn() {
        return roomPLayerIsIn;
    }

    public int getHealth() {
        return health;
    }

    public boolean getHasKey() {
        return hasKey;
    }

    // shows if player has the key for last room
    public void switchKey() {
        hasKey = true;
    }

    //----------------------------To move the player --------------------------------------------------------
    public void movePlayer(String direction) {
        switch (direction) {
            case "north" -> {
                if (roomPLayerIsIn.getEnemy() == null || (roomPLayerIsIn.getEnemy() != null && roomPLayerIsIn.getEnemy().isDead()) || (roomPLayerIsIn.getEnemy() != null && !roomPLayerIsIn.getEnemy().isDead() && roomPLayerIsIn.getRoomBefore() != null && roomPLayerIsIn.getRoomBefore() == roomPLayerIsIn.getUpRoom())) {
                    if (getRoomPLayerIsIn().getUpRoom() != null) {
                        roomPLayerIsIn = roomPLayerIsIn.getUpRoom();
                        roomPLayerIsIn.setRoomBefore(roomPLayerIsIn.getDownRoom());
                        System.out.println("> You moved to the room above");
                        roomPLayerIsIn.enterRoom();
                    } else {
                        System.out.println("> There are no rooms north");
                    }
                } else {
                    System.out.println("You need to defeat the enemy before you can move forward");

                }
            }

            case "south" -> {
                if (roomPLayerIsIn.getEnemy() == null || (roomPLayerIsIn.getEnemy() != null && roomPLayerIsIn.getEnemy().isDead()) || (roomPLayerIsIn.getEnemy() != null && !roomPLayerIsIn.getEnemy().isDead() && roomPLayerIsIn.getRoomBefore() != null && roomPLayerIsIn.getRoomBefore() == roomPLayerIsIn.getDownRoom())) {
                    if (roomPLayerIsIn.getDownRoom() != null) {
                        roomPLayerIsIn = roomPLayerIsIn.getDownRoom();
                        roomPLayerIsIn.setRoomBefore(roomPLayerIsIn.getUpRoom());
                        System.out.println("> you moved to the room to the south");
                        roomPLayerIsIn.enterRoom();
                    } else {
                        System.out.println("> There are no rooms south");
                    }
                } else {
                    System.out.println("You need to defeat the enemy before you can move forward");

                }
            }

            case "east" -> {

                if (roomPLayerIsIn.getEnemy() == null || (roomPLayerIsIn.getEnemy() != null && roomPLayerIsIn.getEnemy().isDead()) || (roomPLayerIsIn.getEnemy() != null && !roomPLayerIsIn.getEnemy().isDead() && roomPLayerIsIn.getRoomBefore() != null && roomPLayerIsIn.getRoomBefore() == roomPLayerIsIn.getRightRoom())) {

                    if (roomPLayerIsIn.getRightRoom() != null) {
                        roomPLayerIsIn = roomPLayerIsIn.getRightRoom();
                        roomPLayerIsIn.setRoomBefore(roomPLayerIsIn.getLeftRoom());
                        System.out.println("> You moved to the room to the east");
                        roomPLayerIsIn.enterRoom();
                    } else {
                        System.out.println("> There are no rooms east");
                    }
                } else {
                    System.out.println("You need to defeat the enemy before you can move forward");


                }
            }

            case "west" -> {
                if (roomPLayerIsIn.getEnemy() == null || (roomPLayerIsIn.getEnemy() != null && roomPLayerIsIn.getEnemy().isDead()) || (roomPLayerIsIn.getEnemy() != null && !roomPLayerIsIn.getEnemy().isDead() && roomPLayerIsIn.getRoomBefore() != null && roomPLayerIsIn.getRoomBefore() == roomPLayerIsIn.getLeftRoom())) {

                    if (roomPLayerIsIn.getLeftRoom() != null) {
                        if (roomPLayerIsIn.getLocked() && hasKey) {
                            roomPLayerIsIn = roomPLayerIsIn.getLeftRoom();
                            System.out.println("> You entered the final room of the maze!! ");
                            roomPLayerIsIn.enterRoom();
                        } else if (roomPLayerIsIn.getLeftRoom().getLocked() && !hasKey) {
                            System.out.println("This room is locked. you need to find a key before entering it");
                        } else if (!roomPLayerIsIn.getLocked()) {

                            roomPLayerIsIn = roomPLayerIsIn.getLeftRoom();
                            roomPLayerIsIn.setRoomBefore(roomPLayerIsIn.getRightRoom());
                            System.out.println("> You moved to the room to the west");
                            roomPLayerIsIn.enterRoom();
                        }
                    } else {
                        System.out.println("> There are no rooms west");

                    }
                } else {
                    System.out.println("You need to defeat the enemy before you can move forward");


                }
            }
        }
    }
    //----------------Items------------------------------------------//

    public ArrayList<Item> getInventory() {
        return inventory;


    }


    public String showInventory() {
        ArrayList<String> itemNames = (ArrayList<String>) inventory.stream().map(Item::getName).collect(Collectors.toList());
        String result = String.join(", ", itemNames);
        return "> Your Inventory: \n" + result;

    }


    public String takeItem(String name) {
        Item remove = null;
        String result = "";
        boolean itemFound = false;

        for (Item i : roomPLayerIsIn.getItemsInRoom()) {
            if (name.equalsIgnoreCase(i.getFindName())) {
                if (name.equalsIgnoreCase("key")) {
                    switchKey();
                }
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

        for (Item i : inventory) {
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

        for (Item i : inventory) {
            if (name.equalsIgnoreCase(i.getFindName())) {
                itemFound = true;
                if (i instanceof Food) {
                    Food foodItem = (Food) i;
                    health += foodItem.getHealthGain();
                    remove = foodItem;
                    result += (((Food) i).getPoison() ? "This is poisonous!! You took " + foodItem.getHealthGain() + " points of damage" : "This tasted good! You gained " + foodItem.getHealthGain() + " point of health");
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
        if (equipedWeapon != null) inventory.add(equipedWeapon);

    }

    public String attack() {
        if (equipedWeapon != null) {
            if (roomPLayerIsIn.getEnemy() != null && !roomPLayerIsIn.getEnemy().isDead()) {
                if (equipedWeapon instanceof RangeWeapon) {
                    if (equipedWeapon.checkAmmo() != 0) {
                        roomPLayerIsIn.getEnemy().takeDamage(equipedWeapon.getDamage());
                        ((RangeWeapon) equipedWeapon).setAmmo(equipedWeapon.checkAmmo() - 1);
                        if (roomPLayerIsIn.getEnemy().getHealth() <= 0) {
                            return roomPLayerIsIn.enemyDies();
                        } else {
                            health -= roomPLayerIsIn.getEnemy().getWeapon().getDamage();
                            return "You delt " + equipedWeapon.getDamage() + "To your enemy!! He now has " + roomPLayerIsIn.getEnemy().getHealth() +
                                    " points of health \nHe attacked you back! You lost " + roomPLayerIsIn.getEnemy().getWeapon().getDamage() + " points of health";
                        }
                    } else {
                        return "Your weapon does not have any ammo";
                    }
                } else {
                    roomPLayerIsIn.getEnemy().takeDamage(equipedWeapon.getDamage());
                    if (roomPLayerIsIn.getEnemy().getHealth() <= 0) {
                        return roomPLayerIsIn.enemyDies();
                    } else {
                        health -= roomPLayerIsIn.getEnemy().getWeapon().getDamage();
                        return "You dealt " + equipedWeapon.getDamage() + " point of damage to your enemy!! His health is now at " + roomPLayerIsIn.getEnemy().getHealth() +
                                " points of health \nHe attacked you back! You lost " + roomPLayerIsIn.getEnemy().getWeapon().getDamage() +  " points of health";
                    }
                }
            } else {
                return "You attacked the air!!!";
            }
        } else {
            return "You cant attack without a weapon equiped";
        }

    }
}





