package me.belk.demojsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EventController {

    @GetMapping("/events")
    public String getEvents(Model model){
        System.out.println("EventController.getEvents");

        Event event1 = new Event();
        event1.setName("MVC Study1");
        event1.setStart(LocalDateTime.of(2023, 6, 13, 9, 00));
        Event event2 = new Event();
        event2.setName("MVC Study2");
        event2.setStart(LocalDateTime.of(2023, 6, 24, 9, 00));

        List<Event> events = List.of(event1, event2);

        model.addAttribute("event", events);
        model.addAttribute("message", "Happy New Year");

        return "/events/list";
    }
}
