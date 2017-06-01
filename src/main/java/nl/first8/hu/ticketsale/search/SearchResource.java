package nl.first8.hu.ticketsale.search;


import nl.first8.hu.ticketsale.venue.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by yerath on 01/06/2017.
 */

@RestController
@RequestMapping("/search")
@Transactional

public class SearchResource {

    private final SearchService service;

    @Autowired
    public SearchResource(SearchService service) {
        this.service = service;
    }

    @PostMapping(path = "/artist")
    public ResponseEntity searchArtistByName(@RequestParam("artist_name") final String artist_name) {
        try {
            List<Concert> concerts = service.searchByArtist(artist_name);
            return ResponseEntity.ok(concerts);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping(path = "/genre")
    public ResponseEntity searchArtistByGenre(@RequestParam("genre") final String genre) {
        try {
            List<Concert> concerts = service.searchByGenre(genre);
            return ResponseEntity.ok(concerts);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping(path = "/date")
    public ResponseEntity searchArtistByDate(@RequestParam("date") final Date date) {
        try {
            List<Concert> concerts = service.searchByMinDate(date);
            return ResponseEntity.ok(concerts);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping(path = "/location")
    public ResponseEntity searchArtistByLocation(@RequestParam("location") final String location) {
        try {
            List<Concert> concerts = service.searchByLocation(location);
            return ResponseEntity.ok(concerts);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
