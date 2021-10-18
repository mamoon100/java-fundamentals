package inheritance;

import java.util.HashMap;
import java.util.HashSet;


public class Theater extends Place {
    // set to prevent duplicates.
    HashSet<String> movieList = new HashSet<>();


    public Theater(String name, float rating) {
        super(name, rating);
    }

    public void addMovie(String movieName) {
        this.movieList.add(movieName);
    }

    public HashSet<String> getMovieList() {
        return movieList;
    }

    public void removeMovie(String movieName) {
        this.movieList.remove(movieName);
    }


    public void addReview(Review review, String movieName) {
        super.addReview(review);
        addMovie(movieName);
    }

    @Override
    public String toString() {
        return "Theater{" +
                "name ='" + this.getName() + "'" +
                // this rating for the whole theater as place not the movie
                " rating='" + this.getRating() + " Out of " + this.getReviews().size() + " Reviews' " +
                "movieList=" + movieList +
                '}';
    }
}
