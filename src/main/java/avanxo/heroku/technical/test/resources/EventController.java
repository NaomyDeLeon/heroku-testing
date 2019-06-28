/*
 * 
 */
package avanxo.heroku.technical.test.resources;

import avanxo.heroku.technical.test.data.procesors.EventService;
import avanxo.heroku.technical.test.data.procesors.exceptions.InvalidCatalogDataException;
import avanxo.heroku.technical.test.data.structures.Event;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pytagoraz
 */
@RestController
@RequestMapping("/events")
public class EventController implements java.io.Serializable {

    @Autowired
    EventService eventService;

    @ApiResponses({
        @ApiResponse(
                code = 400,
                message = "when the info catalog doesn't match with event's ids",
                response = InvalidCatalogDataException.class)
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/by-creation-date",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> getAllEventsOrderedByCreationDate() {
        return this.eventService.getAllEventsOrderedByCreationDate();
    }

    @ApiResponses({
        @ApiResponse(
                code = 400,
                message = "when the info catalog doesn't match with event's ids",
                response = InvalidCatalogDataException.class)
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/categories/{categoryName}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> getAllEventsByCategoryName(
            @PathVariable("categoryName") String category) throws Exception {
        return this.eventService.getEventsByCategory(category);
    }

    @ApiResponses({
        @ApiResponse(
                code = 400,
                message = "when the info catalog doesn't match with event's ids",
                response = InvalidCatalogDataException.class)
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            path = "/{eventId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Event getEventByEventId(
            @PathVariable("eventId") Integer eventId) throws Exception {
        return this.eventService.getEventById(eventId);
    }

    @ApiResponses({
        @ApiResponse(
                code = 400,
                message = "when the info catalog doesn't match with event's ids",
                response = InvalidCatalogDataException.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Event createEvent(@RequestBody Event event) throws Exception {
        return this.eventService.createEvent(event);
    }

    @ApiResponses({
        @ApiResponse(
                code = 400,
                message = "when the info catalog doesn't match with event's ids",
                response = InvalidCatalogDataException.class)
    })
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(
            path = "/{eventId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Event updateEvent(
            @PathVariable("eventId") Integer eventId,
            @RequestBody Event event) throws Exception {
        return this.eventService.updateEvent(eventId, event);
    }

    @ApiResponses({
        @ApiResponse(
                code = 400,
                message = "when the info catalog doesn't match with event's ids",
                response = InvalidCatalogDataException.class)
    })
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(
            path = "/{eventId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> deleteEvent(@PathVariable("eventId") Integer eventId)
            throws Exception {
        this.eventService.deleteEvent(eventId);
        return this.eventService.getAllEventsOrderedByCreationDate();
    }

}
