package fadet.private_deploy1.service;

import fadet.private_deploy1.domain.papagoRequester.PapagoRequesterRepository;
import fadet.private_deploy1.domain.papagoRequester.PapagoRequesterRepositoryImpl;
import fadet.private_deploy1.web.dto.requestDto.TranslateKtoERequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PapagoServiceTest {

    @Autowired PapagoService papagoService;

    @Test
    void KoToEn번역요청(){
        //given
        TranslateKtoERequestDto dto = new TranslateKtoERequestDto("안녕하세요.");

        //when
        String transedContent = papagoService.transKtoE(dto);

        //then
        assertThat(transedContent).contains("Hello.");
    }
}