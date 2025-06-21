package com.ticketlite.demo.service;


import com.ticketlite.demo.model.EventsEntity;
import com.ticketlite.demo.model.repository.EventsRepository;
import com.ticketlite.demo.structure.exception.ConflictException;
import com.ticketlite.demo.structure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventsService {

    //Atributos

    private EventsRepository eventsRepository;
    //Importante para conectar el repository
    @Autowired
    //Constructor
    public EventsService(EventsRepository eventsRepository){

        this.eventsRepository = eventsRepository;

    }

    //Metodos
    //Get All
    public List<EventsEntity> getAllEvents(){
        List<EventsEntity> events = eventsRepository.findAll();

        return events;
    }
    //Get Only
    public Optional<EventsEntity> getById(Long idEvents){

        Optional<EventsEntity> event = eventsRepository.findById(idEvents);

        return event;
    }
    //Post

    public String saveEvent(EventsEntity event) throws ConflictException {
        if (eventsRepository.existsById(event.getIdEvents())){
            throw new ConflictException("El Evento ya fue creado");
        }
        //Crear un nuevo objeto "newEvent"
        EventsEntity newEvent = new EventsEntity();

        newEvent.setName(event.getName());
        newEvent.setDescription(event.getDescription());
        newEvent.setStartDate(event.getStartDate());
        newEvent.setEndDate(event.getEndDate());
        newEvent.setLocation(event.getLocation());
        newEvent.setCategory(event.getCategory());
        newEvent.setImageUrl(event.getImageUrl());
        newEvent.setStatus(event.isStatus());

        eventsRepository.save(newEvent);
        return "Se creo correctamente el evento: " + event.getName();
    }
    //PUT

    public void editEvent(EventsEntity event) throws NotFoundException {
        try {

            EventsEntity editEvent = eventsRepository.findById(event.getIdEvents()).orElseThrow(() -> new NotFoundException("Propietario no encontrado"));

            editEvent.setIdEvents(event.getIdEvents());
            editEvent.setName(event.getName());
            editEvent.setDescription(event.getDescription());
            editEvent.setStartDate(event.getStartDate());
            editEvent.setEndDate(event.getEndDate());
            editEvent.setLocation(event.getLocation());
            editEvent.setCategory(event.getCategory());
            editEvent.setImageUrl(event.getImageUrl());
            editEvent.setStatus(event.isStatus());

            eventsRepository.save(editEvent);

        }catch (NotFoundException e){
            throw e;
        }catch (Exception e){
            throw new RuntimeException("Error al actualizar el evento: " + e.getMessage(), e);
        }
    }
    //DELETE

    public void deleteEvent (Long idEvents){
        if (eventsRepository.existsById(idEvents)){
            eventsRepository.deleteById(idEvents);
        }else {
            throw new RuntimeException("Evento no encontrado por ID: " + idEvents);
        }
    }
}
