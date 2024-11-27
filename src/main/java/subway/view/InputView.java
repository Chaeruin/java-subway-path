package subway.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getMainMenu() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return Console.readLine();
    }

    public String getPathCrit() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return Console.readLine();
    }

    public String getStartStation() {
        System.out.println("## 출발역을 입력하세요.");
        return Console.readLine();
    }

    public String getEndStation() {
        System.out.println("## 도착역을 입력하세요.");
        return Console.readLine();
    }
}
