package ph.com.bpi.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    private static List<Movie> movieList = new ArrayList<>();

    public static void main(String[] args) {
        // intialize entityManager;
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

        // initialize movieRepository
        MovieRepository movieRepository = new MovieRepository(em);

        // Start server on port 4567 (default)
        port(4567);

        // add routes here

        Movie m1 = new Movie(
                301L,
                "Demon Slayer: Kimetsu no Yaiba – The Movie: Mugen Train",
                "Haruo Sotozaki",
                "2020-10-16");

        // 2) Jujutsu Kaisen 0
        Movie m2 = new Movie(
                302L,
                "Jujutsu Kaisen 0",
                "Sunghoo Park",
                "2021-12-24");

        Movie m3 = new Movie(
                103L,
                "Suzume",
                "Makoto Shinkai",
                "2022-11-11");

        // Get Profile List
        get("/movies", (req, res) -> {
            res.type("application/json");

            // return a map (A map is basically a JSON formatted object)

            Map<String, Object> response = new HashMap<>();
            response.put("status", "Success");
            response.put("data", movieRepository.findAll());

            return JsonUtil.toJson(response);
        });

        // Create Profile List
        post("/movies", (req, res) -> {
            Map<String, Object> response = new HashMap<String, Object>();
            res.type("application/json");
            
            Movie data = JsonUtil.fromJson(req.body(), Movie.class);
            
            em.getTransaction().begin();
            movieRepository.save(data);
            em.getTransaction().commit();
         
            response.put("status", "Success");
            response.put("data", movieRepository.findAll());

            return JsonUtil.toJson(response);
        });
    }

}
