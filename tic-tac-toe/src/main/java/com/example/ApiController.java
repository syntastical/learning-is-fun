package com.example;

/*
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api1")
public class ApiController {
    ApiResponse data = new ApiResponse();

    @Get
    // @Secured({"admin"})
    public ApiResponse getHello() {
        return new ApiResponse();
    }

    @Post
    public void updateData(@Body ApiResponse apiResponse) {
        data = apiResponse;
    }

    @Get("login:{username}")
    public String getCredentials(@Body ApiResponse apiResponse, String username) {
        data = apiResponse;
        return username; + "/n" + "Password:  " + password;
    }

    @Get("/npantino")
    public String username(String username) {
        return username;
    }

    @Get("/path/{id}")
    public int pathParam(int id) {
        return id;
    }
}
*/