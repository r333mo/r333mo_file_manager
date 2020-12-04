import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TextEditor {
    public static void Editor(String filename) throws IOException {
        //boolean exit = false;
        //boolean isFullPath = false;
        long size;
        String displaySize;

        if (!filename.contains(":")) {  // logic
            filename = main.workingDirectory + filename;    // add current working directory in front.
        }

        File f = new File(filename);
        size = f.length();
        if (size > 99) {
            displaySize = (size / 1024) + " kb";
        } else {
            displaySize = size + " bytes";
        }


        if (!f.exists()) {
            System.out.println(TextFormatting.TEXT_RED + "Error: Filepath cannot be found." + TextFormatting.TEXT_RESET);
            return;
        } else if (!f.canRead()) {
            System.out.println(TextFormatting.TEXT_RED + "Error: File cannot be read." + TextFormatting.TEXT_RESET);
            return;
        }

        System.out.println(TextFormatting.TEXT_BOLD_BG_WHITE + TextFormatting.TEXT_BOLD_PURPLE + "-----------  kyle's simple text editor ----------- ");
        System.out.println(TextFormatting.TEXT_BOLD_BG_WHITE + TextFormatting.TEXT_BOLD_PURPLE + f.getName() + "\t" + displaySize);

        //System.out.format("The size of the file: %d bytes", fileSize);
        try {
            Scanner sc = new Scanner(f);
            int lineNumber = 0;
            while (sc.hasNextLine()) {  // PRINTING FILE
                String data = sc.nextLine();
                lineNumber++;
                System.out.println(StringUtils.rightPad(TextFormatting.TEXT_BOLD_BG_WHITE + TextFormatting.TEXT_BOLD_PURPLE + "Line " + lineNumber + "  " + TextFormatting.TEXT_RESET, 25) + TextFormatting.TEXT_RESET + data);
            }
            System.out.println(TextFormatting.TEXT_BOLD_BG_WHITE + TextFormatting.TEXT_BOLD_PURPLE + "-----------  -----------  -----------" + TextFormatting.TEXT_RESET);
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.print(TextFormatting.TEXT_BOLD_BG_WHITE + TextFormatting.TEXT_BOLD_PURPLE + "\n" + f.getName() + " >>> ");
        Scanner sc = new Scanner(System.in);    // Scanner object.
        String userInput = sc.nextLine();
        String[] input = userInput.split("\\s+"); // Split up command for parameters
        int parameter1 = 0;
        String parameter2 = "";

        String command = input[0];  // Get command from argument
        if (input.length == 2) {    // If we have additional parameters, put them into some strings
            parameter1 = Integer.parseInt(input[1]);
        } else if (input.length == 3) {
            parameter1 = Integer.parseInt(input[1]);
            parameter2 = input[2];
        }

        Path path = Paths.get(filename);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        switch (command) {
            case "write":
                int line = parameter1;
                String data = parameter2;

                lines.set(line, data);
                //lines.add(line, data);
                Files.write(path, lines, StandardCharsets.UTF_8);

                break;

            case "exit":
                System.out.println("Exiting txtedit.." + TextFormatting.TEXT_RESET);

                return;
        }

    }
}
