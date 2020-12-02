import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordPhilosophy {
    static int validPasswordsPart1 = 0, validPasswordsPart2 = 0;

    public static void main(String[] args) {
        //PART 1
        try {
            Scanner input = new Scanner(new File("input.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                int lowerBound = Integer.parseInt(line.substring(0, line.indexOf("-")));
                int upperBound = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(" ")));
                char letter = line.substring(line.indexOf(" ") + 1).charAt(0);
                String meat = line.substring(line.indexOf(letter) + 3);
                //PART 1
                int letterCount = 0;
                for (int i = 0; i < meat.length(); i++) {
                    if (meat.charAt(i) == letter)
                        letterCount++;
                }
                if(letterCount >= lowerBound && letterCount <= upperBound)
                    validPasswordsPart1++;

                //PART 2
                boolean first = false, second = false;
                if(meat.charAt(lowerBound-1) == letter)
                    first = true;
                if(meat.charAt(upperBound-1) == letter)
                    second = true;
                if((first && !second) || (second && !first))
                    validPasswordsPart2++;
            }
        } catch (FileNotFoundException exception) {}
        System.out.println(validPasswordsPart1 + "\n" + validPasswordsPart2);
    }
}