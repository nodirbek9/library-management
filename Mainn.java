package Proekt_N1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Mainn {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println(
                            "1. Добавить книгу\n" +
                            "2. Удалить книгу\n" +
                            "3. Показать все книги\n" +
                            "4. Сохранить книги в файл\n" +
                            "5. Загрузить книги из файла\n" +
                            "6. Выйти\n" +
                            "Выберите действие: ");

            int choice = in.nextInt();
            in.nextLine(); //Очистка буфера

            switch (choice){
                case 1:
                    System.out.println("Введите название: ");
                    String title = in.nextLine();
                    System.out.println("Введите автора: ");
                    String author = in.nextLine();
                    System.out.println("Введите год издадие: ");
                    int year = in.nextInt();
                    in.nextLine();
                    library.addBook(new Book(title, author, year));
                    break;
                case 2:
                    System.out.println("Введите название книги для удаления: ");
                    String removeTitle = in.nextLine();
                    library.removeBook(removeTitle);
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Введите имя файла для Сахранения: ");
                    String saveFileName = in.nextLine();
                    library.saveToFile(saveFileName);
                    break;
                case 5:
                    System.out.println("Введите имя файла для Загрузки: ");
                    String loadFileName = in.nextLine();
                    library.loadFromFile(loadFileName);
                    break;
                case 6:
                    System.out.println("Выход из программы. ");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");

            }
        }
    }
}
