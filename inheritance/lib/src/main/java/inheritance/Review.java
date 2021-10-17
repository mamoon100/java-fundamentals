package inheritance;

public class Review extends Restaurant {
    private String body;
    private String author;
    private int reviewStars;
    private Restaurant res;
    private User user = null;


    // for review associated with restaurant
    public Review(Restaurant res, String body, String author, int reviewStars) {
        super(res.getName(), res.getStars(), res.getPrice());
        this.res = res;
        this.body = body;
        this.author = author;
        this.reviewStars = reviewStars;
        this.user = new User(author);
        res.addReview(this);
    }

    // for review that does not have restaurant
    public Review(String body, String author, int reviewStars) {
        super("", 5, "");
        this.body = body;
        this.author = author;
        this.reviewStars = reviewStars;
        this.user = new User(author);
    }

    public Review(Restaurant res, String body, User user, int reviewStars) {
        super(res.getName(), res.getStars(), res.getPrice());
        this.res = res;
        this.body = body;
        this.author = user.getName();
        this.reviewStars = reviewStars;
        this.user = user;

        res.addReview(this);


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
                ", reviewStars=" + reviewStars +
                '}';
    }

    public void updateStars(int star) {
        if (star >= 0 && star <= 5) {
            this.setReviewStars(star);
            res.updateReview(this);
        } else {
            System.out.println("Please enter number {0,5}");
        }

    }
}
