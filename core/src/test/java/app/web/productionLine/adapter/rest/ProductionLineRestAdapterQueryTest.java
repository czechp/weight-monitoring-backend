package app.web.productionLine.adapter.rest;

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

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles({"test"})
class ProductionLineRestAdapterQueryTest {
    private static final String URI = "/api/production-lines";

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser
    void findAllProductionLinesTest() throws Exception {
        //given
        final var requestBuilder = MockMvcRequestBuilders.get(URI);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
    }

    @Test
    @WithMockUser
    void findByIdProductionLineTest() throws Exception {
        //given
        final var requestBuilder = MockMvcRequestBuilders.get(URI + "/{id}", 1L);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser
    void findByIdProductionLineNotFoundTest() throws Exception {
        //given
        final var requestBuilder = MockMvcRequestBuilders.get(URI + "/{id}", Long.MAX_VALUE);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
