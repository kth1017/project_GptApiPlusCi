package fadet.private_deploy1.service;
import fadet.private_deploy1.domain.deeplRequester.DeeplRequester;
import fadet.private_deploy1.domain.deeplRequester.DeeplRequesterRepository;
import fadet.private_deploy1.web.dto.requestDto.TranslateEtoKRequestDto;
import fadet.private_deploy1.web.dto.requestDto.TranslateKtoERequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeeplService {
    private final DeeplRequesterRepository repository;


    public String transKtoE(TranslateKtoERequestDto dto) {
        DeeplRequester newOneKE = dto.toDomain();
        repository.saveKtoE(newOneKE);
        return repository.getTranslatedText();
    }

    public String transEtoK(TranslateEtoKRequestDto dto) {
        DeeplRequester newOneEK = dto.toDomain();
        repository.saveEtoK(newOneEK);
        return repository.getTranslatedText();
    }
}
