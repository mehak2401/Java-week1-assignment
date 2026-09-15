public class TypingChecker {

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }

    public static void checkTypingAccuracy(String original, String typed) {
        int matches = 0;
        int total = original.length();
        int firstMismatchPos = -1;
        char origChar = ' ', typedChar = ' ';

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = ((double) matches / total) * 100;
        String result = String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matches, total, accuracy);

        if (firstMismatchPos != -1) {
            result += String.format("First Mismatch at position %d ('%c' vs '%c')", firstMismatchPos, origChar, typedChar);
        } else {
            result += "No Mismatches";
        }

        System.out.println(result);
    }
}