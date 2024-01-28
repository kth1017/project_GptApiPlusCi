package fadet.private_deploy1.web.dto.requestDto;

import fadet.private_deploy1.domain.papagoRequester.PapagoRequester;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TranslateKtoERequestDtoTest {
    @Test
    void Question도메인화() {
        //given
        TranslateKtoERequestDto dto = new TranslateKtoERequestDto("안녕하세요.");
        //when
        //then
        assertThat(dto.toDomain()).isInstanceOf(PapagoRequester.class);
    }

}