package subway.enums;

public enum ErrorMessage {

    INVALID_INPUT_MENU("[ERROR] 유효한 메뉴 입력이 아닙니다."),
    INVALID_INPUT_STATION_NO_STATION("[ERROR] 존재하지 않는 역사입니다."),
    INVALID_INPUT_STATION_SAME("[ERROR] 출발역과 도착역이 같을 수 없습니다."),
    INVALID_STATION_NOT_CONNECTED("[ERROR] 출발역과 도착역이 연결 되어 있지 않습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
