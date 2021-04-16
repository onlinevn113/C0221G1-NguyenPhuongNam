package bai13_.bai_tap.bai1_chuoi_tang_dan_dai_nhat;
import java.util.*;
public class Exercise_22_02 {
    public static void main(String[] args) {
        // Create controllers Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter controllers string
        System.out.print("Enter controllers string: ");
        String string = input.nextLine();

        LinkedList<Character> max = new LinkedList<>();

        // Find the maximum increasingly ordered subsequence
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }

        // Display the maximum consecutive
        // increasingly ordered substring
        for (Character ch : max) { // single loop
            System.out.print(ch); // Simple statement
        }
        System.out.println();
    }
}