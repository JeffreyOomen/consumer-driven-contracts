package beer;

import beer.controller.BeerController;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public class BaseTest {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new BeerController());
    }
}
