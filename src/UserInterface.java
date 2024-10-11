import java.util.Scanner;

public class UserInterface {
    private AdventureController controller;

    public UserInterface() {
        this.controller = new AdventureController();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        String userInput = " ";

        System.out.println("Welcome to the adventure game! You are in an old castle looking for an evil wizard known as 'The Necromancer' you need to kill him! write help to the the list of commands.");
        System.out.println(controller.generalDescription());


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
                        System.out.println("You need to specify what item do you want to take");
                    }
                }
                case "drop", "drop " -> {
                    if (word.length > 1) {
                        System.out.println(controller.dropItem(word[1]));
                    } else {
                        System.out.println("You need to specify what item do you want to drop");
                    }
                }
                case "eat", "eat " -> {
                    if (word.length > 1) {
                        System.out.println(controller.eatFood(word[1]));
                    } else {
                        System.out.println("You need to specify what ite do you want to eat");
                    }
                }
                case "equip", "equip " -> {
                    if (word.length > 1) {
                        System.out.println(controller.equipWeapon(word[1]));
                    } else {
                        System.out.println("You need to specify what weapon do you want to equip");
                    }
                }
                case "health" -> System.out.println("Your health is: " + controller.getHealth());
                case "look" -> {
                    System.out.println(controller.generalDescription());
                }
                case "attack" -> System.out.println(controller.attack());
                case "exit" -> {
                    break outerloop;
                }
                default -> System.out.println("That is not a command");

            }


            if (controller.getFinalBoss().isDead()) {
                System.out.println("You got to the end of the maze, You won!!!!! Thanks for playing");
                break;
            }
            if (controller.getHealth() <= 0) {
                System.out.println("You passed away because of all the damage you received. Better luck next time!!");
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
        System.out.println("'look' to get the description of your current room");
        System.out.println("'help' get the command list");
        System.out.println("'inventory' go see your items");
        System.out.println("'take + item' to take an item from the room");
        System.out.println("'drop + item' to drop an item from your inventory in the room");
        System.out.println("'eat + food' to eat something");
        System.out.println("'equip + weapon' to equip a weapon");
        System.out.println("'exit' to exit the game");
    }


}



