package beer.controller;

import beer.domain.Person;
import beer.http.Response;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class BeerController {
    private RestTemplate restTemplate;

    public BeerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(method = RequestMethod.POST, value="/beer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String gimmeBeer(@RequestBody Person person) {
        ResponseEntity<Response> response = this.restTemplate.exchange(
                RequestEntity
                    .post(URI.create("http://localhost:8090/check"))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(person),
                Response.class
        );

        switch (response.getBody().status) {
            case OK:
                return "THERE YOU GO";
            default:
                return "GET LOST";
        }
    }
}
