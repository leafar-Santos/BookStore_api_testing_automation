package Tests.book;

import core.BaseTeste;
import entities.BookEntity;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static utils.MethodsTestsUtils.*;
import static utils.bookUtils.BookDataCreator.*;

public class BookTest extends BaseTeste {


    @Test
    public void shouldFindBookByIdAndRetunrStatusCode200(){
        createNewCategory();
        createNewBook();
        given()
                .when()
                .get("/books/"+existentBook())
                .then()
                .statusCode(200)
                .body("titulo", is(notNullValue()))
                .body("nomeAutor", is(notNullValue()))
                .body("texto", is(notNullValue()));
    }


    @Test
    public void shouldSearchForNonExistentBookAndReturnStatusCode404(){
        given()
                .when()
                .get("/books/"+inexistentBook())
                .then()
                .statusCode(404);
    }

    @Test
    public void shouldRegisterBookAndReturnStatus201(){
        createNewCategory();
        BookEntity book = new BookEntity();
        book.setTitulo(validBookTitle);
        book.setNomeAutor(invalidBookAuthorName);
        book.setTexto(validBookText);

        given()
                .when()
                .header("Content-Type", "application/json")
                .body(book)
                .post("books/create?categoria="+existentCategory())
                .then()
                .statusCode(201)
                .body("titulo", is(notNullValue()))
                .body("nomeAutor", is(notNullValue()))
                .body("texto", is(notNullValue()));
    }

    @Test
    public void shouldUpdateBookAndReturnStatus200(){
        createNewCategory();
        createNewBook();

        BookEntity book = new BookEntity();
        book.setTitulo(updatedBookTitle);
        book.setNomeAutor(updatedBookAuthorName);
        book.setTexto(updatedBookText);

        given()
                .when()
                .body(book)
                .patch(("/books/"+existentBook()))
                .then()
                .statusCode(200);
    }

    @Test
    public void shouldFailWhenUpdatingBookWithInvalidDataAndReturnStatus400(){
        createNewCategory();
        createNewBook();
        BookEntity book = new BookEntity();
        book.setTitulo(invalidBookTitle);
        book.setNomeAutor(invalidBookAuthorName);
        book.setTexto(invalidBookText);
        given()
                .when()
                .body(book)
                .patch(("/books/"+inexistentBook()))
                .then()
                .statusCode(400);
    }

    @Test
    public void shouldDeleteRegisteredBookAndReturnStatus200(){
        createNewCategory();
        createNewBook();

        BookEntity book = new BookEntity();
        book.setTitulo(validBookTitle);
        book.setNomeAutor(invalidBookAuthorName);
        book.setTexto(validBookText);
        given()
                .when()
                .body(book)
                .get("/books/"+existentBook())
                .then()
                .statusCode(200);
    }

    @Test
    public void shouldFailWhenDeletingNonExistentBookAndReturnStatus404(){
        createNewCategory();
        createNewBook();
        BookEntity book = new BookEntity();
        given()
                .when()
                .body(book)
                .delete(("/books/"+inexistentBook()))
                .then()
                .statusCode(404);
    }

}
