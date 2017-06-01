package nl.first8.hu.ticketsale.search;

import nl.first8.hu.ticketsale.reporting.LocationReport;
import nl.first8.hu.ticketsale.venue.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by yerath on 01/06/2017.
 */
@Repository
public class SearchRepository {

    private final EntityManager entityManager;

    @Autowired
    public SearchRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Concert> findConcertByArtistName(String artist_name){
        String jpql = "SELECT concert FROM Concert concert WHERE concert.artist.name = :artist_name ";
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("artist_name", artist_name);
        return query.getResultList();
    }

    public List<Concert> findConcertByGenre(String genre){
        String jpql = "SELECT concert FROM Concert concert WHERE concert.artist.genre = :genre ";
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    public List<Concert> findConcertByMinDate(Date date){
        String jpql = "SELECT concert FROM Concert concert WHERE concert.date = :date ";
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    public List<Concert> findConcertByLocation(String location){
        String jpql = "SELECT concert FROM Concert concert WHERE concert.location.name = :location ";
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("location", location);
        return query.getResultList();
    }


}
