import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static pages.Constant.BASE_URL;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = BASE_URL;
        Configuration.pageLoadStrategy = "eager";
    }
}
