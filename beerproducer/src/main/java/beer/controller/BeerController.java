package beer.controller;

import beer.http.Response;
import beer.http.ResponseStatus;
import domain.PersonToCheck;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {

    @RequestMapping(value = "/check", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public Response check(@RequestBody PersonToCheck personToCheck) {
        if (personToCheck.age >= 20) {
            return new Response(ResponseStatus.OK);
        }
        return new Response(ResponseStatus.NOT_OK);
    }
}
