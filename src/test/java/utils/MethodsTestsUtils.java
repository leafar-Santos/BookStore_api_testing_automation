package utils;

import entities.BookEntity;
import entities.CategoryEntity;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class MethodsTestsUtils{

    public static int getArraySizeFromEndpoint(String endpoint) {
        Response response = given()
                .when()
                .get(endpoint)
                .then()
                .extract().response();
        return response.jsonPath().getList("$").size();
    }

    public static int inexistentCategory(){
        return  getArraySizeFromEndpoint("/categories")+1;
    }

    public static int existentCategory(){
        return  getLastIdFromEndpoint("/categories");
    }

    public static void main(String[] args) {
        System.out.println(existentCategory());
    }



    public static int getLastIdFromEndpoint(String endpoint) {
        Response response = given()
                .when()
                .get(endpoint)
                .then()
                .extract().response();
        int lastIndex = response.jsonPath().getList("$").size()-1;
        return response.jsonPath().getInt("[" + lastIndex + "].id");

    }


    public static int inexistentBook(){
        return  getLastIdFromEndpoint("/books?categoria="+existentCategory())+1;
    }



    public static int existentBook(){
        return  getLastIdFromEndpoint("/books?categoria="+existentCategory());
    }





    public static void createNewCategory(){
        CategoryEntity category = new CategoryEntity();
        category.setNome("Minha categoria de teste");
        category.setDescricao("Minha descrição de teste");

        given()
                .when()
                .header("Content-Type", "application/json")
                .body(category)
                .post("/categories/create")
                .then()
                .statusCode(201);

    }

    public static void createNewBook(){
        BookEntity book = new BookEntity();
        book.setTitulo("Meu livro de teste");
        book.setNomeAutor("Minha descrição de teste");
        book.setTexto("huauhahuauhahuhahauhahuhuahuahu");

        given()
                .when()
                .header("Content-Type", "application/json")
                .body(book)
                .post("books/create?categoria="+existentCategory())
                .then()
                .statusCode(201);
    }

}
