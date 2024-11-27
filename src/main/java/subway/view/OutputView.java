package subway.view;

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

    public void printResult() {
        System.out.println("## 조회 결과\n"
                + "[INFO] ---\n");
        System.out.println("[INFO] 총 거리: " + "km");
        System.out.println("[INFO] 총 소요 시간: " + "분");
        System.out.println("[INFO] ---");
        // 경유 역 프린트
    }
}
