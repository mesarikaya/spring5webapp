package com.mesarikaya.spring5webapp.bootstrap;

import com.mesarikaya.spring5webapp.entities.Author;
import com.mesarikaya.spring5webapp.entities.Book;
import com.mesarikaya.spring5webapp.entities.Publisher;
import com.mesarikaya.spring5webapp.repositories.AuthorRepository;
import com.mesarikaya.spring5webapp.repositories.BookRepository;
import com.mesarikaya.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        // Add publisher

        Publisher publisher = new Publisher();
        publisher.setName("Harper Collins");

        publisherRepository.save(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Worx");

        publisherRepository.save(publisher2);

        // Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Eric", "Evans");
        Book noEJB = new Book("J2EE development without EJB", "22344", publisher2);
        rod.getBooks().add(ddd);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("****The database actions are finalized!****");
    }
}
