// This is probably terrible and inefficient, but it works for now.
// Using ANSI colour codes.

public class TextFormatting {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_DEFAULT = "";

    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    public static final String TEXT_BOLD_BLACK = "\u001B[30;1m";
    public static final String TEXT_BOLD_RED = "\u001B[31;1m";
    public static final String TEXT_BOLD_GREEN = "\u001B[32;1m";
    public static final String TEXT_BOLD_YELLOW = "\u001B[33;1m";
    public static final String TEXT_BOLD_BLUE = "\u001B[34;1m";
    public static final String TEXT_BOLD_PURPLE = "\u001B[35;1m";
    public static final String TEXT_BOLD_CYAN = "\u001B[36;1m";
    public static final String TEXT_BOLD_WHITE = "\u001B[37;1m";

    public static final String[] FOREGROUNDS = {
            TEXT_DEFAULT, TEXT_BLACK, TEXT_RED, TEXT_GREEN, TEXT_YELLOW,
            TEXT_BLUE, TEXT_PURPLE, TEXT_CYAN, TEXT_WHITE,
            TEXT_BOLD_BLACK, TEXT_BOLD_RED, TEXT_BOLD_GREEN, TEXT_BOLD_YELLOW,
            TEXT_BOLD_BLUE, TEXT_BOLD_PURPLE, TEXT_BOLD_CYAN, TEXT_BOLD_WHITE
    };

    public static final String TEXT_BG_DEFAULT = "";

    public static final String TEXT_BG_BLACK  = "\u001B[40m";
    public static final String TEXT_BG_RED    = "\u001B[41m";
    public static final String TEXT_BG_GREEN  = "\u001B[42m";
    public static final String TEXT_BG_YELLOW = "\u001B[43m";
    public static final String TEXT_BG_BLUE   = "\u001B[44m";
    public static final String TEXT_BG_PURPLE = "\u001B[45m";
    public static final String TEXT_BG_CYAN   = "\u001B[46m";
    public static final String TEXT_BG_WHITE  = "\u001B[47m";

    public static final String TEXT_BOLD_BG_BLACK  = "\u001B[100m";
    public static final String TEXT_BOLD_BG_RED    = "\u001B[101m";
    public static final String TEXT_BOLD_BG_GREEN  = "\u001B[102m";
    public static final String TEXT_BOLD_BG_YELLOW = "\u001B[103m";
    public static final String TEXT_BOLD_BG_BLUE   = "\u001B[104m";
    public static final String TEXT_BOLD_BG_PURPLE = "\u001B[105m";
    public static final String TEXT_BOLD_BG_CYAN   = "\u001B[106m";
    public static final String TEXT_BOLD_BG_WHITE  = "\u001B[107m";

    public static final String[] BACKGROUNDS = {
            TEXT_BG_DEFAULT, TEXT_BG_BLACK, TEXT_BG_RED, TEXT_BG_GREEN, TEXT_BG_YELLOW,
            TEXT_BG_BLUE, TEXT_BG_PURPLE, TEXT_BG_CYAN, TEXT_BG_WHITE,
            TEXT_BOLD_BG_BLACK, TEXT_BOLD_BG_RED, TEXT_BOLD_BG_GREEN, TEXT_BOLD_BG_YELLOW,
            TEXT_BOLD_BG_BLUE, TEXT_BOLD_BG_PURPLE, TEXT_BOLD_BG_CYAN, TEXT_BOLD_BG_WHITE };

    public static void TestColours() {
        /*
        System.out.println("8 colour test:");
        System.out.println(TEXT_BLACK + "BLACK!" + TEXT_RESET);
        System.out.println(TEXT_RED + "RED!" + TEXT_RESET);
        System.out.println(TEXT_GREEN + "GREEN!" + TEXT_RESET);
        System.out.println(TEXT_YELLOW + "YELLOW!" + TEXT_RESET);
        System.out.println(TEXT_BLUE + "BLUE!" + TEXT_RESET);
        System.out.println(TEXT_PURPLE + "PURPLE!" + TEXT_RESET);
        System.out.println(TEXT_CYAN + "CYAN!" + TEXT_RESET);
        System.out.println(TEXT_WHITE + "WHITE!" + TEXT_RESET);

        System.out.println("\n16 colour test:");
        System.out.println(TEXT_BOLD_BLACK + "BOLD BLACK!" + TEXT_RESET);
        System.out.println(TEXT_BOLD_RED + "BOLD RED!" + TEXT_RESET);
        System.out.println(TEXT_BOLD_GREEN + "BOLD GREEN!" + TEXT_RESET);
        System.out.println(TEXT_BOLD_YELLOW + "BOLD YELLOW!" + TEXT_RESET);
        System.out.println(TEXT_BOLD_BLUE + "BOLD BLUE!" + TEXT_RESET);
        System.out.println(TEXT_BOLD_PURPLE + "BOLD PURPLE!" + TEXT_RESET);
        System.out.println(TEXT_BOLD_CYAN + "BOLD CYAN!" + TEXT_RESET);
        System.out.println(TEXT_BOLD_WHITE + "BOLD WHITE!" + TEXT_RESET);
         */

        System.out.println("\n256 colour test:");
        for (String fg : FOREGROUNDS) {
            for (String bg : BACKGROUNDS)
                System.out.print(fg + bg + "  TEST  ");
            System.out.println(TEXT_RESET);
        }
    }
}
