/*
 * 
 */
package avanxo.heroku.technical.test.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pytagoraz
 */
@RestController
@RequestMapping("/events")
public class EventController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/by-creation-date",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllEventsOrderedByCreationDate() {
        return "helllo";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/categories/{categoryName}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllEventsByCategoryName() {
        return "helllo";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/{categoryId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getEventByCategoryId() {
        return "helllo";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createEvent() {
        return "helllo";
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(
            path = "/{categoryId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateEvent() {
        return "helllo";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{categoryId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteEvent() {
        return "helllo";
    }

}
