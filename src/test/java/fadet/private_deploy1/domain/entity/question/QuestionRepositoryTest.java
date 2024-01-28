package fadet.private_deploy1.domain.entity.question;

import fadet.private_deploy1.service.GptService;
import fadet.private_deploy1.web.Controller;
import fadet.private_deploy1.web.dto.requestDto.QuestionRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class QuestionRepositoryTest {
    @Autowired
    QuestionRepository repository;
    @Test
    void jqpl테스트_마지막저장된질문불러오기() {
        //h2 db를 사용해서 list를 불러오므로 변경 필요
        //given
        repository.save(new Question("질문1"));
        repository.save(new Question("질문2"));

        //when

        //then
        assertThat(repository.findLastOne().get(0).getQuestionContent()).isEqualTo("질문2");

    }

}