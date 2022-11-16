package app.web.weightModule.adapter.rest;

import app.web.exception.NotFoundException;
import app.web.weightModule.application.port.query.WeightModuleLastPortFindByIdOrThrow;
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
class WeightModuleLastRestAdapterDeleteTest {
    private static final String URL = "/api/weight-modules-last";
    @Autowired
    MockMvc mockMvc;

    @Autowired
    WeightModuleLastPortFindByIdOrThrow portFindByIdOrThrow;

    @Test
    @DisplayName("Delete weight module last by id")
    @WithMockUser(roles = "ADMIN")
    void deleteWeightModuleLastByIdTest() throws Exception {
        //given
        final var moduleId = 1L;
        final var requestBuilder = MockMvcRequestBuilders
                .delete(URL + "/" + moduleId);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        assertThrows(NotFoundException.class, () -> portFindByIdOrThrow.findByIdOrThrowException(moduleId));
    }


    @Test
    @DisplayName("Module not found")
    @WithMockUser(roles = "ADMIN")
    void deleteWeightModuleLastByIdModuleNotFoundTest() throws Exception {
        //given
        final var moduleId = Long.MAX_VALUE;
        final var requestBuilder = MockMvcRequestBuilders
                .delete(URL + "/" + moduleId);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    @Test
    @DisplayName("Not enough permission")
    @WithMockUser(roles = {"USER"})
    void deleteWeightModuleLastByIdNotEnoughPermissionTest() throws Exception {
        //given
        final var moduleId = Long.MAX_VALUE;
        final var requestBuilder = MockMvcRequestBuilders
                .delete(URL + "/" + moduleId);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }
}
