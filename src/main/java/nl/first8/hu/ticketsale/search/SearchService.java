package nl.first8.hu.ticketsale.search;

import nl.first8.hu.ticketsale.registration.RegistrationRepository;
import nl.first8.hu.ticketsale.sales.SalesRepository;
import nl.first8.hu.ticketsale.venue.Concert;
import nl.first8.hu.ticketsale.venue.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yerath on 01/06/2017.
 */
@Service
public class SearchService {
    private final RegistrationRepository registrationRepository;
    private final SalesRepository salesRepository;
    private final VenueRepository venueRepository;
    private final SearchRepository searchRepository;

    @Autowired
    public SearchService(RegistrationRepository registrationRepository, SalesRepository salesRepository, VenueRepository venueRepository, SearchRepository searchRepository) {
        this.registrationRepository = registrationRepository;
        this.salesRepository = salesRepository;
        this.venueRepository = venueRepository;
        this.searchRepository = searchRepository;
    }

    protected List<Concert> searchByArtist(String artist_name){
        return searchRepository.findConcertByArtistName(artist_name);
    }

    protected List<Concert> searchByGenre(String genre){
        return searchRepository.findConcertByGenre(genre);
    }

    protected List<Concert> searchByMinDate(Date date){
        return searchRepository.findConcertByMinDate(date);
    }

    protected List<Concert> searchByLocation(String location){
        return searchRepository.findConcertByLocation(location);
    }




}
