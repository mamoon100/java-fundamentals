package inheritance;

import java.util.HashMap;

abstract public class Place {
    private String name;
    private float rating;
    private HashMap<User, Review> reviews = new HashMap<>();
    private float originalStar;

    public Place(String name, float rating) {
        this.name = name;
        this.rating = rating;
        if (rating > 5 || rating < 0) this.rating = 5;
        this.originalStar = rating;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        if (this.rating >= 0 && this.rating <= 5) this.rating = rating;
        else System.out.println("The number of stars should be from 0 to 5");
    }

    public HashMap<User, Review> getReviews() {
        return reviews;
    }

    public void setReviews(HashMap<User, Review> reviews) {
        this.reviews = reviews;
    }

    public float getOriginalStar() {
        return originalStar;
    }

    public void addReview(Review review) {
        if (this.reviews.containsValue(review)) {
            System.out.println("This review is already there");
            return;
        } else if (this.reviews.containsKey(review.getUser())) {
            System.out.println("This user has already give a review");
            return;
        }
        this.reviews.put(review.getUser(), review);
        float sum = this.originalStar;
        for (Review r : this.reviews.values()) {
            sum += r.getReviewStars();
        }
        this.rating = sum / (this.reviews.size() + 1.0F);
    }

    public void updateReview(Review review) {
        if (!this.reviews.containsValue(review)) {
            System.out.println("please add the review first");
            return;
        } else if (!this.reviews.containsKey(review.getUser())) {
            System.out.println("please add the review first");
            return;
        }
        this.reviews.put(review.getUser(), review);
        float sum = this.originalStar;
        for (Review r : this.reviews.values()) {
            sum += r.getReviewStars();
        }
        this.rating = sum / (this.reviews.size() + 1.0F);

    }
}
