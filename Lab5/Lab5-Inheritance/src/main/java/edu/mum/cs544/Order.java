package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue
    private Long orderId;
    private LocalDate date;
    @ManyToOne
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Order_Id")
    private List<OrderLine> orderLineList=new ArrayList<>();

    public Order(LocalDate date) {
        this.date = date;
    }

    public void addOrderLine(OrderLine orderLine) {
        orderLineList.add(orderLine);
    }
    public void removeOrderLine(OrderLine orderLine) {
        orderLineList.remove(orderLine);
    }
}
