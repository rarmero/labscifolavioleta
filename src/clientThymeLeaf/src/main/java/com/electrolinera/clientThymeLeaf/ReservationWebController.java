package com.electrolinera.clientThymeLeaf;


import org.electrolinera.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/reservation")
public class ReservationWebController {
    @Autowired
    ReservationService reservationService;

    @RequestMapping("/reservations")
    public String reservations(Model containerToView,@RequestParam(name="datestart",defaultValue = "01/01/01") String dateStart,@RequestParam(value = "dateend",defaultValue="01/01/01") String dateEnd) {



        containerToView.addAttribute("reservations",
        reservationService.getAllReservations(dateStart,dateEnd)
        );

        return "listReservation";
    }


    @RequestMapping("/newReservation")
    public String newBook() {
        return "newReservation";
    }

    @RequestMapping("/insertReservation")
    public String insertReservation(Reservation reservation) {
        //
        reservationService.createReservation(reservation);
        return "redirect:reservations";
    }

    @RequestMapping("/deleteReservation")
    public String deleteReservation(@RequestParam("reservationIdFromView") Long id) {
        //
        reservationService.deleteReservationById(id);
        return "redirect:reservations";
    }

}
