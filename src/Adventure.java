public class Adventure {

    public void playgame() {
        UserInterface ui = new UserInterface();
        Map map = new Map();
        Player player = new Player(map.startingRoom);


        ui.comMessage("Welcme to the adventure game! You are in a maze made out of 9 room and you want to get to the middle one. \nWrite help to get the different commands.");
        ui.comMessage(player.roomPLayerIsIn.description);
        outerloop:
        while (true) {

            String command = ui.getUserInput();

            switch (command) {
                case "north" -> player.movePlayer("north");
                case "south" -> player.movePlayer("south");
                case "east" -> player.movePlayer("east");
                case "west" -> player.movePlayer("west");
                case "help" -> ui.showCommands();
                case "info" -> System.out.println(player.roomPLayerIsIn.getDescription());
                case "exit" -> {
                    break outerloop;
                }
                default -> ui.comMessage("That is not a command");
            }


        }


    }

}
