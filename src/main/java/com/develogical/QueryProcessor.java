package com.develogical;

public class QueryProcessor {

  public static int extractAndCalculate(String query) {
    // Extract the numbers and arithmetic operation from the query
    System.out.println(query);
    int number1 = extractNumber(query);
    int number2 = extractNumber(query.substring(query.lastIndexOf("?") + 1));
    System.out.println(number1);
    System.out.println(number2);
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
    String[] words = query.split(" ");
    for (String word : words) {
        if (word.matches("\\d+")) {
            return Integer.parseInt(word);
        }
    }
    return 0; // Default value if no number is found
}

public static String extractOperation(String query) {
    String[] words = query.split(" ");
    for (String word : words) {
        if (word.equals("plus") || word.equals("minus") || word.equals("times") || word.equals("divided")) {
            return word;
        }
    }
    return ""; // Default value if no operation is found
}

  public static String findLargestNumber(String question) {
    // Extract numbers from the question
    String[] numbers = question.replaceAll("[^0-9]+", " ").trim().split(" ");
    
    System.out.println(numbers);
    // Convert numbers from string to integers
    int[] intNumbers = new int[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
        intNumbers[i] = Integer.parseInt(numbers[i]);
    }

    // Find the largest number
    int largestNumber = intNumbers[0];
    for (int i = 1; i < intNumbers.length; i++) {
        if (intNumbers[i] > largestNumber) {
            largestNumber = intNumbers[i];
        }
    }

    return "" + largestNumber;
}


  public String process(String query) {

    System.out.println("Received query:" + query);


    

    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
          + "English poet, playwright, and actor, widely regarded as the greatest "
          + "writer in the English language and the world's pre-eminent dramatist.";
    }

    if (query.toLowerCase().contains("name")) {
      return "Michael and Francisco";
    }

    if (query.toLowerCase().contains("Which of the following numbers is the largest")) {
      return findLargestNumber(query.toLowerCase());
    }


    if (query.toLowerCase().contains("plus")) {
      return "" + ArithmeticOperationExtractor.extractAndCalculate(query.toLowerCase());
    }


    return "";
  }
}
