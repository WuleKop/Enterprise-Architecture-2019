package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class Book extends  Product {
    private String title;

    public Book(String name, String description, String title) {
        super(name, description);
        this.title = title;
    }
}
