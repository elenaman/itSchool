package noClass;

import java.util.ArrayList;
import java.util.List;

//Create a List<Character> with random alphabet characters. Sort the list ignoring case and display it.
public class ex6 {
    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>();
        characters.add('B');
        characters.add('a');
        characters.add('C');
        characters.add('e');
        characters.add('D');
        characters.add('f');

        characters.sort((c1, c2) -> Character.toLowerCase(c1) - Character.toLowerCase(c2));
        System.out.println(characters);
    }
}
