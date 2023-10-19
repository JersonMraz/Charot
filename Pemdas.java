import java.util.*;

public class Pemdas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a mathematical expression: ");
        String expression = sc.nextLine();

        double result = evaluateExpression(expression);

        if (!Double.isNaN(result)) {
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid expression");
        }

        sc.close();
    }

    public static double evaluateExpression(String expression) {
        expression = expression.replaceAll("\\s+", ""); // Remove spaces

        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (Character.isDigit(currentChar) || currentChar == '.') {
                StringBuilder operand = new StringBuilder();

                while (i < expression.length() &&
                        (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    operand.append(expression.charAt(i));
                    i++;
                }

                numbers.push(Double.parseDouble(operand.toString()));
                i--; // Move back one position after parsing the operand
            } else if (currentChar == '(') {
                operators.push(currentChar);
            } else if (currentChar == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    performOperation(numbers, operators);
                }
                operators.pop(); // Remove the '('
            } else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                while (!operators.isEmpty() && hasPrecedence(currentChar, operators.peek())) {
                    performOperation(numbers, operators);
                }
                operators.push(currentChar);
            }
        }

        while (!operators.isEmpty()) {
            performOperation(numbers, operators);
        }

        return numbers.size() == 1 && operators.isEmpty() ? numbers.pop() : Double.NaN;
    }

    public static boolean hasPrecedence(char operator1, char operator2) {
        return (operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-');
    }

    public static void performOperation(Stack<Double> numbers, Stack<Character> operators) {
        if (numbers.size() >= 2 && !operators.isEmpty()) {
            double operand2 = numbers.pop();
            double operand1 = numbers.pop();
            char operator = operators.pop();
            double result = 0.0;

            switch (operator) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '*':
                    result = operand1 * operand2;
                    break;
                case '/':
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    }
                    break;
            }
            numbers.push(result);
        }
    }
}