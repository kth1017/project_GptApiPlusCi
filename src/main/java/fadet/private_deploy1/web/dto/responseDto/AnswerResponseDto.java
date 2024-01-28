package fadet.private_deploy1.web.dto.responseDto;

import fadet.private_deploy1.domain.entity.answer.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class AnswerResponseDto {
    private String answerContent;

    public AnswerResponseDto(Answer entity) {
        this.answerContent = entity.getAnswerContent();
    }


}
