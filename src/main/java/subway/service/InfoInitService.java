package subway.service;

import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.StationLine;
import subway.domain.StationLineRepository;

public class InfoInitService {

    // 근데 이래봤자 누적돼서 리턴될듯
    public List<StationLine> initStationLineTwo() {
        Line line = new Line("2호선");
        StationLineRepository.addStation(new StationLine(new Station("교대역"), line));
        StationLineRepository.addStation(new StationLine(new Station("강남역"), line));
        StationLineRepository.addStation(new StationLine(new Station("역삼역"), line));
        return StationLineRepository.stationLines();
    }

    public List<StationLine> initStationLineThree() {
        Line line = new Line("3호선");
        StationLineRepository.addStation(new StationLine(new Station("교대역"), line));
        StationLineRepository.addStation(new StationLine(new Station("남부터미널역"), line));
        StationLineRepository.addStation(new StationLine(new Station("양재역"), line));
        StationLineRepository.addStation(new StationLine(new Station("매봉역"), line));
        return StationLineRepository.stationLines();
    }

    public List<StationLine> initStationLineShin() {
        Line line = new Line("신분당선");
        StationLineRepository.addStation(new StationLine(new Station("강남역"), line));
        StationLineRepository.addStation(new StationLine(new Station("양재역"), line));
        StationLineRepository.addStation(new StationLine(new Station("양재시민의숲역"), line));
        return StationLineRepository.stationLines();
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> stationLineGraphDistance() {
        WeightedMultigraph<String, DefaultWeightedEdge> distance = new WeightedMultigraph(DefaultWeightedEdge.class);
        addVertex(distance);
        addEdgeWeight(distance);
        return distance;
    }

    public void addVertex(WeightedMultigraph<String, DefaultWeightedEdge> distance) {
        distance.addVertex("교대역");
        distance.addVertex("강남역");
        distance.addVertex("역삼역");
        distance.addVertex("양재역");
        distance.addVertex("양재시민의숲역");
        distance.addVertex("남부터미널역");
        distance.addVertex("매봉역");
    }

    public void addEdgeWeight(WeightedMultigraph<String, DefaultWeightedEdge> distance) {
        distance.setEdgeWeight(distance.addEdge("교대역", "강남역"), 2);
        distance.setEdgeWeight(distance.addEdge("강남역", "역삼역"), 2);
        distance.setEdgeWeight(distance.addEdge("교대역", "남부터미널역"), 3);
        distance.setEdgeWeight(distance.addEdge("남부터미널역", "양재역"), 6);
        distance.setEdgeWeight(distance.addEdge("양재역", "매봉역"), 1);
        distance.setEdgeWeight(distance.addEdge("강남역", "양재역"), 2);
        distance.setEdgeWeight(distance.addEdge("양재역", "양재시민의숲역"), 10);
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> stationLineGraphTime() {
        WeightedMultigraph<String, DefaultWeightedEdge> time = new WeightedMultigraph(DefaultWeightedEdge.class);
        addVertex(time);
        addEdgeWeightTime(time);
        return time;
    }

    public void addEdgeWeightTime(WeightedMultigraph<String, DefaultWeightedEdge> time) {
        time.setEdgeWeight(time.addEdge("교대역", "강남역"), 3);
        time.setEdgeWeight(time.addEdge("강남역", "역삼역"), 3);
        time.setEdgeWeight(time.addEdge("교대역", "남부터미널역"), 2);
        time.setEdgeWeight(time.addEdge("남부터미널역", "양재역"), 5);
        time.setEdgeWeight(time.addEdge("양재역", "매봉역"), 1);
        time.setEdgeWeight(time.addEdge("강남역", "양재역"), 8);
        time.setEdgeWeight(time.addEdge("양재역", "양재시민의숲역"), 3);
    }

}
