package edu.mum.cs544;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private String institution;
    private String type;
    private Integer number;

    private LocalDate date;
    @ManyToOne
    private Book book;
    public Reservation() {
    }

    public Reservation(String institution,String type, LocalDate date, Integer number) {
        this.institution=institution;
        this.type = type;
        this.date=date;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    public void addBook(Book book){
        this.book=book;
    }
    public Book getBook(){
        return this.book;
    }
}
