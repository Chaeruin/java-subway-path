package subway;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest extends NsTest {

    String ERROR_MESSAGE = "[ERROR]";


    @Test
    @DisplayName("기능 테스트_1최단거리")
    void 기능_테스트() {
        assertSimpleTest(() -> {
            run("1", "1", "강남역", "남부터미널역", "Q");
            assertThat(output()).contains("총 거리: 5km", "총 소요 시간: 5분", "강남역", "교대역", "남부터미널역");
        });
    }

    @Test
    @DisplayName("경로 화면에서 메인 메뉴로 Back")
    void 경로_선택_화면에서_메인_메뉴로_Back() {
        assertSimpleTest(() -> {
            run("1", "B", "Q");
            assertThat(output()).contains("## 메인 화면\n"
                    + "1. 경로 조회\n"
                    + "Q. 종료");
        });
    }

    @Test
    @DisplayName("메인화면 기능 입력이 1 또는 Q가 아니면 예외")
    void 메인_기능_선택_예외() throws Exception {
        assertSimpleTest(
                () -> {
                    runException("a");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    @DisplayName("경로선택 기능 입력이 1 / 2 또는 B가 아니면 예외")
    void 경로_기능_선택_예외() throws Exception {
        assertSimpleTest(
                () -> {
                    runException("1", "q");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    @DisplayName("출발 역이 존재하지 않으면 예외")
    void 출발역_미존재_예외() throws Exception {
        assertSimpleTest(
                () -> {
                    runException("1", "2", "고속터미널역");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    @DisplayName("도착 역이 존재하지 않으면 예외")
    void 도착역_미존재_예외() throws Exception {
        assertSimpleTest(
                () -> {
                    runException("1", "2", "강남역", "고속터미널역");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    @DisplayName("출발역과 도착역 이름이 같으면 예외")
    void 출발역과_도착역_같음_예외() throws Exception {
        assertSimpleTest(
                () -> {
                    runException("1", "2", "강남역", "강남역");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
