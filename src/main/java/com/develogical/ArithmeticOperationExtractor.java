import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArithmeticOperationExtractor {
    public static void main(String[] args) {
        String query = "What is 26 plus 54?";
        int result = extractAndCalculate(query);
        System.out.println("Result: " + result);
    }

    public static int extractAndCalculate(String query) {
        // Extract the numbers and arithmetic operation from the query
        int number1 = extractNumber(query);
        int number2 = extractNumber(query, number1);
        String operation = extractOperation(query);

        // Perform the arithmetic operation
        int result = 0;
        switch (operation) {
            case "plus":
                result = number1 + number2;
                break;
            case "minus":
                result = number1 - number2;
                break;
            case "times":
                result = number1 * number2;
                break;
            case "divided":
                result = number1 / number2;
                break;
            default:
                System.out.println("Invalid operation");
        }

        return result;
    }

    public static int extractNumber(String query) {
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(query);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return 0; // Default value if no number is found
    }

    public static int extractNumber(String query, int exclude) {
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(query);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            if (number != exclude) {
                return number;
            }
        }
        return 0; // Default value if no other number is found
    }

    public static String extractOperation(String query) {
        Pattern pattern = Pattern.compile("\\b(plus|minus|times|divided)\\b");
        Matcher matcher = pattern.matcher(query);
        if (matcher.find()) {
            return matcher.group();
        }
        return ""; // Default value if no operation is found
    }
}