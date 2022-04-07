package com.joshuamatos.Crud2.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class BookControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @Transactional
    @Rollback
    void createABookWithJSONRequest() throws Exception {
        this.mvc.perform(
                        post("/books")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\n" +
                                        "  \"name\": \"fake_data\",\n" +
                                        "  \"publishDate\": \"2017-07-05 22:53\"\n" +
                                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").value("fake_data"))
                .andExpect(jsonPath("$.publishDate").value("2017-07-05 22:53"));

    }

    @Test
    @Transactional
    @Rollback
    void returnASingleBookByPathVarId() throws Exception {
        this.mvc.perform(
                        get("/books/1")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Grav"));

    }

    @Test
    @Transactional
    @Rollback
    void patchASingleBooksByPathVarId() throws Exception {
        this.mvc.perform(
                        patch("/books/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\n" +
                                        "  \"name\": \"fake_data\",\n" +
                                        "  \"publishDate\": \"2017-07-05 22:53\"\n" +
                                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("fake_data"))
                .andExpect(jsonPath("$.publishDate").value("2017-07-05 22:53"));
    }

    @Test
    @Transactional
    @Rollback
    void deleteASingleBooksById() throws Exception {
        this.mvc.perform(
                        get("/books/1"))
                .andExpect(jsonPath("$").exists());
        this.mvc.perform(
                delete("/books/1").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        this.mvc.perform(
                        get("/books/1"))
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @Transactional
    @Rollback
    void returnAllBookUsingList() throws Exception {
        this.mvc.perform(get("/books"))
                .andExpect(jsonPath("$[0].name").value("Grav"))
                .andExpect(jsonPath("$[5].name").value("Axes"));
    }
}