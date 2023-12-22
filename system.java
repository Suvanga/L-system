import java.util.Scanner;

public class system {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Read angle, starting pattern, number of rules, rules, and expansion count
        double angle = scanner.nextDouble();
        scanner.nextLine(); // Move to the next line
        String startPattern = scanner.nextLine().trim().replaceAll(" ", "");
        int numRules = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        // Read rules
        String[] rules = new String[numRules];
        for (int i = 0; i < numRules; i++) {
            rules[i] = scanner.nextLine().trim().replaceAll(" ", "");
        }

        int expansionCount = scanner.nextInt();
        scanner.close();

        LinkedQueueImplementation<Character> queue = new LinkedQueueImplementation<>(); // Use custom queue

        // Initialize queue with start pattern
        for (char c : startPattern.toCharArray()) {
            queue.enqueue(c);
        }

        // Expansion loop
        while (expansionCount > 0) {
            int size = queue.size();
            while (size > 0) {
                try {
                    char current = queue.dequeue();
                    if (!Character.isUpperCase(current)) {
                        queue.enqueue(current);
                    } else {
                        // Apply expansion rules
                        String expansion = applyRules(current, rules);
                        for (char expandedChar : expansion.toCharArray()) {
                            queue.enqueue(expandedChar);
                        }
                    }
                } catch (QueueUnderflowException | QueueOverflowException e) {
                    e.printStackTrace(); // Handle exceptions if needed
                }
                size--;
            }
            expansionCount--;
        }

        // Output the final string
        StringBuilder finalString = new StringBuilder();
        try {
            while (!queue.isEmpty()) {
                finalString.append(queue.dequeue());
            }
            System.out.println("Final String: " + finalString.toString());
        } catch (QueueUnderflowException e) {
            e.printStackTrace(); // Handle exceptions if needed
        }
    }

    // Method to apply expansion rules
    private static String applyRules(char symbol, String[] rules) {
        for (String rule : rules) {
            if (rule.charAt(0) == symbol) {
                return rule.substring(1); // Return the expansion
            }
        }
        return String.valueOf(symbol); // Return unchanged if no rule matches
    }
}
