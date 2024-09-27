public class Room {
    public String roomName;
    public String description;
    public Room leftRoom, rightRoom, upRoom, downRoom;
    public boolean been;
    public boolean triedNorth;
    public boolean triedSouth;
    public boolean triedWest;
    public boolean triedEast;

    public Room(String roomName, String description){
        this.roomName = roomName;
        this.description = description;
        this.been = false;
        this.triedNorth = false;
        this.triedSouth = false;
        this.triedEast = false;
        this.triedWest = false;

    }
    // link rooms together
    public void setLeftRoom(Room leftRoom){
        this.leftRoom = leftRoom;
        leftRoom.rightRoom = this;

    }
    public void setRightRoom(Room rightRoom){
        this.rightRoom = rightRoom;
        rightRoom.leftRoom = this;
    }
    public void setUpRoom(Room upRoom){
        this.upRoom = upRoom;
        upRoom.downRoom = this;
    }
    public void setDownRoom(Room downRoom){
        this.downRoom = downRoom;
        downRoom.upRoom = this;

    }
    // get statements for every room and room number
    public Room getLeftRoom(){
        return leftRoom;
    }
    public Room getRightRoom(){
        return rightRoom;
    }
    public Room getUpRoom(){
        return upRoom;
    }
    public Room getDownRoom(){
        return downRoom;
    }
    public String getRoomName(){
        return roomName;
    }

    public String getDescription(){
        return description;
    }

    public void beenToTheRoom(){
        this.been = true;
    }

    public void enterRoom(){
        if ((!this.been)) {
            System.out.println(getDescription());
            beenToTheRoom();
        }
    }

    public void directionsTried(){
        System.out.println("you see dooes too ");
        if (!triedNorth){

        }

    }



}
