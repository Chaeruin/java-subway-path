package subway;

import static org.assertj.core.api.Assertions.assertThat;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.StationLine;
import subway.service.PathService;

public class GraphTest {

    public void addVertex(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        graph.addVertex("왕십리역");
        graph.addVertex("행당역");
        graph.addVertex("마장역");
        graph.addVertex("서울숲역");
        graph.addVertex("압구정로데오역");
        graph.addVertex("논현역");
        graph.addVertex("학동역");
        graph.addVertex("강남구청역");
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph() {
        WeightedMultigraph<String, DefaultWeightedEdge> distance = new WeightedMultigraph(DefaultWeightedEdge.class);
        addVertex(distance);
        distance.setEdgeWeight(distance.addEdge("행당역", "왕십리역"), 2);
        distance.setEdgeWeight(distance.addEdge("왕십리역", "마장역"), 2);
        distance.setEdgeWeight(distance.addEdge("왕십리역", "서울숲역"), 3);
        distance.setEdgeWeight(distance.addEdge("압구정로데오역", "서울숲역"), 6);
        distance.setEdgeWeight(distance.addEdge("논현역", "학동역"), 1);
        distance.setEdgeWeight(distance.addEdge("학동역", "강남구청역"), 2);
        return distance;
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> timeGraph() {
        WeightedMultigraph<String, DefaultWeightedEdge> time = new WeightedMultigraph(DefaultWeightedEdge.class);
        addVertex(time);
        time.setEdgeWeight(time.addEdge("행당역", "왕십리역"), 3);
        time.setEdgeWeight(time.addEdge("왕십리역", "마장역"), 4);
        time.setEdgeWeight(time.addEdge("왕십리역", "서울숲역"), 3);
        time.setEdgeWeight(time.addEdge("압구정로데오역", "서울숲역"), 2);
        time.setEdgeWeight(time.addEdge("논현역", "학동역"), 1);
        time.setEdgeWeight(time.addEdge("학동역", "강남구청역"), 2);
        return time;
    }

    WeightedMultigraph<String, DefaultWeightedEdge> distance = distanceGraph();
    WeightedMultigraph<String, DefaultWeightedEdge> time = timeGraph();
    PathService pathService = new PathService();


    @Test
    @DisplayName("기능테스트_최단거리")
    void 기능테스트_최단거리() {

        StationLine start = new StationLine(new Station("왕십리역"), new Line("수인분당선"));
        StationLine end = new StationLine(new Station("압구정로데오역"), new Line("수인분당선"));

        assertThat(pathService.getShortestPath(start, end, distance)).isEqualTo(9.0);
    }

    @Test
    @DisplayName("기능테스트_최단시간")
    void 기능테스트_최단시간() {

        StationLine start = new StationLine(new Station("논현역"), new Line("7호선"));
        StationLine end = new StationLine(new Station("강남구청역"), new Line("7호선"));

        assertThat(pathService.getShortestPath(start, end, distance)).isEqualTo(3.0);
    }

    @Test
    @DisplayName("기능테스트_예외_Not_connected")
    void 기능테스트_예외_Not_Connected() {

        StationLine start = new StationLine(new Station("왕십리역"), new Line("수인분당선"));
        StationLine end = new StationLine(new Station("논현역"), new Line("7호선"));

        assertThat(pathService.getShortestPathVertex(start, end, distance)).isEqualTo(null);
    }

}
