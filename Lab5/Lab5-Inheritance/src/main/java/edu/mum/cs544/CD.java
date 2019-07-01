package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class CD extends Product {
    private String artist;

    public CD(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }
}
