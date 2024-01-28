package fadet.private_deploy1.service;
import fadet.private_deploy1.domain.papagoRequester.PapagoRequester;
import fadet.private_deploy1.domain.papagoRequester.PapagoRequesterRepository;
import fadet.private_deploy1.web.dto.requestDto.TranslateEtoKRequestDto;
import fadet.private_deploy1.web.dto.requestDto.TranslateKtoERequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PapagoService {
    private final PapagoRequesterRepository repository;


    public String transKtoE(TranslateKtoERequestDto dto) {
        PapagoRequester newOneKE = dto.toDomain();
        repository.saveKtoE(newOneKE);
        return repository.getTranslatedText();
    }

    public String transEtoK(TranslateEtoKRequestDto dto) {
        PapagoRequester newOneEK = dto.toDomain();
        repository.saveEtoK(newOneEK);
        return repository.getTranslatedText();
    }
}
