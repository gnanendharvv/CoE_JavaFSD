import java.util.*;

class StringHandling {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = sc.nextLine();
        
        System.out.println("Enter a character to be found in the string:");
        char c = sc.next().charAt(0);
        
        StringHandling obj = new StringHandling();
        System.out.println("Character count: " + obj.find(s, c));
        
        System.out.println("Reversed string: " + obj.rev(s));
        
        String[] arr = obj.split(s);
        System.out.println("Uppercased split strings:");
        for (String str : arr) {
            System.out.println(str.toUpperCase());
        }
        
        sc.close(); // Close the scanner to avoid resource leak
    }

    // Method to find occurrences of a character in the string
    public int find(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    // Method to reverse the string efficiently using StringBuilder
    public String rev(String s) {
        StringBuilder rev = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            rev.append(s.charAt(i));
        }
        return rev.toString();
    }

    // Method to split the string into words based on spaces
    public String[] split(String s) {
        return s.split(" ");
    }
}
