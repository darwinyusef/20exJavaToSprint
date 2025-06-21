package com.ticketlite.demo.controller;

import com.ticketlite.demo.model.EventsEntity;
import com.ticketlite.demo.service.EventsService;
import com.ticketlite.demo.structure.exception.ConflictException;
import com.ticketlite.demo.structure.exception.NotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventsController {
    //Atributo
    private EventsService eventsService;

    //Constructor
    @Autowired
    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    //Metodos
    //GET ALL
    @GetMapping
    public List<EventsEntity> getAllEvents(){
        return eventsService.getAllEvents();
    }

    //GET UNIQUE GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<EventsEntity> getEventById(@PathVariable Long idEvents){
        Optional<EventsEntity> event = eventsService.getById(idEvents);
        return event.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //POST
    @PostMapping("/save")
    public ResponseEntity<String> saveEvent(@RequestBody EventsEntity event){
        try {
            String result = eventsService.saveEvent(event);
            return ResponseEntity.ok(result);
        }catch (ConflictException e){
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    //PUT
    @PutMapping
    public ResponseEntity<String>updateEvent(@PathVariable Long idEvents, @RequestBody EventsEntity event){
        try {
            event.setIdEvents(idEvents);
            eventsService.editEvent(event);

            return ResponseEntity.ok("Evento actualizado con exito.");
        }catch (NotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error interno al actualizar el evento");
        }
    }

    //DELETE
    @DeleteMapping("/{idEvents}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long idEvents){
        try {
            eventsService.deleteEvent(idEvents);

            return ResponseEntity.ok("Evento eliminado Correctamente.");
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
