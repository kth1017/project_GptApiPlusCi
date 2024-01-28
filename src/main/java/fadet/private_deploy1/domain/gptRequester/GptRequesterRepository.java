package fadet.private_deploy1.domain.gptRequester;

public interface GptRequesterRepository {

    public void clear();
    public void save(String answer);

    // 로직 수정 필요
    public String getAnswer(String question);

}
