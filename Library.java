package Proekt_N1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Library {
    public List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(String title){
        books.removeIf(book -> book.getTitle().equals(title));
    }
    public void displayBooks(){
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public void saveToFile(String fileName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Book book: books){
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getYear());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadFromFile(String fileName){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                String title = parts[0];
                String author = parts[1];
                int year = Integer.parseInt(parts[2]);
                books.add(new Book(title, author, year));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
