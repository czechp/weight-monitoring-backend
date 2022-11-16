package app.web.weightModule.adapter.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@ActiveProfiles({"test"})
class WeightModuleLastEntityTableExists {

    @Autowired
    WeightModuleLastRepository repository;

    @Test
    @DisplayName("Table exists")
    void weightModuleLastEntityTableExists() {
        //given
        //when
        //then
        repository.count();
    }
}
