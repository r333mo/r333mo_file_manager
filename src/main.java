import java.io.IOException;
import java.util.Scanner;

public class main {
    public static String workingDirectory = "F://crap/file_manager/src/files/"; // Set default working dir

    public static void main(String[] args) {
        System.out.println("----------- Welcome to r333mo's file manager! -----------");
        System.out.println("Type \"help\" to get started!");

        menu();
    }
    public static void menu() {
        boolean exit = false;
        while (!exit) {

            Scanner sc = new Scanner(System.in);    // Scanner object.
            System.out.print("\n" + workingDirectory + " >>> ");
            String inputOption = sc.nextLine();
            String[] input = inputOption.split("\\s+"); // Split up command for parameters
            String parameter1 = "";
            String parameter2 = "";

            String command = input[0];  // Get command from argument
            if (input.length == 2) {    // If we have additional parameters, put them into some strings
                parameter1 = input[1];
            } else if (input.length == 3) {
                parameter1 = input[1];
                parameter2 = input[2];
            }

            switch (command) {
                case "help":
                    help.help(parameter1);

                    break;

                case "newfile":
                    FileActions.createFiles(parameter1);

                    break;

                case "ls":
                    DirectoryActions.listFiles(parameter1);

                    break;

                case "dir":
                    DirectoryActions.getWorkingDirectory();

                    break;

                case "cd":
                    DirectoryActions.changeDir(parameter1);

                    break;

                case "mkdir":
                    DirectoryActions.newDir(parameter1);

                    break;

                case "exit":
                    System.out.println("Exiting program...");

                    exit = true;
                    break;

                case "":

                    break;

                case "coltest":
                    TextFormatting.TestColours();

                    break;

                case "txtedit":
                    try {
                        TextEditor.Editor(parameter1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;

                case "rm":
                    FileActions.DeleteFiles(parameter1);

                    break;

                default:
                    System.out.println(TextFormatting.TEXT_RED + "Bad command. Try \"help\"." + TextFormatting.TEXT_RESET);

                    break;
            }
        }
    }

}
