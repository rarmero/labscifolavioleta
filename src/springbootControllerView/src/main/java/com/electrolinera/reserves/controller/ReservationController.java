package com.electrolinera.reserves.controller;

import com.electrolinera.reserves.service.ReservationService;
import org.electrolinera.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;


@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/reservationnew")
    public String greetingForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("calledby","get");
        return "reservationAdd";
    }

    @RequestMapping(value = "/reservationAdd",method = RequestMethod.POST)
    public String reservationsubmit( @ModelAttribute Reservation reservation, Model model) throws ParseException {

      /*  model.addAttribute("reservation", reservation);

        model.addAttribute("calledby","post");

        return "reservationAdd";
      */

      reservationService.reservationAdd(reservation);
        return "redirect:reservation";

    }


    @GetMapping("/reservationFilterUser")
    public String reservationFormUser(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservationFilterbyUser";
}

    @GetMapping("/reservationFilterDate")
    public String reservationFormDate(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservationFilterbyDate";
    }

    @PostMapping("/reservationPost")
    public String reservationPost( @ModelAttribute Reservation reservation, Model model) {

       List<Reservation> reservationList =new ArrayList<Reservation>();
       reservationList.add(reservation);
       model.addAttribute("reservations",  reservationList);

       return "reservationList";
    }

    @RequestMapping(value = "/reservation",method = RequestMethod.GET)
    public String reservation( @ModelAttribute Reservation reservation, Model model){

        /*
        List<Reservation> reservationList =new ArrayList<Reservation>();
        reservationList.add(reservation);
        model.addAttribute("reservations",  reservationList);
*/
        model.addAttribute("reservations",  reservationService.getAllReservations());

        return "reservationList";
    }

}
