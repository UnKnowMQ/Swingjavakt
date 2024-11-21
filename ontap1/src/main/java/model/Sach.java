/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Sach  implements Serializable{
    private static final long serialVersionUID = 1L; // Khuyến nghị khai báo
    
    private String id;
    private String bookName;
    private String bookType;
    private long bookQuantity;
    private String language;
    private String bookAuthor;
    private int yearRelease;
    private String bookSummarize;

    public Sach() {
    }

    public Sach(String id, String bookName, String bookType, long bookQuantity, String language, String bookAuthor, int yearRelease, String bookSummarize) {
        this.id = id;
        this.bookName = bookName;
        this.bookType = bookType;
        this.bookQuantity = bookQuantity;
        this.language = language;
        this.bookAuthor = bookAuthor;
        this.yearRelease = yearRelease;
        this.bookSummarize = bookSummarize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public long getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(long bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public String getBookSummarize() {
        return bookSummarize;
    }

    public void setBookSummarize(String bookSummarize) {
        this.bookSummarize = bookSummarize;
    }
    
    
    
}
