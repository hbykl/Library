package com.husnaBiyikli.Library.Entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Boooks")
public class books {

    @Id
    @Column(name = "ISBN")
    @NotNull
    private Long isbn;

    @Column(name = "BookName")
    @NotNull(message = "Kitap adı boş bırakılamaz")
    private String bookName;

    @Column(name = "Subtitle")
    private String subtitle;

    @Column(name = "SeriesName")
    private String seriesName;

    @Column(name = "Author")
    @NotNull(message = "Yazar adı boş bırakılamaz")
    private String author;

    @Column(name = "PublishingHouse")
    @NotNull(message = "Yayın evi boş bırakılamaz")
    private String publishingHouse;

    @Column(name = "Description")
    private String description;

    @Column(name = "author_id")
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
    private authors authors;

    @Column(name = "house_id")
    private Long houseId;

    @ManyToOne
    @JoinColumn(name = "house_id", referencedColumnName = "id", insertable = false, updatable = false)
    private publishingHouses houses;

    public books() {
    }

    public books(Long isbn, String bookName, String subtitle, String seriesName, String author, String publishingHouse,
            String description) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.subtitle = subtitle;
        this.seriesName = seriesName;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.description = description;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public authors getAuthors() {
        return authors;
    }

    public void setAuthors(authors authors) {
        this.authors = authors;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public publishingHouses getHouses() {
        return houses;
    }

    public void setHouses(publishingHouses houses) {
        this.houses = houses;
    }

}
