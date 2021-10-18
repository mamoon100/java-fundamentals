package inheritance;


public class Restaurant extends Place {
    private String price;

    public Restaurant(String name, float stars, String price) {
        super(name, stars);
        this.price = price;


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
                "name='" + this.getName() + '\'' +
                ", stars='" + this.getRating() + " Out of " + this.getReviews().size() + "' Reviews " +
                ", price='" + price + '\'' +
                '}';
    }

}
