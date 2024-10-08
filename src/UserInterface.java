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
            String[] word = userInput.split(" ");

            switch (word[0]) {
                case "north" -> controller.movePlayer("north");
                case "south" -> controller.movePlayer("south");
                case "east" -> controller.movePlayer("east");
                case "west" -> controller.movePlayer("west");
                case "help" -> showCommands();
                case "inventory" -> controller.showInventory();
                case "take", "take " -> {
                    if (word.length > 1) {
                        System.out.println(controller.takeItem(word[1]));

                    } else {
                        write("You need to specify what item do you want to take");
                    }
                }
                case "drop", "drop " -> {
                    if (word.length > 1) {
                        System.out.println(controller.dropItem(word[1]));
                    } else {
                        write("You need to specify what item do you want to drop");
                    }
                }
                case "eat", "eat " -> {
                    if (word.length > 1) {
                        System.out.println(controller.eatFood(word[1]));
                    } else {
                        write("You need to specify what ite do you want to eat");
                    }
                }
                case "equip", "equip " -> {
                    if (word.length > 1) {
                        System.out.println(controller.equipWeapon(word[1]));
                    } else {
                        write("You need to specify what weapon do you want to equip");
                    }
                }
                case "health" -> write("Your health is: " + controller.getHealth());
                case "look" -> {
                    write(controller.getRoomDescription());
                    controller.showItems();
                }
                case "attack" -> write(controller.attack());
                case "exit" -> {
                    break outerloop;
                }
                default -> {

                    if (userInput.contains("eat ")) {
                        if (!controller.getInventory().isEmpty()) {
                            write(controller.eatFood(userInput));
                        } else {
                            write("There are one items in you inventory ");
                        }

                    } else {
                        write("That is not a command");
                    }
                }
            }

            if (controller.getRoomplayerIsIn() == controller.getfinnishRoom()) {
                write("You got to the end of the maze, You won!!!!! Thanks for playing");
                break;
            }

        }


    }

    public void showCommands() {
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

    public void write(String string) {
        System.out.println("> " + string);
    }
}



