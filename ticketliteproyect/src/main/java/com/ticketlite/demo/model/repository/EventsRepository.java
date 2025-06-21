package com.ticketlite.demo.model.repository;

import com.ticketlite.demo.model.EventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventsRepository extends JpaRepository<EventsEntity,Long> {
    boolean existsById(Long id);
}
