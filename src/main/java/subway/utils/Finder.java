package subway.utils;

import subway.domain.StationLine;
import subway.domain.StationLineRepository;

public class Finder {

    public static StationLine getFindStation(String input) {
        for (StationLine st : StationLineRepository.stationLines()) {
            if (st.getStation().getName().equals(input)) {
                return st;
            }
        }
        return null;
    }

}
