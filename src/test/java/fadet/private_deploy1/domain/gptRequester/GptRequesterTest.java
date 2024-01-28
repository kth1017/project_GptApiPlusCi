package fadet.private_deploy1.domain.gptRequester;

import fadet.private_deploy1.ApiKey;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GptRequesterTest {
    @Autowired
    ApiKey apiKey;

    @Test
    void 인코딩성공후필드값세팅() {
        //given
        //when
        GptRequester newOne = new GptRequester("what is java?", apiKey);
        //then
        assertThat(newOne.getQuestion()).isEqualTo("what is java?");
        assertThat(newOne.getAnswer()).contains("Java");
    }

}