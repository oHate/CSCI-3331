import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class BigIntTest {

    private static final Random RANDOM = new SecureRandom();

    private static String generateRandomNumberString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < (1 + RANDOM.nextInt(200)); i++) {
            sb.append(RANDOM.nextInt(10));
        }

        return sb.toString();
    }

    private static void assertEquals(BigInt actual, BigInteger expected) {
        org.junit.jupiter.api.Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void add_manyLargePairs() {
        for (int i = 0; i < 50; i++) {
            String n1 = generateRandomNumberString();
            String n2 = generateRandomNumberString();

            assertEquals(
                    new BigInt(n1).add(new BigInt(n2)),
                    new BigInteger(n1).add(new BigInteger(n2))
            );
        }
    }

    @Test
    void multiply_manyLargePairs() {
        for (int i = 0; i < 50; i++) {
            String n1 = generateRandomNumberString();
            String n2 = generateRandomNumberString();

            assertEquals(
                    new BigInt(n1).multiply(new BigInt(n2)),
                    new BigInteger(n1).multiply(new BigInteger(n2))
            );
        }
    }

    @Test
    void multiply_byZeroAndOne() {
        String n1 = generateRandomNumberString();
        String n2 = "0";
        String n3 = "1";

        assertEquals(
                new BigInt(n1).multiply(new BigInt(n2)),
                new BigInteger(n1).multiply(new BigInteger(n2))
        );
        assertEquals(
                new BigInt(n2).multiply(new BigInt(n1)),
                new BigInteger(n2).multiply(new BigInteger(n1))
        );

        assertEquals(
                new BigInt(n1).multiply(new BigInt(n3)),
                new BigInteger(n1).multiply(new BigInteger(n3))
        );
        assertEquals(
                new BigInt(n3).multiply(new BigInt(n1)),
                new BigInteger(n3).multiply(new BigInteger(n1))
        );
    }

    @Test
    void minMax_manyLargePairs() {
        for (int i = 0; i < 50; i++) {
            String s1 = generateRandomNumberString();
            String s2 = generateRandomNumberString();

            assertEquals(
                    new BigInt(s1).min(new BigInt(s2)),
                    new BigInteger(s1).min(new BigInteger(s2))
            );

            assertEquals(
                    new BigInt(s1).max(new BigInt(s2)),
                    new BigInteger(s1).max(new BigInteger(s2))
            );
        }
    }

}
