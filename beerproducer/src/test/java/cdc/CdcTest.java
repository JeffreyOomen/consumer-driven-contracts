package cdc;

import beer.ProducerApplication;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public class CdcTest {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new ProducerApplication());
    }
}
