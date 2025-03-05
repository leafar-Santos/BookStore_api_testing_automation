package utils.bookUtils;

import com.github.javafaker.Faker;

public class BookDataCreator {

    static Faker faker = new Faker();

    public static String validBookTitle = faker.lorem().fixedString(50);
    public static String invalidBookTitle = faker.lorem().fixedString(201);

    public static String validBookAuthorName = faker.lorem().characters(40);
    public static String invalidBookAuthorName = faker.lorem().characters(50);

    public static String validBookText = faker.lorem().characters(100);
    public static String invalidBookText = faker.lorem().characters(100);

    public static String updatedBookTitle = "Título atulizado!";
    public static String updatedBookAuthorName = "Nome do autor atualizado";
    public static String updatedBookText = "Texto atualizado!";

}
