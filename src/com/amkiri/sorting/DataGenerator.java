package com.amkiri.sorting;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DataGenerator {
    private String Author[] = {"","Фрай","Пушкин","Лермонтов","Азимов","Ремарк"};
    private String Title[] = {"","Три товарища","Сундук мертвеца","Демон","Сказки","Норби"};

    public static List<Book> generateBookList(){
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("Три товарища","Ремарк", Year.of(1991), "АСТ", "1", 176d));
        bookList.add(new Book("Сундук мертвеца","Фрай", Year.of(2017), "Питер", "2", 580d));
        bookList.add(new Book("Демон","Лермонтов", Year.of(1995), "Речь", "3", 185d));
        bookList.add(new Book("Сказки","Пушкин", Year.of(1985), "СССР", "4", 185d));
        bookList.add(new Book("Норби","Азимов", Year.of(1991), "АСТ", "5", 150d));

        return bookList;
    }

    public static void printBookList(String hint, List<Book> list){
        System.out.printf("\t");
        System.out.println(hint);
        for (Book book: list){
            System.out.printf("%-20s\t %-10s\t %5s, %4sг.\t\t %-7.2f\n",
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublisher(),
                    book.getYear().toString(),
                    book.getPrice());
        }
        System.out.printf("\n\n");
    }
}
