package utils.dataUtils;

import com.github.javafaker.Faker;

public class CategoryDataCreator {

    static Faker faker = new Faker();

    public static String validCategoryName = faker.job().title();
    public static String invalidCategoryName = faker.lorem().fixedString(201);
    public static String invalidCategoryDescription = faker.lorem().characters(300);
    public static String validCategoryDescription = faker.lorem().characters(100);
    public static String updatedCategoryName = "Título atulizado!";
    public static String updatedCategoryDescription = "Descrição atulizada!";



}
