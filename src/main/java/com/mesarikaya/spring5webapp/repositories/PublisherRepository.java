package com.mesarikaya.spring5webapp.repositories;

import com.mesarikaya.spring5webapp.entities.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
