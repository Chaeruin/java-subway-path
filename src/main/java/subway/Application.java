package subway;

import subway.controller.SubwayController;
import subway.service.InfoInitService;
import subway.service.PathService;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InfoInitService infoInitService = new InfoInitService();
        PathService pathService = new PathService();

        SubwayController subwayController = new SubwayController(inputView, outputView, infoInitService, pathService);

        subwayController.run();
    }
}
