package fadet.private_deploy1.domain.deeplRequester;

public interface DeeplRequesterRepository {

    public void clear();
    public DeeplRequester saveKtoE(DeeplRequester newOne);
    public DeeplRequester saveEtoK(DeeplRequester newOne);
    public DeeplRequester findLastOne();
    public String getTranslatedText();
}
