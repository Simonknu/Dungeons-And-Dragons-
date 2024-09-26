import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);



    public void comMessage(String string){
        System.out.println("> " + string);
    }


    public String getUserInput(){
        System.out.println("|||");
        return scanner.nextLine().trim().toLowerCase();

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
        System.out.println("'exit' to exit the game");
    }

}
