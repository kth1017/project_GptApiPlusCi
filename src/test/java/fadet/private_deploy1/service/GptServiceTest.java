package fadet.private_deploy1.service;

import fadet.private_deploy1.domain.entity.question.QuestionRepository;
import fadet.private_deploy1.web.dto.requestDto.QuestionRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class GptServiceTest {
    @Autowired
    GptService service;
    @Test
    void 답변_성공() {
        //given
        QuestionRequestDto dto = new QuestionRequestDto("what is java?");
        //when
        String answerContent = service.getAnswerContent(dto);
        //then
        assertThat(answerContent).contains("Java is a");
    }

}