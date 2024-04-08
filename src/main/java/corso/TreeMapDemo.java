package corso;

import java.util.*;
import java.util.Map.Entry;

public class TreeMapDemo {
    public static void main(String[] args) {
        System.out.println("Hello TreeMapDemo!");

        Map<String, Double> accounts = new TreeMap<String, Double>(
                new LastName());

        accounts.put("A Z", 0.0);
        accounts.put("A A", 1.0);

        for (Entry<String, Double> account : accounts.entrySet()) {
            System.out.println(account);
        }

    }
}

class LastName implements Comparator<String> {

    @Override
    public int compare(String name1, String name2) {

        int compared = this.lastName(name1).compareTo(this.lastName(name2));
        if (compared != 0)
            return compared;
        else
            return this.firstName(name1).compareTo(this.firstName(name2));

    }

    private String firstName(String fullName) {
        int index = fullName.lastIndexOf(' ');
        if (index == -1)
            throw new IllegalArgumentException("Only a single name: " + fullName);
        String firstName = fullName.substring(0, index);
        // String lastName = fullName.substring(index + 1);
        return firstName;
    }

    private String lastName(String fullName) {
        int index = fullName.lastIndexOf(' ');
        if (index == -1)
            throw new IllegalArgumentException("Only a single name: " + fullName);
        // String firstName = fullName.substring(0, index);
        String lastName = fullName.substring(index + 1);
        return lastName;
    }

}
