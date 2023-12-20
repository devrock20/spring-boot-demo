package com.devsat.lili.learningspring.webservice;

import com.devsat.lili.learningspring.business.ReservationService;
import com.devsat.lili.learningspring.business.RoomReservation;
import com.devsat.lili.learningspring.data.Guest;
import com.devsat.lili.learningspring.data.Room;
import com.devsat.lili.learningspring.util.DateUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebServiceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebServiceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false)String dateString){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);

    }
    @RequestMapping(path = "/guests", method = RequestMethod.GET)
    public List<Guest> getGuestList(){
        return this.reservationService.getGuestList();
    }

    @RequestMapping(path = "/guests", method = RequestMethod.POST)
    public void addNewGuest(@RequestBody Guest guest){
        this.reservationService.addNewGuest(guest);
    }

    @RequestMapping(path = "/rooms", method = RequestMethod.GET)
    public List<Room> getRoomList(){
        return this.reservationService.getRooms();
    }

}
