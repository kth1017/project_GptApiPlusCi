package fadet.private_deploy1.service;

import fadet.private_deploy1.domain.papagoRequester.PapagoRequesterRepository;
import fadet.private_deploy1.domain.papagoRequester.PapagoRequesterRepositoryImpl;
import fadet.private_deploy1.web.dto.requestDto.RQ2RequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Transactional
@SpringBootTest
class RecomQServiceTest {
    @Autowired
    RecomQService service;

    @Test
    void 추천질문반환(){
        //given
        //when
        String[] list = service.getRecomQ();
        //then
        assertThat(list[0]).isEqualTo("java");
    }



    @Test
    void 추천질문소분류반환_성공(){
        //given
        RQ2RequestDto dto = new RQ2RequestDto("java");
        //when
        String[] details = service.getRecomQ2(dto);
        //then
        assertThat(details[0]).isEqualTo("jdk");

    }

    @Test
    void 추천질문소분류반환_잘못된카테고리_실패(){
        //given
        RQ2RequestDto dto = new RQ2RequestDto("C++");
        //when
        String[] details = service.getRecomQ2(dto);
        //then
        assertThat(details[0]).isEqualTo(" ");

    }

}