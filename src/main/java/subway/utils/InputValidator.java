package subway.utils;

import subway.enums.ErrorMessage;

public class InputValidator {

    public static boolean isValidMenuInput(String input) {
        if (!(input.equals("1") || input.equals("Q"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_MENU.getErrorMessage());
        }
        return true;
    }

    public static boolean isValidPathInput(String input) {
        if (!(input.equals("1") || input.equals("2") || input.equals("B"))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_MENU.getErrorMessage());
        }
        return true;
    }

    public static boolean isSameStations(String start, String end) {
        if (start.equals(end)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_STATION_SAME.getErrorMessage());
        }
        return true;
    }

    public static boolean isExistStations(String input) {
        if (Finder.getFindStation(input) == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_STATION_NO_STATION.getErrorMessage());
        }
        return true;
    }
}
