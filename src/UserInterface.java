import java.util.Scanner;

public class UserInterface {
    private AdventureController controller;

    public UserInterface() {
        this.controller = new AdventureController();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        String userInput = " ";

        write("Welcome to the adventure game! You are in a maze made out of 9 room and you want to get to the middle one. \nWrite help to get the different commands.");
        controller.getRoomDescription();


        outerloop:
        while (true) {

            userInput = scanner.nextLine();

            switch (userInput) {
                case "north" -> controller.movePlayer("north");
                case "south" -> controller.movePlayer("south");
                case "east" -> controller.movePlayer("east");
                case "west" -> controller.movePlayer("west");
                case "help" -> showCommands();
                case "inventory" -> controller.showInventory();
                case "take" -> {
                    if (!controller.getItemsInRoom().isEmpty()) {
                        write("Which item would you like to take?");
                        userInput = scanner.nextLine();
                        controller.takeItem(userInput);
                    } else {
                        write("There are no item in this room");
                    }
                }
                case "drop" -> {
                    if (!controller.getInventory().isEmpty()) {
                        write("Which item would you like to drop?");
                        userInput = scanner.nextLine();
                        controller.dropItem(userInput);
                    } else {
                        write("Your inventory is empty");
                    }
                }
                case "info" -> {
                    write(controller.getRoomDescription());
                    controller.showItems();
                }
                case "exit" -> {
                    break outerloop;
                }
                default -> write(" That is not a command");
            }


        }


    }
    public void showCommands(){
        System.out.println("List of commands:\nMove commands:");
        System.out.println("north");
        System.out.println("south");
        System.out.println("east");
        System.out.println("west");
        System.out.println("Other commands:");
        System.out.println("'info' to get the description of your current room");
        System.out.println("'help' get the command list");
        System.out.println("'inventory' go see your items");
        System.out.println("'take' to take an item from the room");
        System.out.println("'drop' to drop an item from your inventory in the room");
        System.out.println("'exit' to exit the game");
    }

    public void write(String string){
        System.out.println("> " + string);
    }
}



