package nl.first8.hu.ticketsale.venue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yerath on 01/06/2017.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String genre;



    public Artist(String name, String genre){
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    @OneToMany(mappedBy = "artist")
    private List<Concert> concerts;
}
