package inheritance;

public class Review extends Place {
    private String body;
    private String author;
    private int reviewStars;
    Place place;
    private User user = null;


    // for review associated with place
    public Review(Place place, String body, String author, int reviewStars) {
        super(place.getName(), place.getRating());
        this.place = place;
        this.body = body;
        this.author = author;
        this.reviewStars = reviewStars;
        this.user = new User(author);
        place.addReview(this);
    }

    // for review that does not have place
    public Review(String body, String author, int reviewStars) {
        super("", 5);
        this.body = body;
        this.author = author;
        this.place = null;
        this.reviewStars = reviewStars;
        this.user = new User(author);
    }

    // with user and place
    public Review(Place place, String body, User user, int reviewStars) {
        super(place.getName(), place.getRating());
        this.place = place;
        this.body = body;
        this.author = user.getName();
        this.reviewStars = reviewStars;
        this.user = user;
        place.addReview(this);
    }

    // for review associated with theater and with movie name
    public Review(Theater theater, String body, String author, int reviewStars, String movieName) {
        super(theater.getName(), theater.getRating());
        this.place = theater;
        this.body = body;
        this.author = author;
        this.reviewStars = reviewStars;
        this.user = new User(author);
        theater.addReview(this, movieName);
    }

    // with user and theater
    public Review(Theater theater, String body, User user, int reviewStars, String movieName) {
        super(theater.getName(), theater.getRating());
        this.place = theater;
        this.body = body;
        this.author = user.getName();
        this.reviewStars = reviewStars;
        this.user = user;
        theater.addReview(this, movieName);


    }


    public User getUser() {
        return user;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReviewStars() {
        return reviewStars;
    }

    public void setReviewStars(int reviewStars) {
        this.reviewStars = reviewStars;
    }


    @Override
    public String toString() {
        return "\nReview{" +
                "body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", reviewStars='" + reviewStars +
                "'}";
    }

    public void updateStars(int star) {
        if (star >= 0 && star <= 5) {
            this.setReviewStars(star);
            place.updateReview(this);
        } else {
            System.out.println("Please enter number {0,5}");
        }

    }
}
