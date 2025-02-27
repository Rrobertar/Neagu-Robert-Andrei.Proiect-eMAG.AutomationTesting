package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.*;

public class API {

    @Test
    public void testGetPosts() {

        //GET

        Response response = RestAssured.get("https://www.emag.ro/");

        assertEquals(200, response.getStatusCode());
        System.out.println("Status code is 200");

        assertTrue(response.getBody().asString().contains("title"));
        System.out.println("Contain title : eMAG.ro - Căutarea nu se oprește niciodată");

        assertEquals("text/html; charset=UTF-8", response.getHeader("Content-Type"));
        System.out.println("Content type is: text/html; charset=UTF-8 ");

        assertEquals("chunked", response.getHeader("Transfer-Encoding"));
        System.out.println("Transfer encoding: chunked");

        assertEquals("keep-alive",response.getHeader("Connection"));
        System.out.println("Connection: keep-alive");

    }
}