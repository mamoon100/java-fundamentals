package inheritance;

import java.util.HashMap;

public class Restaurant {
    private String name;
    private float stars;
    private String price;
    private HashMap<User, Review> reviews = new HashMap<>();
    private float originalStar;

    public Restaurant(String name, float stars, String price) {
        this.name = name;
        this.stars = stars;
        this.price = price;
        this.originalStar = stars;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(int stars) {
        if (stars >= 0 && stars <= 5) this.stars = stars;
        else System.out.println("The number of stars should be from 0 to 5");
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", stars= " + stars + " Out of " + this.reviews.size() + " Reviews " +
                ", price='" + price + '\'' +
                '}';
    }

    public HashMap<User, Review> getReviews() {
        return reviews;
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
        this.stars = sum / (this.reviews.size() + 1.0F);

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
        this.stars = sum / (this.reviews.size() + 1.0F);

    }
}
