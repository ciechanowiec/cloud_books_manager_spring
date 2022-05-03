package eu.ciechanowiec.books;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Herman Ciechanowiec
 */
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private double price;

    public String obtainFormattedPrice() {
        DecimalFormat priceFormatter = new DecimalFormat("#,##0.00");
        return "$" + priceFormatter.format(price);
    }

    static List<Book> generateSamples() {
        List<Book> samples = new ArrayList<>();
        samples.add(new Book("The World as Will and Representation", "Arthur Schopenhauer", 78.99));
        samples.add(new Book("Mathematical Principles of Natural Philosophy", "Isaac Newton", 54.29));
        samples.add(new Book("The Cosmic Connection", "Carl Sagan", 43.39));
        samples.add(new Book("The Count of Monte Cristo", "Alexandre Dumas", 13.99));
        samples.add(new Book("Dialogue Concerning the Two Chief World Systems", "Galileo Galilei", 350.00));
        samples.add(new Book("On the Revolutions of Heavenly Spheres", "Nicolaus Copernicus", 150.00));
        samples.add(new Book("Moral Letters to Lucilius", "Lucius Seneca", 63.29));
        samples.add(new Book("The Double Helix: A Personal Account of the Discovery of the Structure of DNA", "James Watson", 35.99));
        samples.add(new Book("Relativity: The Special and General Theory", "Albert Einstein", 39.99));
        samples.add(new Book("Faust", "Wolfgang Goethe", 67.19));
        return samples;
    }

    private Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
