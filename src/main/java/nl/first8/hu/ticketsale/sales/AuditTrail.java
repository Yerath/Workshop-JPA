package nl.first8.hu.ticketsale.sales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.first8.hu.ticketsale.registration.Account;
import nl.first8.hu.ticketsale.venue.Concert;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yerath on 01/06/2017.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditTrail implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private long sale_id;

    private long account_id;

    public AuditTrail(long id){
        this.id = id;
    }

}
