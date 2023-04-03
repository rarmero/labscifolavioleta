package com.example.demoH2.model;

import java.util.Date;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private Integer idReservation;
    private Integer idUser;
    private Integer idPointCharge;
    private Date dateStart;
    private Date dateEnd;
    private Boolean accepted;


    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Reservation)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Reservation c = (Reservation) o;

        return Integer.compare(idUser,c.idUser) == 0
                && Integer.compare(idPointCharge, c.idPointCharge) == 0
                && dateStart.compareTo(c.dateStart) == 0
                && dateEnd.compareTo(c.dateEnd) == 0
                && Boolean.compare(accepted,c.accepted) ==0;
    }

}