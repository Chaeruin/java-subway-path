package subway.utils;

import subway.domain.StationLine;

public class InputParser {

    public static String getMenuInput(String input) {
        if (InputValidator.isValidMenuInput(input)) {
            return input;
        }
        return null;
    }

    public static String getPathInput(String input) {
        if (InputValidator.isValidPathInput(input)) {
            return input;
        }
        return null;
    }

    public static StationLine getStartStation(String input) {
        if (InputValidator.isExistStations(input)) {
            return Finder.getFindStation(input);
        }
        return null;
    }

    public static StationLine getEndStation(String start, String end) {
        if (InputValidator.isSameStations(start, end) && InputValidator.isExistStations(end)) {
            return Finder.getFindStation(end);
        }
        return null;
    }
}
