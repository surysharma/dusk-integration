package com.hedgebenefits.web.controllers.flows;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelRoomReservationController {

    @RequestMapping("/hotel")
    public String view() {
        return "/hotel/search";
    }

}
