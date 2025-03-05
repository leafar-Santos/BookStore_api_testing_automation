package Tests.category;
import core.BaseTeste;
import entities.CategoryEntity;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static utils.MethodsTestsUtils.*;
import static utils.dataUtils.CategoryDataCreator.*;
import static utils.dataUtils.CategoryDataValidation.descriptionResponseMessageError;
import static utils.dataUtils.CategoryDataValidation.nameResponseMessageError;


public class CategoryTest extends BaseTeste {

    @Test
    public void shouldFindCategoryByIdAndRetunrStatusCode200(){
        createNewCategory();
        given()
                .when()
                .log().all()
                .get("/categories/"+existentCategory())
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void shouldFindAllCategoriesRetunrStatusCode200(){
        createNewCategory();
        given()
                .when()
                .log().all()
                .get("/categories")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void shouldSearchForNonExistentCategotyAndReturnStatusCode404(){
         given()
                .when()
                .log().all()
                .get("/categories"+inexistentCategory())
                .then()
                .statusCode(404)
                .log().all();
    }

    @Test
    public void shouldRegisterCategoryAndReturnStatus201(){
        CategoryEntity category = new CategoryEntity();
        category.setNome(validCategoryName);
        category.setDescricao(validCategoryDescription);

        given()
                .when()
                .log().all()
                .body(category)
                .post("/categories/create")
                .then()
                .statusCode(201)
                .body("nome", is(notNullValue()))
                .body("descricao", is(notNullValue()))
                .log().all();
    }

    @Test
    public void shouldFailWhenCreatingCategoryWithInvalidDescriptionAndReturnStatus400(){
        CategoryEntity category = new CategoryEntity();
        category.setNome(validCategoryName);
        category.setDescricao(invalidCategoryDescription);

        given()
                .when()
                .log().all()
                .body(category)
                .post("/categories/create")
                .then()
                .statusCode(400)
                .body("erros[0].fieldName", is("descricao"))
                .body("erros[0].message", is(descriptionResponseMessageError))
                .log().all();
    }

    @Test
    public void shouldFailWhenCreatingCategoryWithInvaliNameAndReturnStatus400(){
        CategoryEntity category = new CategoryEntity();
        category.setNome(invalidCategoryName);
        category.setDescricao(validCategoryDescription);

        given()
                .when()
                .log().all()
                .body(category)
                .post("/categories/create")
                .then()
                .statusCode(400)
                .body("erros[0].fieldName", is("nome"))
                .body("erros[0].message", is(nameResponseMessageError))
                .log().all();
    }


    @Test
    public void shouldUpdateCategoryAndReturnStatus200(){
        CategoryEntity category = new CategoryEntity();
        category.setNome(updatedCategoryName);
        category.setDescricao(updatedCategoryDescription);
        createNewCategory();

        given()
                .when()
                .log().all()
                .body(category)
                .put("/categories/"+existentCategory())
                .then()
                .statusCode(200)
                .body("nome", is(notNullValue()))
                .body("descricao", is(notNullValue()))
                .log().all();
    }

    @Test
    public void shouldDeleteRegisteredCategoryAndReturnStatus200(){
        CategoryEntity category = new CategoryEntity();
        createNewCategory();

        given()
                .when()
                .log().all()
                .body(category)
                .delete("/categories/"+existentCategory())
                .then()
                .statusCode(204)
                .log().all();
    }

}
