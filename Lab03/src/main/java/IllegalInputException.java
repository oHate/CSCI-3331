public class IllegalInputException extends CalculatorException {

    private final String illegalType;

    public IllegalInputException(String illegalType) {
        this.illegalType = illegalType;
    }

    public String getIllegalType() {
        return this.illegalType;
    }

}
