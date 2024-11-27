package subway.controller;

import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.StationLine;
import subway.enums.ErrorMessage;
import subway.service.InfoInitService;
import subway.service.PathService;
import subway.utils.InputParser;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    final InputView inputView;
    final OutputView outputView;
    final InfoInitService infoInitService;
    final PathService pathService;

    public SubwayController(InputView inputView, OutputView outputView, InfoInitService infoInitService,
                            PathService pathService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.infoInitService = infoInitService;
        this.pathService = pathService;
    }

    WeightedMultigraph<String, DefaultWeightedEdge> distance = InfoInitService.stationLineGraphDistance();
    WeightedMultigraph<String, DefaultWeightedEdge> time = InfoInitService.stationLineGraphTime();

    public void run() {
        initSubway();
        String mainMenuInput = getMainMenuInput();
        while (!mainMenuInput.equals("Q")) {
            String pathInput = getPathCrit();
            if (pathInput.equals("B")) {
                mainMenuInput = getMainMenuInput();
                continue;
            }
            StationLine start = inputStartStationHandler();
            if (start == null) {
                pathInput = getPathCrit();
                continue;
            }
            StationLine end = inputEndStationHandler(start.getStation().getName());
            if (end == null) {
                pathInput = getPathCrit();
                continue;
            }
            shortestGetterHandler(pathInput, start, end);
            mainMenuInput = getMainMenuInput();
        }
    }

    public void initSubway() {
        infoInitService.initStationLineTwo();
        infoInitService.initStationLineThree();
        infoInitService.initStationLineShin();
    }

    public String getMainMenuInput() {
        outputView.printMainMenu();
        return inputMenuHandler();
    }

    public String getPathCrit() {
        outputView.printPathCrit();
        return inputPathHandler();
    }

    public void shortestGetterHandler(String pathInput, StationLine start, StationLine end) {
        boolean isFlag = false;
        while (!isFlag) {
            try {
                isFlag = getShortestAndAccordingPrint(pathInput, start, end);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        isFlag = false;
    }

    public boolean getShortestAndAccordingPrint(String pathInput, StationLine start, StationLine end) {
        if (pathInput.equals("1")) {
            setShortestDistanceAndAccording(start, end);
        }
        if (pathInput.equals("2")) {
            setShortestTimeAndAccording(start, end);
        }
        return true;
    }

    public void setShortestDistanceAndAccording(StationLine start, StationLine end) {
        double shortest = pathService.getShortestPath(start, end, distance);
        List<String> vertex = pathService.getShortestPathVertex(start, end, distance);
        if (vertex == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_STATION_NOT_CONNECTED.getErrorMessage());
        }
        double according = pathService.getIntAccordingToDistanceShortest(vertex, time);
        outputView.printResultDistance(shortest, according, vertex);
    }

    public void setShortestTimeAndAccording(StationLine start, StationLine end) {
        List<String> vertex = pathService.getShortestPathVertex(start, end, time);
        if (vertex == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_STATION_NOT_CONNECTED.getErrorMessage());
        }
        double according = pathService.getIntAccordingToTimeShortest(vertex, distance);
        double shortest = pathService.getShortestPath(start, end, time);
        outputView.printResultTime(shortest, according, vertex);
    }

    public String inputMenuHandler() {
        String input = null;
        while (input == null) {
            try {
                input = InputParser.getMenuInput(inputView.getMainMenu());
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    public String inputPathHandler() {
        String input = null;
        while (input == null) {
            try {
                input = InputParser.getPathInput(inputView.getPathCrit());
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    public StationLine inputStartStationHandler() {
        StationLine start = null;
        while (start == null) {
            try {
                start = InputParser.getStartStation(inputView.getStartStation());
                return start;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return start;
    }

    public StationLine inputEndStationHandler(String start) {
        StationLine end = null;
        while (end == null) {
            try {
                end = InputParser.getEndStation(start, inputView.getEndStation());
                return end;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return end;
    }
}
