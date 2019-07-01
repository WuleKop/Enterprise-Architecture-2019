package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class DVD extends Product {
    private String genre;

    public DVD(String name, String description, String genre) {
        super(name, description);
        this.genre = genre;
    }
}
