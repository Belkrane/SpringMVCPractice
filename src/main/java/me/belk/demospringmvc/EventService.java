package me.belk.demospringmvc;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents(){
        Event event = Event.builder()
                .name("스프링 웹 MVC 스터디")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2019, 1, 1, 00, 00))
                .endDateTime(LocalDateTime.of(2019, 1, 31, 1, 1, 1))
                .build();

        Event event2 = Event.builder()
                .name("스프링 웹 MVC 스터디")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2019, 1, 1, 00, 00))
                .endDateTime(LocalDateTime.of(2019, 1, 31, 1, 1, 1))
                .build();

        return List.of(event, event2);

    }
}
