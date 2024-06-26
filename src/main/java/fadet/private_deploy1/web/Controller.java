package fadet.private_deploy1.web;


import fadet.private_deploy1.service.GptService;
import fadet.private_deploy1.service.DeeplService;
import fadet.private_deploy1.service.RecomQService;
import fadet.private_deploy1.web.dto.requestDto.TranslateEtoKRequestDto;
import fadet.private_deploy1.web.dto.requestDto.TranslateKtoERequestDto;
import fadet.private_deploy1.web.dto.requestDto.RQ2RequestDto;
import fadet.private_deploy1.web.dto.requestDto.QuestionRequestDto;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.Duration;


@RequiredArgsConstructor
@RestController
public class Controller {

    private final DeeplService deeplService;
    private final RecomQService recomQService;
    private final GptService gptService;

    //서버용 rate limit
    Bucket bucket2 = Bucket.builder()
            .addLimit(Bandwidth.simple(1,Duration.ofSeconds(10)))
            .build();

    @PostMapping("/api/requestTransKE")
    public String  requestTransKtoE(@RequestBody @Valid TranslateKtoERequestDto dto){
        return deeplService.transKtoE(dto);
    }

    @GetMapping("/api/requestRQ")
    public String[] requestRecomQ(){
        return recomQService.getRecomQ();
    }

    //수정 필요
    @PostMapping("/api/requestRQ2")
    public String[] requestRecomQ2(@RequestBody @Valid RQ2RequestDto dto){
        return recomQService.getRecomQ2(dto);
    }

    @PostMapping("/api/requestQuestion")
    public String requestQuestion(@RequestBody @Valid QuestionRequestDto dto) throws Exception{
        if(bucket2.tryConsume(1)){
            return gptService.getAnswerContent(dto);

        }
        return "Error:TOO MANY REQUEST";
    }

    @PostMapping(value="/api/requestTransEK", produces="text/plain;charset=UTF-8")
    public String requestTransEK(@RequestBody @Valid TranslateEtoKRequestDto dto){
        return deeplService.transEtoK(dto);
    }

}
