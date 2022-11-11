package pl.company.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.company.models.Authorization;

import java.io.File;
import java.io.IOException;

public class JsonParseService {
    ObjectMapper objectMapper = new ObjectMapper();
    Authorization auth;


    public String getAuthKey() throws IOException {

        auth = objectMapper.readValue(new File("src/main/resources/auth.json"), Authorization.class);
        return auth.getApi();
    }


}
