/*
 */
package avanxo.heroku.technical.test.data.structures;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author pytagoraz
 */
@Getter
@Setter
@Entity(name = "events")
@Table(name = "events")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Event implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 200)
    private String name;
    @JsonIgnore
    @Column(name = "category", length = 1)
    private Integer categoryId;
    @Column(name = "place", length = 200)
    private String place;
    @Column(name = "address", length = 200)
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date stardDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
    @JsonIgnore
    @Column(name = "event_type", length = 1)
    private Integer eventType;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;
    //another who columns here
    
    
    @Column(name = "enabled")
    private boolean enabled=true;
    @Transient
    private String category;
    @Transient
    private String type;

}
