package fadet.private_deploy1.domain.gptRequester;

import fadet.private_deploy1.ApiKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Repository
public class GptRequesterRepositoryImpl implements GptRequesterRepository {

    private static Map<Long, GptRequester> store = new ConcurrentHashMap<>();
    private static long sequence = 1L;

    private final ApiKey apiKey;

    @Override
    public void clear() {
        if(!store.isEmpty()){
            store.clear();
            sequence = 1L;
        }
    }

    @Override
    public String getAnswer(String question) {
        GptRequester gptRequester = new GptRequester(question, apiKey);
        gptRequester.setId(sequence++);
        store.put(gptRequester.getId(), gptRequester);
        return gptRequester.getAnswer();
    }

    //테스트용
    @Override
    public void save(String answer){
        GptRequester onlyAnswer = new GptRequester(answer);
        onlyAnswer.setId(sequence++);
        store.put(onlyAnswer.getId(), onlyAnswer);
    }
}
