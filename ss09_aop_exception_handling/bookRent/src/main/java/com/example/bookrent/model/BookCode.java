package com.example.bookrent.model;

import javax.persistence.*;

@Entity
public class BookCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeId;
    private int code;

    private int status;
    private int rentingAmount;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public BookCode() {
    }

    public BookCode(int codeId, int code, int status, int rentingAmount, Book book) {
        this.codeId = codeId;
        this.code = code;
        this.status = 0;
        this.rentingAmount = rentingAmount;
        this.book = book;
    }

    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int id) {
        this.codeId = id;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public int getRentingAmount() {
        return rentingAmount;
    }

    public void setRentingAmount(int rentingAmount) {
        this.rentingAmount = rentingAmount;
    }
}
