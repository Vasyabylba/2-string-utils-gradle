package util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilsTest {

    public static Stream<List<String>> isAllPositiveNumbers_true() {
        return Stream.of(List.of("0.1", "1", "2147483647", "2147483648", "10000000000000000000"));
    }

    public static Stream<List<String>> isAllPositiveNumbers_false() {
        return Stream.of(Collections.singletonList(null),
                List.of("0", "0.1", "1", "2147483647", "2147483648", "10000000000000000000"),
                List.of("-0.1", "1", "2147483647", "2147483648", "10000000000000000000"),
                List.of("0.1", "-1", "2147483647", "2147483648", "10000000000000000000"),
                List.of("0.1", "1", "-2147483647", "2147483648", "10000000000000000000"),
                List.of("0.1", "1", "2147483647", "-2147483648", "10000000000000000000"),
                List.of("0.1", "1", "2147483647", "2147483648", "-10000000000000000000"),
                Arrays.asList("0.1", "1", "2147483647", "2147483648", "10000000000000000000", null)
        );
    }

    @ParameterizedTest
    @MethodSource
    void isAllPositiveNumbers_true(List<String> numbers) {
        boolean isAllPositiveNumbers = Utils.isAllPositiveNumbers(numbers.toArray(String[]::new));

        assertTrue(isAllPositiveNumbers);
    }

    @ParameterizedTest
    @MethodSource
    void isAllPositiveNumbers_false(List<String> numbers) {
        boolean isAllPositiveNumbers = Utils.isAllPositiveNumbers(numbers.toArray(String[]::new));

        assertFalse(isAllPositiveNumbers);
    }
}