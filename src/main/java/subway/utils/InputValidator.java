package subway.utils;

public class InputValidator {

    public boolean isValidMenuInput(String input) {
        if (!(input.equals("1") || input.equals("Q"))) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
