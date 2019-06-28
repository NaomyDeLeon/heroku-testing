/*
 */
package avanxo.heroku.technical.test.data.repositories;

import avanxo.heroku.technical.test.data.structures.Event;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pytagoraz
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query(
            nativeQuery = true,
            value = "Select * From events where enabled='true' "
                    + "order by creation_date desc")
    List<Event> getEventsOrderedByCreationDateDesc();

    @Query(
            nativeQuery = true,
            value = "Select *  From events where id=?1 and enabled='true'")
    Event getEventById(Integer eventId);

    @Query(
            nativeQuery = true,
            value = "Select * From events where category=?1 and enabled='true'")
    List<Event> getEventByCategory(Integer categoryId);

}
