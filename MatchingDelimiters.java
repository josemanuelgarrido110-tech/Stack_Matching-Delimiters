import java.util.Scanner;
import java.util.Stack;

public class MatchingDelimiters {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();

        System.out.print("Enter a sequence: ");
        String expression = input.nextLine();

        boolean valid = true;
        String reason = "";

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // Push opening delimiters
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            // Process closing delimiters
            else if (ch == ')' || ch == ']' || ch == '}') {

                if (stack.isEmpty()) {
                    valid = false;
                    reason =
                        "Closing delimiter has no matching opening delimiter.";
                    break;
                }

                char top = stack.peek();

                if ((ch == ')' && top == '(') ||
                    (ch == ']' && top == '[') ||
                    (ch == '}' && top == '{')) {

                    stack.pop();

                } else {
                    valid = false;
                    reason = "Mismatched delimiters.";
                    break;
                }
            }
        }

        if (valid && !stack.isEmpty()) {
            valid = false;
            reason = "Unmatched opening delimiter remains.";
        }

        if (valid) {
            System.out.println("Result: Valid");
        } else {
            System.out.println("Result: Invalid");
            System.out.println("Reason: " + reason);
        }

        input.close();
    }
}
