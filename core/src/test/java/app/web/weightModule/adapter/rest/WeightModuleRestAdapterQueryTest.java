package app.web.weightModule.adapter.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles({"test"})
class WeightModuleRestAdapterQueryTest {
    private static final String URL = "/api/weight-modules";

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser
    void findAllWeightModulesTest() throws Exception {
        //given
        final var requestBuilder = MockMvcRequestBuilders.get(URL);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    @Test
    @WithMockUser
    void findByIdWeightModule() throws Exception {
        //given
        final var id = 1L;
        final var requestBuilder = MockMvcRequestBuilders.get(URL + "/{id}", id);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is((int) id)));
    }

    @Test
    @WithMockUser
    void findByProductionLineIdTest() throws Exception {
        //given
        final var productionLineId = 1L;
        final var requestBuilder = MockMvcRequestBuilders.get(URL + "/production-line/{id}", productionLineId);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }
}
