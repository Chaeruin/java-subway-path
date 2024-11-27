package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationLineRepository {
    private static final List<StationLine> stationLines = new ArrayList<>();

    public static List<StationLine> stationLines() {
        return Collections.unmodifiableList(stationLines);
    }

    public static void addStation(StationLine stationLine) {
        stationLines.add(stationLine);
    }
    
    public static boolean deleteStation(String name) {
        return stationLines.removeIf(station -> Objects.equals(station.getStation().getName(), name));
    }

    public static void deleteAll() {
        stationLines.clear();
    }
}
