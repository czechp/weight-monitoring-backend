package app.web.productionLine.adapter.rest;

import app.web.productionLine.application.dto.ProductionLineCreateDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@ActiveProfiles({"test"})
@AutoConfigureMockMvc
class ProductionLineRestAdapterCreateTest {
    private static final String URL = "/api/production-lines";

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "ADMIN")
    void createProductionLineTest() throws Exception {
        //given
        final var lineName = "New line name";
        final var createDto = new ProductionLineCreateDto(lineName);
        final var requestBody = objectMapper.writeValueAsString(createDto);
        final var requestBuilder = MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }


    @Test
    @WithMockUser(roles = "USER")
    void createProductionLineNotEnoughPrivilegesTest() throws Exception {
        //given
        final var lineName = "Some line name";
        final var createDto = new ProductionLineCreateDto(lineName);
        final var requestBody = objectMapper.writeValueAsString(createDto);
        final var requestBuilder = MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }


    @Test
    @WithMockUser(roles = "USER")
    void createProductionLineNameAlreadyExistsTest() throws Exception {
        //given
        final var lineName = "L-01";
        final var createDto = new ProductionLineCreateDto(lineName);
        final var requestBody = objectMapper.writeValueAsString(createDto);
        final var requestBuilder = MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }


}
