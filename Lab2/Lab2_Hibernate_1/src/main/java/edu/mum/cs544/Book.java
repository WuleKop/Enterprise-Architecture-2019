package edu.mum.cs544;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String ISBN;
    private String author;
    private double price;
    @Temporal(TemporalType.DATE)
    private Date publish_date;

    public Book (String title,String ISBN,String author, double price, Date publish_date) {
        this.title=title;
        this.ISBN=ISBN;
        this.author=author;
        this.price=price;
        this.publish_date=publish_date;

    }
}
