package iqtester;

/*
 * author : Soumadeep Choudhury
 * company : Ahens | An Initiative to Initial
 * name : IQ-Tester
 * version : v1.0.0
 */
public class App {

    static char mainCharacterArr[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' }; // The one character that need to be found out.
    static char otherCharacterArr[] = { 'e',
            'd', 'o', 'b', 'a', 't', 'y', 'k', 'j', 'i', 'h', 'i', 'n', 'm', 'c', 'q', 'p', 's', 'r', 'f', 'w', 'w',
            'v', 'z', 'g', 'x'
    }; // The remaining characters for filling spaces.

    public static void printText(String text) {
        /*
         * Prints the text in slow motion.
         * It writes the characters one by one.
         */
        for (int letterIndex = 0; letterIndex < text.length(); letterIndex++) {
            try {
                Thread.sleep(text.charAt(letterIndex) == ' ' ? 200 : 100);
            } catch (Exception e) {
            }
            System.out.print(text.charAt(letterIndex));
        }
        System.out.println();
    }

    public static void loading(String text) {
        /*
         * Displays the loading text.
         * Repeates the "..." 3 times.
         */
        String whiteSpaces = "";
        for (int i = 0; i < text.length(); i++) {
            whiteSpaces += " ";
        }
        try {
            for (int i = 0; i < 3; i++) {
                System.out.print("\rLoading" + (i > 0 ? whiteSpaces : "") + "\rLoading");
                Thread.sleep(500);
                for (int j = 0; j < text.length(); j++) {
                    System.out.print(text.charAt(j));
                    Thread.sleep(500);
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
        System.out.print("\r"); // Deletes/Removes the "Loading" text.
    }

    public static void main(String[] args) {
        /*
         * Main start of application.
         * Displays the info to the user about "What to do?".
         * Prints the grid with 25x50 ratio and inserts the new elements in between, as
         * if hiding.
         */
        int index = (int) (Math.random() * 100); // Gets the index for the element
        int placement_x = (int) (Math.random() * 100); // Gets the position on x axis for element
        int placement_y = (int) (Math.random() * 100); // Gets the position on y axis for element
        while (index > 25 || index < 0) {
            index = (int) (Math.random() * 100);
        }
        while ((placement_x > 48 || placement_y > 23) || placement_x < 3 || placement_y < 3) {
            placement_x = (int) (Math.random() * 100);
            placement_y = (int) (Math.random() * 100);

        }
        printText("Find the letter '" + mainCharacterArr[index] + "' in the following brain teaser...");
        loading("...");
        for (int i = 0; i < 25; i++) { // Counts the rows.
            for (int j = 0; j < 50; j++) { // Counts the columns.
                if (i == placement_y && j == placement_x) {
                    System.out.print(mainCharacterArr[index]);
                    continue;
                }
                System.out.print(otherCharacterArr[index]);
            }
            System.out.println();
        }
    }
}
