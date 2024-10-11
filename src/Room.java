import java.util.ArrayList;
import java.util.stream.Collectors;

public class Room {
    private String roomName;
    private String description;
    private Room leftRoom, rightRoom, upRoom, downRoom;
    private boolean been;
    private ArrayList<Item> itemsInRoom = new ArrayList<>();
    private Enemy enemy;
    private boolean locked;
    private Room roomBefore;

    public Room(String roomName, String description) {
        this.roomName = roomName;
        this.description = description;
        this.been = false;
        this.locked = false;
        this.roomBefore = this;

    }
    // constructor for locked room
    public Room(String roomName, String description, boolean locked) {
        this.roomName = roomName;
        this.description = description;
        this.been = false;
        this.locked = locked;
    }
    // link rooms together
    public void setLeftRoom(Room leftRoom) {
        this.leftRoom = leftRoom;
        leftRoom.rightRoom = this;

    }

    public void setRightRoom(Room rightRoom) {
        this.rightRoom = rightRoom;
        rightRoom.leftRoom = this;
    }

    public void setUpRoom(Room upRoom) {
        this.upRoom = upRoom;
        upRoom.downRoom = this;
    }

    public void setDownRoom(Room downRoom) {
        this.downRoom = downRoom;
        downRoom.upRoom = this;

    }
    public void setRoomBefore(Room roomBefore){
        this.roomBefore = roomBefore;
    }

    // get statements for every room and room number
    public Room getRoomBefore(){
        return roomBefore;
    }
    public Room getLeftRoom() {
        return leftRoom;
    }

    public Room getRightRoom() {
        return rightRoom;
    }

    public Room getUpRoom() {
        return upRoom;
    }

    public Room getDownRoom() {
        return downRoom;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getDescription() {
        return description;
    }

    public boolean getLocked(){
        return locked;
    }

    // makes a general description with the rooms description, items and enemies
    public String generalDescription(){
        System.out.println(description);
        System.out.println(showItems());
        if (enemy != null && !enemy.isDead()){
            return "There is a " + enemy.getName() + " in the room\n" + enemy.getDescription();

        } else {
            return "There are no enemies in this room";
        }
    }

    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
    }

    public void beenToTheRoom() {
        this.been = true;
    }


    public void enterRoom() {
        if ((!this.been)) {
            System.out.println(getDescription());
            System.out.println(showItems());
            if ( enemy != null && !enemy.isDead()) {
                System.out.println("There is a " + enemy.getName() + " in the room");
                System.out.println(enemy.getDescription());
            } else {
                System.out.println("There are no enemies in this room");
            }
            beenToTheRoom();
        }
    }


// -----------------------------Items------------------------------------------------------

    public void addItem(Item item) {
        itemsInRoom.add(item);
    }

    public String showItems() {
        if (itemsInRoom.size() > 0) {
            ArrayList<String> itemNames = (ArrayList<String>) itemsInRoom.stream()
                    .map(Item::getName)
                    .collect(Collectors.toList());
            String result = String.join(", ", itemNames);
            return "Items in the room: \n" + result;
        } else { return "There are no item in this room";

        }
    }

    //------------------------------Enemy----------------------------------------


    public void addEnemy(Enemy enemy){
        this.enemy = enemy;
    }

    public Enemy getEnemy(){
        return enemy;
    }
    public String enemyDies(){
            enemy.setDead(true);
        addItem(enemy.getWeapon());
            return "You killed the enemy!. He says something before dying: \n" + enemy.getDeadMessage() + "\nA weapon was dropped in the floor";

    }
}
