package fadet.private_deploy1.domain.recommendQuestionSupplier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
class RecomQuestionSupplierTest {
    @Test
    void Category리스트get(){
        //given
        RecomQuestionSupplier recomQ = new RecomQuestionSupplier();
        //when
        String[] largeCate = recomQ.getLData();

        //then
        assertThat(largeCate[0]).isEqualTo("java");
    }
}