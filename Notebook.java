public class Notebook {

    private String title;
    private String description;
    private double price;
    private String link;
    private String reviews;
    private String rating;

    public Notebook(String title, String description, double price, String link, String reviews, String rating) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.link = link;
        this.reviews = reviews;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", link='" + link + '\'' +
                ", reviews='" + reviews + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
