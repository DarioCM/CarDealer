package com.example.dealershop.controller;

import com.example.dealershop.models.entity.Purchase;
import com.example.dealershop.models.service.IPurchaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PurchaseRestControllerTest {

    @Mock
    private IPurchaseService purchaseService;

    @InjectMocks
    private PurchaseRestController purchaseRestController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(purchaseRestController).build();
    }

    @Test
    @DisplayName("Should create a purchase when valid request is made")
    public void shouldCreatePurchaseWhenValidRequestIsMade() throws Exception {
        when(purchaseService.addPurchase(any(Purchase.class))).thenReturn(new Purchase());

        mockMvc.perform(post("/v1/api/purchase")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"car\": {\"id\": 1}, \"purchaseDate\": \"2022-01-01\", \"finalPrice\": 10000.0}"))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Should return bad request when invalid request is made")
    public void shouldReturnBadRequestWhenInvalidRequestIsMade() throws Exception {
        mockMvc.perform(post("/v1/api/purchase")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"car\": {\"id\": 1}, \"purchaseDate\": \"2022-01-01\"}")) // missing finalPrice
                .andExpect(status().isBadRequest());
    }
}