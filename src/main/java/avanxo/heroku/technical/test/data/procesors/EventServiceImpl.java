/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanxo.heroku.technical.test.data.procesors;

import avanxo.heroku.technical.test.data.procesors.exceptions.InvalidCatalogDataException;
import avanxo.heroku.technical.test.data.procesors.exceptions.InvalidIdException;
import avanxo.heroku.technical.test.data.repositories.CatalogRepository;
import avanxo.heroku.technical.test.data.repositories.EventRepository;
import avanxo.heroku.technical.test.data.structures.Event;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    CatalogRepository catalogRepository;

    private static final String CATALOG_TYPE_CATEGORY = "category";
    private static final String CATALOG_TYPE_EVENT = "event_type";
    private static final String CATALOG_INVALID = "invalid catalog";
    private static final String EVENT_ID_INVALID = "invalid event id";
    private static final String EVENT_ID_NOT_REQUIRED = "invalid data event Id is not required";

    @Override
    public List<Event> getAllEventsOrderedByCreationDate() {
        List<Event> events;
        events = this.eventRepository.getEventsOrderedByCreationDateDesc();
        events = this.setEventListStringData(events);
        return events;
    }

    @Override
    public List<Event> getEventsByCategory(String categoryName)
            throws Exception {
        if (null == categoryName) {
            throw new InvalidIdException(CATALOG_INVALID);
        }
        Integer categoryId;
        categoryId = catalogRepository
                .getCatalogIdByNameAndType(categoryName, CATALOG_TYPE_CATEGORY);
        if (null == categoryId) {
            throw new InvalidIdException(CATALOG_INVALID);
        }
        List<Event> events = eventRepository.getEventByCategory(categoryId);
        events = this.setEventListStringData(events);
        return events;
    }

    @Override
    public Event getEventById(Integer eventId) throws Exception {
        if (null == eventId) {
            throw new InvalidIdException(EVENT_ID_INVALID);
        }
        Event event = eventRepository.getEventById(eventId);
        event = this.setEventStringData(event);
        return event;
    }

    @Override
    public Event createEvent(Event event) throws Exception {
        if (null == event || null != event.getId()) {
            throw new InvalidIdException(EVENT_ID_NOT_REQUIRED);
        }
        event = this.setEventCatalogData(event);
        event = eventRepository.save(event);
        event = this.setEventStringData(event);
        return event;
    }

    @Override
    public Event updateEvent(Integer eventId, Event event) throws Exception {
        if (!this.isEventIdValid(eventId, event)) {
            throw new InvalidIdException(EVENT_ID_INVALID);
        }
        event = this.setEventCatalogData(event);
        event = eventRepository.save(event);
        event = this.setEventStringData(event);
        return event;
    }

    @Override
    public void deleteEvent(Integer eventId) throws Exception {
        if (null == eventId) {
            throw new InvalidIdException(EVENT_ID_INVALID);
        }
        Event event = this.getEventById(eventId);
        event.setEnabled(false);
        eventRepository.save(event);
    }

    private List<Event> setEventListStringData(List<Event> events) {
        events.forEach((event) -> {
            event = this.setEventStringData(event);
        });
        return events;
    }

    private Event setEventCatalogData(Event event)
            throws InvalidCatalogDataException {
        String type = event.getType();
        String category = event.getCategory();
        Integer eventCategoryId;
        Integer eventTypeId;
        eventCategoryId = this.getIdCatalog(category, CATALOG_TYPE_CATEGORY);
        eventTypeId = this.getIdCatalog(type, CATALOG_TYPE_EVENT);
        event.setEventType(eventTypeId);
        event.setCategoryId(eventCategoryId);
        return event;
    }

    private Integer getIdCatalog(String catalogName, String catalogType)
            throws InvalidCatalogDataException {
        String errMsg = catalogType + " is not valid";
        if (null == catalogName) {
            throw new InvalidCatalogDataException(errMsg);
        }
        Integer catalogId = catalogRepository
                .getCatalogIdByNameAndType(catalogName, catalogType);
        if (null == catalogId) {
            throw new InvalidCatalogDataException(errMsg);
        }
        return catalogId;
    }

    private Event setEventStringData(Event event) {
        Integer eventTypeId = event.getEventType();
        Integer eventCategoryId = event.getCategoryId();
        String eventName = catalogRepository.getCatalogId(eventTypeId);
        String categoryName = catalogRepository.getCatalogId(eventCategoryId);
        event.setType(eventName);
        event.setCategory(categoryName);
        return event;
    }

    private boolean isEventIdValid(Integer eventId, Event event) {
        return null != eventId
                && null != event
                && null != event.getId()
                && Objects.equals(eventId, event.getId());
    }
}
