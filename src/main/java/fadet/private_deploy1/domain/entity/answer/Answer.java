package fadet.private_deploy1.domain.entity.answer;

import fadet.private_deploy1.ApiKey;
import fadet.private_deploy1.domain.entity.question.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Getter
@Entity
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long id;
    @Column(nullable = false, length = 20000)
    private String answerContent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer(String answerContent) {
        this.answerContent = answerContent;
    }

    /* 생성 메서드
         */

    public static Answer createAnswer(Question question, String answerContent){
        Answer answer = new Answer(answerContent);
        answer.setQuestion(question);
        return answer;

    }

    /* 연관관계메서드
         */
    public void setQuestion(Question question) {
        this.question = question;
        question.setAnswer(this);
    }



}


