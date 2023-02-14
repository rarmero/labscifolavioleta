
package org.electrolinera.manager;

import org.electrolinera.model.Charge;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChargeManager {
    
    public Charge charge = new Charge();
    public List<Charge> chargeList = new ArrayList<>();

    public void AddCharge(int idUser,int idPointCharge, Date dateStart,Date dateEnd){
        charge.setIdUser(idUser);
        charge.setIdPointCharge(idPointCharge);
        charge.setDateStart(dateStart);
        charge.setDateEnd(dateEnd);
        // TODO: calculate time from dates
        charge.setChargingTime(0);
    }
    
    //TODO: check the charge doesn't exist
    public boolean ExistCharge(Charge charge)
    {
        return false;
    }
}
