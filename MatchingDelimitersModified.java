import java.util.Scanner;
import java.util.Stack;

public class MatchingDelimiterModified {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();

        System.out.print("Enter a sequence: ");
        String expression = input.nextLine();

        boolean valid = true;
        String reason = "";

        System.out.println("\n--- Stack Execution Trace ---");

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // Push opening delimiters
            if (ch == '(' || ch == '[' ||
                ch == '{' || ch == '<') {

                stack.push(ch);

                System.out.println("Read: " + ch);
                System.out.println("Operation: PUSH " + ch);
                System.out.println("Stack: " + stack);
            }

            // Process closing delimiters
            else if (ch == ')' || ch == ']' ||
                     ch == '}' || ch == '>') {

                System.out.println("Read: " + ch);

                // Check if the stack is empty
                if (stack.isEmpty()) {
                    valid = false;
                    reason =
                        "Closing delimiter has no matching opening delimiter.";

                    System.out.println("Error: Stack is empty.");
                    break;
                }

                // Check the top element
                char top = stack.peek();

                System.out.println("Operation: PEEK " + top);

                // Compare opening and closing delimiters
                if ((ch == ')' && top == '(') ||
                    (ch == ']' && top == '[') ||
                    (ch == '}' && top == '{') ||
                    (ch == '>' && top == '<')) {

                    stack.pop();

                    System.out.println("Operation: POP " + top);
                    System.out.println("Stack: " + stack);

                } else {
                    valid = false;
                    reason = "Mismatched delimiters.";

                    System.out.println(
                        "Error: Closing delimiter does not match " + top
                    );
                    System.out.println("Stack: " + stack);
                    break;
                }
            }
        }

        // Check for unmatched opening delimiters
        if (valid && !stack.isEmpty()) {
            valid = false;
            reason = "Unmatched opening delimiter remains.";

            System.out.println("Remaining stack: " + stack);
        }

        // Display the final result
        System.out.println("\n--- Final Result ---");

        if (valid) {
            System.out.println("Result: Valid");
        } else {
            System.out.println("Result: Invalid");
            System.out.println("Reason: " + reason);
        }

        input.close();
    }
}
