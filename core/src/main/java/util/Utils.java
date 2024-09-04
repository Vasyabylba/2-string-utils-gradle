package util;

import ru.clevertec.util.StringUtils;

import java.util.Arrays;

public class Utils {
    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isAllPositiveNumbers(String... str) {
        if (str == null) {
            return false;
        }
        return Arrays.stream(str).allMatch(StringUtils::isPositiveNumber);
    }
}
