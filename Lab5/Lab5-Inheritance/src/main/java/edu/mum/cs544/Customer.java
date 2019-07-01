package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Order> orderList=new ArrayList<>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public boolean addOrder(Order order) {
        if(orderList.add(order)) {
            order.setCustomer(this);
            return true;
        }
        return false;
    }
    public boolean removeOrder(Order order) {
        if(orderList.remove(order)) {
            order.setCustomer(null);
            return true;
        }
        return false;
    }
}
