package com.course.rest.web.controller;

import com.course.rest.services.BeerService;
import com.course.rest.web.model.BeerDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Mock
    BeerService beerService;

    @Test
    void getBeer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveBeer() throws Exception {
        BeerDTO beerDTO = BeerDTO.builder().build();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
                .content(beerDTOJson))
                .andExpect(status().isCreated());

    }

    @Test
    void handleUpdate() {
    }

    @Test
    void deleteBeer() {
    }
}