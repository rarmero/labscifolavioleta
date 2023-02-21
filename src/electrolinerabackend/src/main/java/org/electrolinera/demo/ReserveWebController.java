package org.electrolinera.demo;

import org.electrolinera.model.Reservation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.electrolinera.manager.ReservationManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ReserveWebController {

    @RequestMapping(value="/reservations",params = {"datestart","dateend"})
    public List<Reservation> listReservationHandler(@RequestParam String datestart,@RequestParam String dateend) throws ParseException {

        ReservationManager reservationManager = new ReservationManager();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
        Date dateStartParsed = objSDF.parse(datestart);
        Date dateEndParsed = objSDF.parse(dateend);

        reservationManager.reservationList.add(new Reservation(12,11,objSDF.parse("22-05-2023"),objSDF.parse("23-05-2023"),false));
        reservationManager.reservationList.add(new Reservation(13,14,objSDF.parse("22-08-2023"),objSDF.parse("23-08-2023"),false));
        reservationManager.reservationList.add(new Reservation(13,14,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false));
        reservationManager.reservationList.add(new Reservation(13,15,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false));


        return reservationManager.GetAllReservationByDate(dateStartParsed,dateEndParsed);

    }

}
