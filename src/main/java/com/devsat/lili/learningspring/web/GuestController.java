package com.devsat.lili.learningspring.web;

import com.devsat.lili.learningspring.business.ReservationService;
import com.devsat.lili.learningspring.data.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {

    private final ReservationService reservationService;
    public GuestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String getGuestList(Model model){
        List<Guest> guestList = reservationService.getGuestList();
        model.addAttribute("guestList",guestList );
        return "guests";
    }


}
