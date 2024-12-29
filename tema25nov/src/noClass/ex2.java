package noClass;

import java.util.*;

//Take a sentence as input, split it into words, and store the words in a List<String>.
// Remove duplicate words and display the list in alphabetical order.
public class ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputStr = scanner.nextLine();

        List<String> tokens = new ArrayList<>(Arrays.asList(inputStr.split("\\s+")));
        Set<String> listWithoutDuplicates = new LinkedHashSet<String>(tokens);
        tokens.clear();
        tokens.addAll(listWithoutDuplicates);
        Collections.sort(tokens);

        System.out.println(tokens);
    }
}
