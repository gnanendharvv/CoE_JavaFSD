import java.util.*;

class AnagramLocator {
    public List<Integer> locateAnagrams(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        if (text.length() < pattern.length()) return result;
        int[] patternCount = new int[26];
        int[] textCount = new int[26];

        for (char c : pattern.toCharArray()) patternCount[c - 'a']++;

        for (int i = 0; i < text.length(); i++) {
            textCount[text.charAt(i) - 'a']++;
            if (i >= pattern.length()) textCount[text.charAt(i - pattern.length()) - 'a']--;
            if (Arrays.equals(patternCount, textCount)) result.add(i - pattern.length() + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the main string: ");
        String text = scanner.nextLine();
        System.out.print("Enter the pattern string: ");
        String pattern = scanner.nextLine();
        AnagramLocator locator = new AnagramLocator();
        System.out.println(locator.locateAnagrams(text, pattern));
        scanner.close();
    }
}
