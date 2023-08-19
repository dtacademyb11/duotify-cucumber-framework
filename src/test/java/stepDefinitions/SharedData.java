package stepDefinitions;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDateTime;
import java.util.List;

import static io.restassured.RestAssured.given;

@Data
public class SharedData {

    private String password;
    private String username;
    private String randomEmail;
    private String randomPlaylistName;
    private String playlistName;
    private String first;
    private String last;
    private String email;
    private String passMD5;
    private List<String> dbColumnNames;
    private List<String> emailsColumn;
    private List<String> genres;

    private Integer noOfplays;
    private String song;
    private String album;

    private LocalDateTime timestamp;


    private RequestSpecification requestSpecification = given();
    private Response response;






}
