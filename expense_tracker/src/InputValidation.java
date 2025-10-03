import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidation {
    private static final Set<String> VALID_CATEGORIES = new HashSet<>(
        Arrays.asList("food", "travel", "bills", "entertainment", "other")
    );

    public static boolean isValidAmount(double amount) {
        return amount > 0 && amount < 1000;
    }

    public static boolean isValidCategory(String category) {
        if (category == null) return false;
        return VALID_CATEGORIES.contains(category.trim().toLowerCase());
    }
}