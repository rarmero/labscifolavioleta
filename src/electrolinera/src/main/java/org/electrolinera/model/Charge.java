
package org.electrolinera.model;

import java.util.Date;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Charge {
   private int idUser;
   private int idPointCharge;
   private Date dateStart;
   private Date dateEnd;
   private double chargingTime;
}
