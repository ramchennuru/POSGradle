package com.POSSystemGradle.POSSytemGradle.Price;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Price {
    @Id
    private int id;
    private int price;
    private Date startDate;
    private Date endDate;
    private int vatCode;
    private Currency currency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getVatCode() {
        return vatCode;
    }

    public void setVatCode(int vatCode) {
        this.vatCode = vatCode;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return id == price1.id && price == price1.price && vatCode == price1.vatCode && Objects.equals(startDate, price1.startDate) && Objects.equals(endDate, price1.endDate) && currency == price1.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, startDate, endDate, vatCode, currency);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", vatCode=" + vatCode +
                ", currency=" + currency +
                '}';
    }

    public Price(int id, int price, Date startDate, Date endDate, int vatCode, Currency currency) {
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vatCode = vatCode;
        this.currency = currency;
    }

    public Price() {
    }
}
