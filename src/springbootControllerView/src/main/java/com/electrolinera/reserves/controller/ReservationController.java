package com.electrolinera.reserves.controller;

import org.electrolinera.model.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;


@Controller
public class ReservationController {

    @GetMapping("/reservationnew")
    public String greetingForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("calledby","get");
        return "reservationAdd";
    }

    @RequestMapping(value = "/reservationAdd",method = RequestMethod.POST)
    public String reservationsubmit( @ModelAttribute Reservation reservation, Model model){

        reservation.setAccepted(true);

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
        Date dateStart = new Date();

        try {
            dateStart = objSDF.parse("20-08-2023");
        }
        catch(Exception e){

        }

        reservation.setDateStart(dateStart);

        model.addAttribute("reservation", reservation);
        model.addAttribute("calledby","post");

        return "reservationAdd";
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

    @RequestMapping(value = "/reservation",method = RequestMethod.POST)
    public String reservationSubmit( @ModelAttribute Reservation reservation, Model model){

        List<Reservation> reservationList =new ArrayList<Reservation>();
        reservationList.add(reservation);
        model.addAttribute("reservations",  reservationList);

        return "reservationList";
    }

}
