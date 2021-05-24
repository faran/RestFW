package com.restapi.learn.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.restapi.learn.constants.EndPoints;
import com.restapi.learn.models.Person;
import com.restapi.learn.utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;

import java.lang.reflect.Type;
import java.util.List;

public class PersonalServiceHelper {

    private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
    private static final String PORT = ConfigManager.getInstance().getString("port");

    public PersonalServiceHelper(){
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }
    public List<Person> getAllPerson(){
        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get(EndPoints.GET_ALL_PERSONS)
                .andReturn();
        Type type = new TypeReference<List<Person>>(){}.getType();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK,"Not Ok");

        return response.as(type);
    }

    public Response createPerson(){
        Person person = new Person();
        person.setId(3);
        person.setFirstName("Maisha");
        person.setLastName("Ahmed");
        person.setPhoneNumbers("222-222-2222");
        person.setAddress("Ireland");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .body(person)
                .post(EndPoints.CREATE_PERSONS)
                .andReturn();

        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED, "Not Created");

        return response;
    }

    public Response updatePerson(Integer id){
        Person person = new Person();
        person.setLastName("update name");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .body(person)
                .patch(EndPoints.UPDATE_PERSONS)
                .andReturn();

        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK, "Not OK");

        return response;
    }

    public Response deletePerson(Integer id){
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .delete(EndPoints.DELETE_PERSONS)
                .andReturn();

        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK, "Not OK");

        return response;
    }
}
