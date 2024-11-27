package subway.view;

import java.util.List;

public class OutputView {

    public void printEnter() {
        System.out.println();
    }

    public void printMainMenu() {
        System.out.println("## 메인 화면\n"
                + "1. 경로 조회\n"
                + "Q. 종료\n");
    }

    public void printPathCrit() {
        System.out.println("## 경로 기준\n"
                + "1. 최단 거리\n"
                + "2. 최소 시간\n"
                + "B. 돌아가기\n");
    }

    public void printResultDistance(double shortest, double according, List<String> vertex) {
        System.out.println("## 조회 결과\n"
                + "[INFO] ---");
        System.out.println("[INFO] 총 거리: " + (int) shortest + "km");
        System.out.println("[INFO] 총 소요 시간: " + (int) according + "분");
        System.out.println("[INFO] ---");
        for (int i = 0; i < vertex.size(); i++) {
            System.out.println("[INFO] " + vertex.get(vertex.size() - 1 - i));
        }
        printEnter();
    }

    public void printResultTime(double shortest, double according, List<String> vertex) {
        System.out.println("## 조회 결과\n"
                + "[INFO] ---");
        System.out.println("[INFO] 총 거리: " + (int) according + "km");
        System.out.println("[INFO] 총 소요 시간: " + (int) shortest + "분");
        System.out.println("[INFO] ---");
        // 경유 역 프린트
        for (int i = 0; i < vertex.size(); i++) {
            System.out.println("[INFO] " + vertex.get(vertex.size() - 1 - i));
        }
        printEnter();
    }
}
