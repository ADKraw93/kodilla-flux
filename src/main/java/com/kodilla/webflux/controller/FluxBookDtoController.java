package com.kodilla.webflux.controller;

import com.kodilla.webflux.Book;
import com.kodilla.webflux.BookDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FluxBookDtoController {

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<BookDto> getBooks() {

        BookDto b1 = new BookDto("Title1", "Author1", 2000);
        BookDto b2 = new BookDto("Title2", "Author2", 2001);
        Flux<BookDto> bookFlux = Flux.just(b1, b2);

        return bookFlux
                .delayElements(Duration.ofSeconds(2))
                .log();
    }
}
