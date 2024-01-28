package fadet.private_deploy1.domain.entity.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long>{
    @Query("SELECT q FROM Question q ORDER BY q.id DESC")
    List<Question> findLastOne();

}
