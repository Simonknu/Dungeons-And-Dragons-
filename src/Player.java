public class Player {
    public Room roomPLayerIsIn;


    public Player(Room roomPLayerIsIn) {
        this.roomPLayerIsIn = roomPLayerIsIn;
    }


    public Room getRoomPLayerIsIn() {
        return roomPLayerIsIn;
    }

    public void movePlayer(String direction) {
        switch (direction) {
            case "north" -> {
                if (roomPLayerIsIn.upRoom != null) {
                    roomPLayerIsIn = roomPLayerIsIn.upRoom;
                    System.out.println("You moved to the room above");
                    if ((!roomPLayerIsIn.been)) {
                        System.out.println(roomPLayerIsIn.getDescription());
                        roomPLayerIsIn.beenToTheRoom();
                    }

                } else {
                    System.out.println("There are no rooms above");
                }
            }

            case "south" -> {
                if (roomPLayerIsIn.downRoom != null) {
                    roomPLayerIsIn = roomPLayerIsIn.downRoom;
                    System.out.println("you moved to the rooms bellow");
                    if ((!roomPLayerIsIn.been)) {
                        System.out.println(roomPLayerIsIn.getDescription());
                        roomPLayerIsIn.beenToTheRoom();
                    }
                } else {
                    System.out.println("There are no rooms bellow");
                }
            }

            case "east" -> {
                if (roomPLayerIsIn.rightRoom != null) {
                    roomPLayerIsIn = roomPLayerIsIn.rightRoom;
                    System.out.println("You moved to the room to the east");
                    if ((!roomPLayerIsIn.been)) {
                        System.out.println(roomPLayerIsIn.getDescription());
                        roomPLayerIsIn.beenToTheRoom();
                    }
                } else {
                    System.out.println("There are no rooms to the east");
                }
            }

            case "west" -> {
                if (roomPLayerIsIn.leftRoom != null) {
                    roomPLayerIsIn = roomPLayerIsIn.leftRoom;
                    System.out.println("You moved to the room to the west");
                    if ((!roomPLayerIsIn.been)) {
                        System.out.println(roomPLayerIsIn.getDescription());
                        roomPLayerIsIn.beenToTheRoom();
                    }
                } else {
                    System.out.println("There are no rooms to the west");

                }
            }
        }
    }

}



