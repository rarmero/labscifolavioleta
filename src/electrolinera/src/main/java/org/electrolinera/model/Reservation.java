package org.electrolinera.model;

import java.util.Date;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
   private int idUser;
   private int idPointCharge;
   private Date dateStart;
   private Date dateEnd;
   private Boolean accepted;

}
