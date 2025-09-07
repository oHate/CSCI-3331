public class BigInt {

    private final String value;

    public BigInt(String value) {
        if (value == null) {
            throw new IllegalArgumentException("BigInt value cannot be null");
        }

        if (!value.matches("\\d+")) {
            throw new IllegalArgumentException("BigInt value must be a number");
        }

        this.value = stripLeadingZeros(value);
    }

    private static String stripLeadingZeros(String value) {
        int index = 0;

        while (index < value.length() - 1 && value.charAt(index) == '0') {
            index++;
        }

        return value.substring(index);
    }

    private int compareTo(BigInt other) {
        if (this.value.length() != other.value.length()) {
            return Integer.compare(this.value.length(), other.value.length());
        }

        return this.value.compareTo(other.value);
    }

    public BigInt min(BigInt other) {
        if (this.compareTo(other) <= 0) {
            return this;
        } else {
            return other;
        }
    }

    public BigInt max(BigInt other) {
        if (this.compareTo(other) >= 0) {
            return this;
        } else {
            return other;
        }
    }

    public BigInt add(BigInt other) {
        StringBuilder sb = new StringBuilder();

        String numA = this.value;
        String numB = other.value;

        int indexA = numA.length() - 1;
        int indexB = numB.length() - 1;

        int carry = 0;

        while (indexA >= 0 || indexB >= 0 || carry > 0) {
            int columnSum = carry;

            if (indexA >= 0) {
                columnSum += numA.charAt(indexA--) - '0';
            }

            if (indexB >= 0) {
                columnSum += numB.charAt(indexB--) - '0';
            }

            sb.append(columnSum % 10);
            carry = columnSum / 10;
        }

        return new BigInt(sb.reverse().toString());
    }

    public BigInt multiply(BigInt other) {
        String numA = this.value;
        String numB = other.value;

        int[] productDigits = new int[numA.length() + numB.length()];

        for (int indexA = numA.length() - 1; indexA >= 0; indexA--) {
            int digitA = numA.charAt(indexA) - '0';

            for (int indexB = numB.length() - 1; indexB >= 0; indexB--) {
                int digitB = numB.charAt(indexB) - '0';

                int onesIndex = indexA + indexB + 1;
                int tensIndex = indexA + indexB;

                int sum = (digitA * digitB) + productDigits[onesIndex];

                productDigits[onesIndex] = sum % 10;
                productDigits[tensIndex] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int digit : productDigits) {
            if (!(sb.isEmpty() && digit == 0)) {
                sb.append(digit);
            }
        }

        return new BigInt(sb.isEmpty() ? "0" : sb.toString());
    }

    @Override
    public String toString() {
        return this.value;
    }

}
