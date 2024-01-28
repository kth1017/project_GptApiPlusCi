package fadet.private_deploy1.domain.papagoRequester;

import fadet.private_deploy1.ApiKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Repository
public class PapagoRequesterRepositoryImpl implements PapagoRequesterRepository {

    private static Map<Long, PapagoRequester> store = new ConcurrentHashMap<>();
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
    public PapagoRequester saveKtoE(PapagoRequester newOne){
        newOne.setId(sequence++);
        store.put(newOne.getId(), newOne);
        return newOne;
    }

    @Override
    public PapagoRequester saveEtoK(PapagoRequester newOne) {
        newOne.setId(sequence++);
        store.put(newOne.getId(), newOne);
        return newOne;
    }

    @Override
    public PapagoRequester findLastOne() {
        Long size = (long)store.size();
        return store.get(size);
    }

    @Override
    public String getTranslatedText() {
        Long size = (long)store.size();
        return store.get(size).incoding(apiKey);
    }

}
