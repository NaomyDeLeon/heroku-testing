/*
 */
package avanxo.heroku.technical.test.data.structures;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author pytagoraz
 */
@Getter
@Setter
@Entity(name = "catalogs")
@Table(name = "catalogs")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Catalog implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 15)
    private String name;
    @Column(name = "type", length = 10)
    private String type;
}
