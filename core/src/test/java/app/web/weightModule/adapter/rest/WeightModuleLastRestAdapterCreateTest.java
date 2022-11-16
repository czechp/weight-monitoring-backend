package app.web.weightModule.adapter.rest;

import app.web.utilities.tools.RandomValueGenerator;
import app.web.weightModule.application.dto.WeightModuleCreateDto;
import app.web.weightModule.application.port.query.WeightModuleLastPortFindAll;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
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
class WeightModuleLastRestAdapterCreateTest {
    private static final String URL = "/api/weight-modules-last";
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WeightModuleLastPortFindAll weightModuleLastPortFindAll;


    @Test
    @WithMockUser(roles = {"ADMIN"})
    @DisplayName("Create a new last weight module")
    void createNewLastWeightModuleTest() throws Exception {
        //given
        final var weightModuleLastCreateDto = new WeightModuleCreateDto(2L, 10);
        final var requestBody = objectMapper.writeValueAsString(weightModuleLastCreateDto);
        final var requestBuilder = MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    @DisplayName("Module already exists")
    void createNewLastWeightModuleAlreadyExistsTest() throws Exception {
        //given
        final var weightModuleLastCreateDto = new WeightModuleCreateDto(1L, RandomValueGenerator.randomInt());
        final var requestBody = objectMapper.writeValueAsString(weightModuleLastCreateDto);
        final var requestBuilder = MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    @Test
    @WithMockUser(roles = {"ADMIN"})
    @DisplayName("Module already exists")
    void createNewLastWeightModuleProductionLineDoesNotExistTest() throws Exception {
        //given
        final var weightModuleLastCreateDto = new WeightModuleCreateDto(Long.MAX_VALUE, RandomValueGenerator.randomInt());
        final var requestBody = objectMapper.writeValueAsString(weightModuleLastCreateDto);
        final var requestBuilder = MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
