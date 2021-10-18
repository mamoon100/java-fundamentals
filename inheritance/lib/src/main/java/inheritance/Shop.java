package inheritance;

public class Shop extends Place {
    String description;
    String price;

    public Shop(String name, String description, float rating, String price) {
        super(name, rating);
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name= '" + this.getName() + "'" +
                " description='" + description + '\'' +
                " rating='" + this.getRating() + " Out of " + this.getReviews().size() + " Reviews' " +
                ", price='" + this.price + '\'' +
                '}';
    }
}
