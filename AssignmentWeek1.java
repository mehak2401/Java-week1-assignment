public class AssignmentWeek1 {

    public static void main(String[] args) {
        // --- Test Problem 1 ---
        System.out.println("--- Problem 1: Seat Duplication Checker ---");
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});

        // --- Test Problem 2 ---
        System.out.println("\n--- Problem 2: Typing Speed Accuracy ---");
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");

        // --- Test Problem 3 ---
        System.out.println("\n--- Problem 3: Traffic Signal Streak ---");
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");

        // --- Test Problem 4 ---
        System.out.println("\n--- Problem 4: Warehouse Inventory ---");
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});

        // --- Test Problem 5 ---
        System.out.println("\n--- Problem 5: Word Length Profiler ---");
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }

    // ==========================================
    // 1. The Exam Hall Seat Duplication Checker
    // ==========================================
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        // Use nested loops to compare each seat with every subsequent seat
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break; // Move to the next outer element once duplicate for seatNumbers[i] is found
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    // ==========================================
    // 2. The Typing Speed Test Accuracy Checker
    // ==========================================
    public static void checkTypingAccuracy(String original, String typed) {
        int matches = 0;
        int total = original.length();
        int firstMismatchPos = -1;
        char origChar = ' ', typedChar = ' ';

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else if (firstMismatchPos == -1) {
                // Record 1-based index and characters of the very first mismatch
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

    // ==========================================
    // 3. The Traffic Signal Streak Analyzer
    // ==========================================
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Log is empty.");
            return;
        }

        char maxColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }

            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                maxColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + maxColor + "' repeated " + maxStreak + " times");
    }

    // ==========================================
    // 4. The Warehouse Inventory Balancer
    // ==========================================
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        int highestQty = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestSection = "Section A";
                highestIndex = i + 1; // 1-based index for item reporting
            }

            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                highestSection = "Section B";
                highestIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + 
                           " | Section B Total: " + totalB + 
                           " | Status: " + status + 
                           " | Highest Quantity: " + highestQty + 
                           " (" + highestSection + ", Item " + highestIndex + ")");
    }

    // ==========================================
    // 5. The Movie Review Word Length Profiler
    // ==========================================
    public static void classifyWordLengths(String review) {
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        // Split by whitespace
        String[] words = review.trim().split("\\s+");

        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }
}