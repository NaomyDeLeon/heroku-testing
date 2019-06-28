/*
 */
package avanxo.heroku.technical.test.data.procesors;

import avanxo.heroku.technical.test.data.structures.Event;
import java.util.List;

/**
 *
 * @author pytagoraz
 */
public interface EventService extends java.io.Serializable {

    List<Event> getAllEventsOrderedByCreationDate();

    List<Event> getEventsByCategory(String categoryName) throws Exception;

    Event getEventById(Integer eventId) throws Exception;

    Event createEvent(Event event) throws Exception;

    Event updateEvent(Integer eventId, Event event) throws Exception;

    void deleteEvent(Integer eventId) throws Exception;

}
