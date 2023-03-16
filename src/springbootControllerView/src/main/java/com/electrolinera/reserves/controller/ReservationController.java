package com.electrolinera.reserves.controller;

import com.electrolinera.reserves.service.ReservationService;
import com.electrolinera.reserves.service.ReservationServiceImpl;
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
    ReservationServiceImpl reservationService;

    @GetMapping("/reservation/reservationnew")
    public String greetingForm(Model model) {
        model.addAttribute("reservation", new Reservation());
       // model.addAttribute("calledby","get");
        return "reservation/reservationAdd";
    }

    @RequestMapping(value = "/reservation/reservationAdd",method = RequestMethod.POST)
    public String reservationsubmit( @ModelAttribute Reservation reservation, Model model) throws ParseException {

        reservationService.reservationAdd(reservation);
        return "redirect:reservation";

    }

    @RequestMapping(value ="/reservation/reservationUpdate")
    public String reservationUpdate(@RequestParam(name="reserveIdFromView") Integer id,
                                    Model model){

       Reservation reservationFound =reservationService.getReservationById(id);


        if (reservationFound != null){
            model.addAttribute("reserveIdFromView",id);
            model.addAttribute("reservation", reservationFound);
             model.addAttribute("message", "User  found");}
        else
            model.addAttribute("message", "User not found");


        return "reservation/reservationUpdate";
    }

    @PostMapping(value ="/reservation/reservationUpdate/{reserveIdFromView}")
    public String reservationUpdateSubmit(@PathVariable("reserveIdFromView") Integer id,Reservation reservation) {

       reservationService.reservationUpdate(id,reservation);

        return "redirect:/reservationList";
    }

    @GetMapping("/reservation/reservationFilterUser")
    public String reservationFormUser(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation/reservationFilterbyUser";
}

    @PostMapping("/reservation/reservationFilterUserPost")
    public  String reservationByUserId ( @ModelAttribute Reservation reservation, Model model){

    model.addAttribute("reservations", reservationService.getReservationsByIdUser(reservation.getIdUser()));
    return "reservation/reservationList";
}

    @GetMapping("/reservation/reservationFilterDate")
    public String reservationFormDate(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation/reservationFilterbyDate";
    }

    @PostMapping("/reservation/reservationPost")
    public String reservationPost( @ModelAttribute Reservation reservation, Model model) {

       List<Reservation> reservationList =new ArrayList<Reservation>();
       reservationList.add(reservation);
       model.addAttribute("reservations",  reservationList);

       return "reservation/reservationList";
    }

    @RequestMapping(value = "/reservation/reservation",method = RequestMethod.GET)
    public String reservation( @ModelAttribute Reservation reservation, Model model) {

        model.addAttribute("reservations",  reservationService.getAllReservations());

        return "reservation/reservationList";
    }

    @RequestMapping("/reservation/reservationDelete")
    private String reservationDelete(@RequestParam("reserveIdFromView") Integer idReserve){
        reservationService.reservationDeleteById(idReserve);

        return "reservation/reservationList";
    }

    @RequestMapping("/reservation/reservationDetail")
    public String reservationDetail(@RequestParam("reserveIdFromView") int reservationId,Model model){
        model.addAttribute("reserve",reservationService.reservationDetail(reservationId));


        return "reservation/reservationDetail";
    }


}
