package fadet.private_deploy1.domain.papagoRequester;

public interface PapagoRequesterRepository {

    public void clear();
    public PapagoRequester saveKtoE(PapagoRequester newOne);
    public PapagoRequester saveEtoK(PapagoRequester newOne);
    public PapagoRequester findLastOne();
    public String getTranslatedText();
}
