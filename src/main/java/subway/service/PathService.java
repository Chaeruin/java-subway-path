package subway.service;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.StationLine;

public class PathService {

    // 거리, 시간 둘 다 쓸 수 있음 (그래프 종류만 다르게 넣으면 됨)
    public double getShortestPath(StationLine start, StationLine end,
                                  WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        double shortestPath = dijkstraShortestPath.getPath(end.getStation().getName(),
                start.getStation().getName()).getWeight();
        return shortestPath;
    }

    public List<String> getShortestPathVertex(StationLine start, StationLine end,
                                              WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(end.getStation().getName(),
                start.getStation().getName()).getVertexList();

        return shortestPath;
    }

    // 최단거리로부터 소요되는 시간
    public double getIntAccordingToDistanceShortest(List<String> shortestPath,
                                                    WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        double sum = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            sum += graph.getEdgeWeight(graph.getEdge(shortestPath.get(i), shortestPath.get(i + 1)));
        }
        return sum;
    }

    // 최소 시간으로부터 걸리는 거리
    public double getIntAccordingToTimeShortest(List<String> shortestPath,
                                                WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        double sum = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            sum += graph.getEdgeWeight(graph.getEdge(shortestPath.get(i), shortestPath.get(i + 1)));
        }
        return sum;
    }
}
