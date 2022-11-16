package app.web.weightModule.adapter.rest;

import app.web.utilities.tools.RandomValueGenerator;
import app.web.weightModule.adapter.rest.dto.WeightModuleLastRestAdapterUpdateDto;
import app.web.weightModule.application.dto.WeightModuleLastUpdateDto;
import app.web.weightModule.application.dto.WeightModuleUpdateDto;
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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
@ActiveProfiles({"test"})
@AutoConfigureMockMvc
class WeightModuleLastRestAdapterUpdateDataTest {
    private static final String URL = "/api/weight-modules-last/data/";
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Update data")
    @WithMockUser
    void updateLastModuleDataTest() throws Exception {
        //given
        final var moduleId = 1L;
        final var moduleDto = createModuleDto();
        final var lastModuleDto = createLastModuleDto();
        final WeightModuleLastRestAdapterUpdateDto moduleUpdateDto = new WeightModuleLastRestAdapterUpdateDto(moduleDto, lastModuleDto);
        final var requestBody = objectMapper.writeValueAsString(moduleUpdateDto);
        final var requestBuilder = MockMvcRequestBuilders.patch(URL + moduleId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);
        //when
        System.out.println("I'm here");
        System.out.println(requestBody);
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNoContent());

    }

    private static WeightModuleLastUpdateDto createLastModuleDto() {
        return new WeightModuleLastUpdateDto(
                RandomValueGenerator.randomInt(),
                RandomValueGenerator.randomFloat(),
                RandomValueGenerator.randomFloat(),
                RandomValueGenerator.randomInt(),
                RandomValueGenerator.randomInt(),
                RandomValueGenerator.randomFloat()
        );
    }

    private static WeightModuleUpdateDto createModuleDto() {
        return new WeightModuleUpdateDto(
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
    }
}
