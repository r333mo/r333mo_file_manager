import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;

public class DirectoryActions {

    public static void changeDir(String dirToChangeTo) {
        if (!dirToChangeTo.contains(":")) {  // logic
            dirToChangeTo = main.workingDirectory + dirToChangeTo;    // add current working directory in front.
        } else if (dirToChangeTo == "..") { // for going back 1 dir
            //dirToChangeTo = main.workingDirectory.    // not figured it out yet.
        }

        File f = new File(dirToChangeTo);

        if (dirToChangeTo == "") {  // if they dont type anything go back to default
            main.workingDirectory = "C://";
        } else if (f.exists()) {
            main.workingDirectory = dirToChangeTo + "/";
            // System.out.println("Success! New working directory set to: " + main.workingDirectory);
        } else if (!f.exists()) {
            System.out.println(TextFormatting.TEXT_RED + "Error: Cannot find filepath." + TextFormatting.TEXT_RESET);
        } else {
            System.out.println(TextFormatting.TEXT_RED + "Error: An unexpected error occurred." + TextFormatting.TEXT_RESET);
        }
    }
    public static void newDir(String path) {
        if (!path.contains(":")) {  // logic
            path = main.workingDirectory + path;    // add current working directory in front.
        }
        File f = new File(path);    // set filepath up

        try {
            f.mkdirs(); // try make the dir, did it work?
        } catch (Exception e) {
            System.out.println(e);  // if not print error
        }

        if (f.exists()) {
            try {
                System.out.println(TextFormatting.TEXT_CYAN + "Success! Created directory: " + f.getCanonicalPath() + TextFormatting.TEXT_RESET);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (!f.exists()) {
            System.out.println(TextFormatting.TEXT_RED + "Error: Failed to create directory." + TextFormatting.TEXT_RESET);
        } else {
            System.out.println(TextFormatting.TEXT_RED + "Error: An unexpected error occurred." + TextFormatting.TEXT_RESET);
        }
    }
    public static void listFiles(String arguments) {
        //System.out.print("\n");
        File f = new File(main.workingDirectory); // current directory
        boolean showHidden= false;

        if (arguments.contains("a")) {  // a for ALL
            showHidden = true;
        }

        File[] files = f.listFiles();   // Array of files
        int i = 0;
        long size;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");    // format that we will use for last modified (since its in unix timestamp by default.)

        for (File file : files) {   // loop through this array
            i++;    // increment
            size = f.length();
            //System.out.print(" " + i + " ");

            if (file.isDirectory()) {
                System.out.print(TextFormatting.TEXT_BLUE + "");
            } else if (file.isHidden() && !showHidden) {    // dont show hidden if not requested
                i--;
                continue;
            } else if (file.getName().endsWith(".jpg")  // image and video file formats
                    || file.getName().endsWith(".jpeg")
                    || file.getName().endsWith(".png")
                    || file.getName().endsWith(".tif")
                    || file.getName().endsWith(".gif")
                    || file.getName().endsWith(".mp4")
                    || file.getName().endsWith(".webm")) {
                System.out.print(TextFormatting.TEXT_PURPLE + "");    // make them purple
            } else if (file.getName().endsWith(".mp3")  // audio formats
                    || file.getName().endsWith(".ogg")
                    || file.getName().endsWith(".wav")) {
                System.out.print(TextFormatting.TEXT_CYAN + "");  // make then cyan
            } else if (file.getName().endsWith(".zip")  // archive formats
                    || file.getName().endsWith(".7z")
                    || file.getName().endsWith(".rar")
                    || file.getName().endsWith(".bz2")) {
                System.out.print(TextFormatting.TEXT_RED + "");   // make red
            } else if (file.getName().endsWith(".exe")  // executables
                    || file.getName().endsWith(".bat")) {
                System.out.print(TextFormatting.TEXT_GREEN + ""); // green
            } else {
                System.out.print("" + TextFormatting.TEXT_RESET); // reset test at the end
            }

            if (arguments.contains("l")) {  // l for LIST
                try {
                    System.out.println(StringUtils.rightPad((size / 1024 + "kb "), 5) + StringUtils.center((simpleDateFormat.format(f.lastModified())), 25) + file.getName() + TextFormatting.TEXT_RESET);    // LAST MODIFIED + NAME + NEWLINE
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                // String str = String.valueOf(i);
                if (i % 2 == 0) {   // if remainder is 0 (ie even number)
                    try {
                        System.out.print(file.getName() + TextFormatting.TEXT_RESET );    // add newline
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {    // if odd number, just print normally
                    try {
                        System.out.printf("\n%-15s", StringUtils.rightPad(file.getName(), 50 + f.getName().length()) + TextFormatting.TEXT_RESET);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        } //System.out.print("\n"); // This fixed one bug with newlines, but created another bug!! The joy of coding!
    }
    public static void getWorkingDirectory() {  // bit of an odd one here, but it works
        System.out.println(TextFormatting.TEXT_CYAN + "Current working directory: " + main.workingDirectory + TextFormatting.TEXT_RESET);
    }
}
