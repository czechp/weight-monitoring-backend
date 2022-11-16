package app.web.weightModule.adapter.rest;

import app.web.utilities.tools.RandomValueGenerator;
import app.web.weightModule.application.dto.WeightModuleUpdateDto;
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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
@ActiveProfiles({"test"})
@AutoConfigureMockMvc
class WeightModuleRestAdapterUpdateDataTest {
    private static final String URL = "/api/weight-modules/data";

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @WithMockUser
    void updateWeightModuleDataTest() throws Exception {
        //given
        final var weightModuleId = 1L;
        final var weightModuleUpdateDto = new WeightModuleUpdateDto(
                RandomValueGenerator.randomFloat(),
                RandomValueGenerator.randomFloat(),
                RandomValueGenerator.randomInt(),
                RandomValueGenerator.randomFloat(),
                RandomValueGenerator.randomBoolean(),
                RandomValueGenerator.randomFloat(),
                RandomValueGenerator.randomLong(),
                RandomValueGenerator.randomFloat(),
                IntStream.range(0, 10)
                        .boxed()
                        .map(n -> n + 1)
                        .map(n -> new WeightModuleUpdateDto.DosingDeviceUpdateDto(n,0,0,0,0,0,0,0) )
                        .collect(Collectors.toList())
        );


        final var requestBody = objectMapper.writeValueAsString(weightModuleUpdateDto);
        final var requestBuilder = MockMvcRequestBuilders.patch(URL + "/{id}", weightModuleId)
                .content(requestBody)
                .contentType(MediaType.ALL.APPLICATION_JSON);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNoContent());


    }
}
