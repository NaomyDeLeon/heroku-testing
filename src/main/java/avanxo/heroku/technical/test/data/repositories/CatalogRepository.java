/*
 */
package avanxo.heroku.technical.test.data.repositories;

import avanxo.heroku.technical.test.data.structures.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pytagoraz
 */
@Repository
public interface CatalogRepository extends JpaRepository<Event, Integer> {

    @Query(
            nativeQuery = true,
            value = "Select id  From catalogs Where name= ?1 and type= ?2")
    Integer getCatalogIdByNameAndType(String name, String type);
    
    @Query(
            nativeQuery = true,
            value = "Select name From catalogs Where id= ?1")
    String getCatalogId(Integer id);

}
