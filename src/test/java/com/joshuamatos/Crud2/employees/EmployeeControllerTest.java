package com.joshuamatos.Crud2.employees;

import com.sun.istack.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    MockMvc mvc;

    private @NotNull
    String getJSON() throws Exception {
        URL url = this.getClass().getResource("/request.json");
        assert url != null;
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

    @Test
    @Transactional
    @Rollback
    void createAEmployeeWithJSONRequest() throws Exception {
        this.mvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"id\": 31,\n" +
                                "  \"name\": \"fake_data\",\n" +
                                "  \"startDate\": \"2025-10-10 09:19\"\n" +
                                "}"))
                .andExpect(jsonPath("$.name").value("fake_data"))
                .andExpect(jsonPath("$.startDate").value("2025-10-10 09:19"));
    }

    @Test
    @Transactional
    @Rollback
    void testReturnASingleEmployeeByPathVarId() throws Exception {
        this.mvc.perform(get("/employees/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Josh"))
                .andExpect(jsonPath("$.startDate").value("2014-12-22 10:15"));

        this.mvc.perform(get("/employees/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").value("Josh")
                );
    }

    @Test
    @Transactional
    @Rollback
    void testPatchASingleEmployeeByPathVarId() throws Exception {
        this.mvc.perform(patch("/employees/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"name\": \"fake_data\",\n" +
                        "  \"startDate\": \"2025-10-10 09:19\"\n" +
                        "}"));

    }

    @Test
    void testDeleteASingleEmployeeById() throws Exception {
        this.mvc.perform(delete("/employees/1"))
                .andExpect(content().string("Employee deleted. Count:2"));
    }

    @Test
    void testReturnAllEmployeesUsingList() throws Exception {
        this.mvc.perform(get("/employees"))
                .andExpect(jsonPath("$[0].name").value("Josh"))
                .andExpect(jsonPath("$[1].name").value("Alice"));
    }
}