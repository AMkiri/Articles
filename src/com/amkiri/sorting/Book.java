package com.amkiri.sorting;

import java.time.Year;

/**
 * Keeps book information for shop
 */
public class Book implements Comparable<Book>{
    private String mTitle;
    private String mAuthor;
    private Year mYear;
    private String mPublisher;
    private double mPrice;
    private String mVendorCode;

    public Book(String title, String author, Year year, String publisher, String vendorCode, double price) {
        mTitle = title;
        mAuthor = author;
        mYear = year;
        mPublisher = publisher;
        mVendorCode = vendorCode;
        mPrice = price;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(int price) {
        mPrice = price;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public Year getYear() {
        return mYear;
    }

    public String getPublisher() {
        return mPublisher;
    }

    public String getVendorCode() {
        return mVendorCode;
    }

    @Override
    public int compareTo(Book o) {
        if (o == null) return Integer.MAX_VALUE;
        return mTitle.compareTo(o.getTitle());
    }

    /**
     * Compares book price with given one
     * @param price to compare with
     * @return 0 if equal, 1 if self price more then given, -1 otherwise
     */
    public int comparePrice(double price){
        if (price == mPrice) return 0;
        return (mPrice > price)? 1 : -1;
    }
}
