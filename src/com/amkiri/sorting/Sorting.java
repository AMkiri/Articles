package com.amkiri.sorting;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java sorting by Collection Api, autosorted datasets and Stream Api
 */
public class Sorting {
    public static void main(String[] args) {
        List<Book> books = DataGenerator.generateBookList();

        // Sorting via Collections API

        Collections.sort(books);
        DataGenerator.printBookList("Collections.sort:", books);

        Collections.sort(books, Collections.reverseOrder());
        DataGenerator.printBookList("Collections.sort reverse:", books);

        Collections.sort(books, Collections.reverseOrder((o1, o2) -> o1.comparePrice(o2.getPrice())));
        DataGenerator.printBookList("Comparator by price in reverse order:", books);

        Collections.sort(books, Comparator.comparing(Book::getAuthor));
        DataGenerator.printBookList("Comparator.comparing by Author:", books);

        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPublisher().compareTo(o2.getPublisher());
            }
        });
        DataGenerator.printBookList("new Comporator by Publisher", books);

        // Sorting via other data structures (TreeSet/TreeMap)

        SortedSet<Book> booksSet = new TreeSet<>((o1, o2) -> o1.comparePrice(o2.getPrice()));
        booksSet.addAll(books);
        DataGenerator.printBookList("TreeSet with Price Comparator:", new ArrayList<>(booksSet));

        // Sorting via StreamApi

        List<Book> sortedList = books.stream().sorted().collect(Collectors.toList());
        DataGenerator.printBookList("Stream with default sorting", sortedList);

        sortedList = books.parallelStream().sorted((o1, o2) -> o1.comparePrice(o2.getPrice())).collect(Collectors.toList());
        DataGenerator.printBookList("ParallelStream with comparator by price", sortedList);
    }
}
