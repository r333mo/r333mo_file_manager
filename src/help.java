public class help {

    public static void all() {
        System.out.println("\n----------- Command List -----------");
        System.out.println("Tip: You can type \"help\" followed by a command to get more detail!");

        /* // FORMAT
        System.out.println("Command: \"command\"");
        System.out.println("Description: .\n");
        */

        System.out.println("\nCommand: \"newfile\"");
        System.out.println("Description: Create one or more files using this tool!\n");

        System.out.println("Command: \"dir\"");
        System.out.println("Description: Show current working directory.\n");

        System.out.println("Command: \"ls\"");
        System.out.println("Description: Lists current files in working directory.\n");

        System.out.println("Command: \"cd\"");
        System.out.println("Description: Changes current working directory.\n");

        System.out.println("Command: \"exit\"");
        System.out.println("Description: Exits the program.\n");

        System.out.println("Command: \"mkdir\"");
        System.out.println("Description: Create a new directory.\n");

        System.out.println("Command: \"rm\"");
        System.out.println("Description: Remove a file.\n");

        System.out.println("Command: \"txtedit\"");
        System.out.println("Description: Open the text editor.\n");

        System.out.println("----------- ----------- -----------");

    }
    /* // FORMAT FOR DETAILED VIEW
        System.out.println("\nCommand: \"\"");
        System.out.println("Description: ");
        System.out.println("Usage: \"\"");
        System.out.println("Parameters: ");
     */
    public static void help(String command) {
        switch (command) {
            case "":
                all();

                break;

            case "newfile":
                System.out.println("\nCommand: \"newfile\"");
                System.out.println("Description: Create a new file with the specified name.");
                System.out.println("Usage: \"newfile cat.txt\"");
                System.out.println("Parameters: 1, name of file (inclusing extension).");

                break;

            case "ls":
                System.out.println("\nCommand: \"ls\"");
                System.out.println("Description: List files in current working directory.");
                System.out.println("Usage: \"ls -la\"");
                System.out.println("Parameters: use l for list and/or a for all files.");

                break;

            case "dir":
                System.out.println("\nCommand: \"dir\"");
                System.out.println("Description: Show current working directory.");
                System.out.println("Usage: \"dir\"");
                System.out.println("Parameters: None");

                break;

            case "cd":
                System.out.println("\nCommand: \"cd\"");
                System.out.println("Description: Change to the specified directory.");
                System.out.println("Usage: \"cd C://users/John/Desktop/\"");
                System.out.println("Parameters: 1, directory path.");

                break;

            case "mkdir":
                System.out.println("\nCommand: \"mkdir\"");
                System.out.println("Description: Create a directory (folder) with the specified name.");
                System.out.println("Usage: \"mkdir C://users/Joe/Photos/Dog/\"");
                System.out.println("Parameters: 1, directory path.");

                break;

            case "exit":
                System.out.println("\nCommand: \"exit\"");
                System.out.println("Description: Exit the program.");
                System.out.println("Usage: \"exit\"");
                System.out.println("Parameters: None.");

                break;

            case "rm":
                System.out.println("\nCommand: \"rm\"");
                System.out.println("Description: Remove the specified file.");
                System.out.println("Usage: \"rm file.txt\" OR \"rm C://folder/file.txt\"");
                System.out.println("Parameters: Filepath, if only file name is specified current working directory will be used.");
        }
    }
}
