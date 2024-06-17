package com.example.dealershop.controller;

import com.example.dealershop.models.entity.Car;
import com.example.dealershop.models.service.ICarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class CarRestControllerTest {
    @InjectMocks
    CarRestController carRestController;

    @Mock
    ICarService carService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(carRestController).build();
    }

    @Test
    public void testGetCars() throws Exception {
        Car car1 = new Car(1L, "Model1", "Brand1", 2020, 20000.0);
        Car car2 = new Car(2L, "Model2", "Brand2", 2021, 30000.0);
        List<Car> cars = Arrays.asList(car1, car2);

        when(carService.getCars()).thenReturn(cars);

        mockMvc.perform(get("/v1/api/cars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].model").value("Model1"))
                .andExpect(jsonPath("$[1].model").value("Model2"));
    }
}
