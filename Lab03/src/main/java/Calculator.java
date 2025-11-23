public class Calculator {

    /**
     * Compute the result of the expression encoded in a sequence of tokens.
     * <p>
     * Here are the different cases:
     * 0 tokens: IllegalInputException: "Illegal Token Length"
     * 1 token:
     * "quit" (any casing): QuitException
     * All other cases: IllegalInputException: "Illegal Argument"
     * 2 tokens:
     * "+" and any number: return positive of number
     * "+" and not a number: IllegalInputException: "Illegal Argument"
     * other string and any string: IllegalInputException: "Illegal Operator"
     * 3 tokens:
     * number1, "*", number2: return multiplication of two numbers
     * number1, "/", zero: DivideByZeroException
     * number1, "/", not zero: return number1/number2
     * not a number, anything, anything: IllegalInputException: "Illegal Argument"
     * number1, anything, not a number: IllegalInputException: "Illegal Argument"
     * number1, not an operator, number2: IllegalInputException: "Illegal Operator"
     * 4 or more tokens: IllegalInputException: "Illegal Token Length"
     * <p>
     * Note: all numbers are integers
     *
     * @param tokens The array of tokens to evaluate
     * @return int result of evaluating the expression
     * @throws CalculatorException If some form of error has been generated or
     *                             "quit" has been typed. Throws one of the several child classes of CalculatorException
     *                             in order to give more information on what the error is.
     */
    public static int compute(String[] tokens) throws CalculatorException {
        switch (tokens.length) {
            case 1 -> {
                if (tokens[0].equalsIgnoreCase("quit")) {
                    throw new QuitException();
                }

                throw new IllegalInputException("Illegal Token Type");
            }
            case 2 -> {
                if (tokens[0].equals("+")) {
                    try {
                        return Integer.parseInt(tokens[1]);
                    } catch (NumberFormatException ignored) {
                        throw new IllegalInputException("Illegal Argument");
                    }
                } else {
                    throw new IllegalInputException("Illegal Operator");
                }
            }
            case 3 -> {
                try {
                    int num1 = Integer.parseInt(tokens[0]);
                    int num2 = Integer.parseInt(tokens[2]);

                    String operator = tokens[1];

                    if (operator.equals("*")) {
                        return num1 * num2;
                    } else if (operator.equals("/")) {
                        if (num2 == 0) {
                            throw new DivideByZeroException();
                        }

                        return num1 / num2;
                    } else {
                        throw new IllegalInputException("Illegal Operator");
                    }
                } catch (NumberFormatException ignored) {
                    throw new IllegalInputException("Illegal Argument");
                }
            }
            default -> throw new IllegalInputException("Illegal Token Length");
        }
    }

    /**
     * Parse the input string as an expression and evaluate it.
     * <p>
     * If the input is a legal expression, then the result is printed
     * <p>
     * Otherwise a CalculatorException has occurred.  Print a message based on
     * what exception type it is.
     * <p>
     * Always print out what the input was. Use a finally block for this.
     * <p>
     * Always prints out two lines, following the rules:
     * 1st line:
     * -No Exception: "The result is: " + result
     * -QuitException: "Quitting"
     * -DivideByZeroException: "Tried to divide by zero"
     * -IllegalInputException: "Illegal input: " + illegalinputtype(given to constructor)
     * -CalculatorException: <should never happen> e.getMessage()
     * 2nd line:
     * "Input was: " + input
     *
     * @param input A String possibly containing a mathematical expression
     * @return true if the String is equal to "quit"; false otherwise
     */
    public static boolean parseAndCompute(String input) {
        String[] tokens = input.split(" ");

        try {
            System.out.println("The result is: " + compute(tokens));
        } catch (QuitException e) {
            System.out.println("Quitting");
            return true;
        } catch (IllegalInputException e) {
            System.out.println("Illegal Input: " + e.getIllegalType());
        } catch (CalculatorException e) {
            if (e instanceof DivideByZeroException) {
                System.out.println("Divide by zero");
            } else {
                System.out.println(e.getMessage());
            }
        } finally {
            System.out.println("Input was: " + input);
        }

        return false;
    }

}