import java.io.File;

public class FileActions {

    public static void createFiles(String name) {
        String path = main.workingDirectory + name;    // File path
        System.out.println("Creating file " + path);
        File f = new File(path);

        try {
            if (f.createNewFile()) {
                System.out.println(TextFormatting.TEXT_CYAN + "Success! File created: " + f.getName() + TextFormatting.TEXT_RESET); // Confirm file creation.
            } else if (name == "") {
                System.out.println(TextFormatting.TEXT_RED + "Error: Please enter filename including extension." + TextFormatting.TEXT_RESET);
            } else if (f.exists()) {
                System.out.println(TextFormatting.TEXT_RED + "Error: File already exists." + TextFormatting.TEXT_RESET);
            }
        } catch (Exception e) {
            System.out.println(TextFormatting.TEXT_RED + "Error: An error occurred." + TextFormatting.TEXT_RESET);
            System.out.println(e);
        }
    }
    public static void DeleteFiles(String filename) {
        if (!filename.contains(":")) {  // logic
            filename = main.workingDirectory + filename;    // add current working directory in front.
        }

        File f = new File(filename);
        if (f.delete()) {
            System.out.println(TextFormatting.TEXT_CYAN + "Successfully deleted file " + f.getName() + TextFormatting.TEXT_RESET);
        } else {
            System.out.println(TextFormatting.TEXT_RED + "Error: Failed to delete file " + TextFormatting.TEXT_RESET + f.getName());
        }
    }

}
