package app.web.weightModule.adapter.rest;

import app.web.exception.NotFoundException;
import app.web.weightModule.application.port.query.WeightModulePortFindById;
import org.junit.jupiter.api.DisplayName;
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

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@ActiveProfiles({"test"})
@AutoConfigureMockMvc
class WeightModuleRestAdapterDeleteTest {
    private static final String URL = "/api/weight-modules";
    @Autowired
    MockMvc mockMvc;

    @Autowired
    WeightModulePortFindById portFindById;

    @Test
    @WithMockUser(roles = {"ADMIN"})
    @DisplayName("Rest: Weight module remove")
    void removeWeightModule() throws Exception {
        //given
        final var weightModuleId = 1L;
        final var requestBuilder = MockMvcRequestBuilders.delete(URL + "/{id}", weightModuleId);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        assertThrows(NotFoundException.class, () -> portFindById.findByIdWeightModuleOrThrowException(weightModuleId));
    }
}
