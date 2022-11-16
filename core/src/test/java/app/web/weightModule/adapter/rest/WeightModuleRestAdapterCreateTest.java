package app.web.weightModule.adapter.rest;

import app.web.utilities.tools.RandomValueGenerator;
import app.web.weightModule.application.dto.WeightModuleCreateDto;
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
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles({"test"})
class WeightModuleRestAdapterCreateTest {
    private static final String URL = "/api/weight-modules";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Weight module create")
    @WithMockUser(roles = {"ADMIN"})
    void createWeightModuleTest() throws Exception {
        //given
        final var productionLineId = 1L;
        final var weightModuleCreateDto = new WeightModuleCreateDto(productionLineId, 10);
        final var requestContent = objectMapper.writeValueAsString(weightModuleCreateDto);
        final var requestBuilder = MockMvcRequestBuilders.post(URL)
                .content(requestContent)
                .contentType(MediaType.APPLICATION_JSON);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }


    @Test
    @WithMockUser(roles = {"ADMIN"})
    @DisplayName("Weight module create - production line not exists")
    void createWeightModuleProductionLineNotFoundTest() throws Exception {
        //given
        final var productionLineId = Long.MAX_VALUE;
        final var weightModuleCreateDto = new WeightModuleCreateDto(productionLineId, RandomValueGenerator.randomInt());
        final var requestContent = objectMapper.writeValueAsString(weightModuleCreateDto);
        final var requestBuilder = MockMvcRequestBuilders.post(URL)
                .content(requestContent)
                .contentType(MediaType.APPLICATION_JSON);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @WithMockUser
    @DisplayName("Weight module create - only admin access")
    void createWeightModuleOnlyAdminTest() throws Exception {
        //given
        final var productionLineId = Long.MAX_VALUE;
        final var weightModuleCreateDto = new WeightModuleCreateDto(productionLineId, RandomValueGenerator.randomInt());
        final var requestContent = objectMapper.writeValueAsString(weightModuleCreateDto);
        final var requestBuilder = MockMvcRequestBuilders.post(URL)
                .content(requestContent)
                .contentType(MediaType.APPLICATION_JSON);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

}
