package fadet.private_deploy1.domain.entity.question;

import fadet.private_deploy1.domain.entity.answer.Answer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
// 연관관게메서드 작성으로 인해 setAnswer을 열어둠
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;
    @Column(nullable = false)
    private String questionContent;

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    private Answer answer;

    public Question(String questionContent) {
        this.questionContent = questionContent;
    }

    /*
    피 연관관계메서드
     */

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}


