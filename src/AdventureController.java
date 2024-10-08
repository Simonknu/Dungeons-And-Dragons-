import java.util.ArrayList;

public class AdventureController {
private Map map;
private Player player;


public AdventureController(){
    map = new Map();
    player = new Player(map.getStartingRoom());

}
    //-----------Room methods-------------------------------------
    // show that player has entered the room
    public void enterRoom() {
        player.getRoomPLayerIsIn().enterRoom();
    }
    //add an item to the room
    public void addItem(Item item){
        player.getRoomPLayerIsIn().addItem(item);
        }
        // show the items in a room
    public void showItems(){
    player.getRoomPLayerIsIn().showItems();
    }
    // get methods for room

    public String getRoomDescription(){
    return player.getRoomPLayerIsIn().getDescription();
    }
    public ArrayList<Item> getItemsInRoom(){
    return player.getRoomPLayerIsIn().getItemsInRoom();
    }
    public Room getfinnishRoom(){
    return map.getFinnishRoom();
    }
    //--------------------------Player methods-----------------------------
    public void movePlayer(String direction){
    player.movePlayer(direction);
    }
    public void showInventory(){
    player.showInventory();
    }
    public String takeItem(String name){
    return player.takeItem(name);
    }
    public String dropItem(String name){
     return player.dropItem(name);
    }

    public String eatFood(String name){
    return player.eatFood(name);
    }

    public String equipWeapon(String name){
        return player.equipWeapon(name);
    }
    public String attack(){
    return player.attack();
    }
    // get methods for player

    public Room getRoomplayerIsIn(){
    return player.getRoomPLayerIsIn();
    }
    public ArrayList<Item> getInventory(){
     return player.getInventory();
    }
    public int getHealth(){
    return player.getHealth();
    }

}
