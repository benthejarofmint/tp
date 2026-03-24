package seedu.duke.transaction;

import seedu.duke.MoneyBagProMaxException;

/**
 * Represents the frequency of a recurring transaction.
 */
public enum Frequency {
    DAILY, WEEKLY, MONTHLY;

    /**
     * Parses a string into a Frequency enum value (case-insensitive).
     *
     * @param s the string to parse
     * @return the corresponding Frequency
     * @throws MoneyBagProMaxException if the string does not match any frequency
     */
    public static Frequency fromString(String s) throws MoneyBagProMaxException {
        assert s != null : "Frequency string should not be null";
        switch (s.trim().toLowerCase()) {
        case "daily":
            return DAILY;
        case "weekly":
            return WEEKLY;
        case "monthly":
            return MONTHLY;
        default:
            throw new MoneyBagProMaxException(
                    "Invalid frequency '" + s + "'. Valid frequencies: daily, weekly, monthly");
        }
    }
}
