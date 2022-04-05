package com.joshuamatos.Crud2.employees;

import com.sun.istack.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    MockMvc mvc;

//    @Test
//    void createAEmployeeWithJSONRequest() throws  Exception{
//        this.mvc.perform(post("/employees")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("name:", )
//        );
//    }

    @Test
    void returnASingleEmployeeByPathVarId() {
    }

    @Test
    void patchASingleEmployeeByPathVarId() {
    }

    @Test
    void deleteASingleEmployeeById() {
    }

    @Test
    void returnAllEmployeesUsingList() {
    }

    private @NotNull
    String getJSON() throws Exception {
        URL url = this.getClass().getResource("/request.json");
        assert url != null;
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}