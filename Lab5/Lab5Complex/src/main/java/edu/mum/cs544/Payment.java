package edu.mum.cs544;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
public class Payment {
    @Column(name="PAYDATE")
    private String paydate;
    @Column(name="AMOUNT")
    private double amount;

    public Payment(String paydate, double amount) {
        this.paydate = paydate;
        this.amount = amount;
    }
}
