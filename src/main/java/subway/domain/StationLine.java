package subway.domain;

public class StationLine {
    private final Station station;
    private final Line line;

    public StationLine(Station station, Line line) {
        this.station = station;
        this.line = line;
    }

    public Station getStation() {
        return this.station;
    }

    public Line getLine() {
        return this.line;
    }
}
