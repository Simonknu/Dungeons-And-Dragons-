public class Room {
    public int roomNum;
    public Room leftRoom;
    public Room rightRoom;
    public Room upRoom;
    public Room downRoom;

    public Room(int roomNum){
        this.roomNum = roomNum;

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
    public int getRoomNum(){
        return roomNum;
    }



}
