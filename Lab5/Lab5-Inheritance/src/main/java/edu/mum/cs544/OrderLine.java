package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private Long id;
    private Integer quantity;

    public OrderLine( Integer quantity) {
        this.quantity = quantity;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
}
