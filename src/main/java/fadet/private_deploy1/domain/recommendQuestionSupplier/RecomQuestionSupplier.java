package fadet.private_deploy1.domain.recommendQuestionSupplier;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

/*
    로그인 기능 추가시 엔티티 승격 에정이라 enum 사용 안함
 */
@Getter
@NoArgsConstructor
public class RecomQuestionSupplier {
    private String[] lData = {"java","spring", "js", "react", "DOM" ,"DBMS", "OOP"};
    private String category = "";

    // enum 사용과 배열 중에 고민
    private String[] javaSData = {"jdk", "jvm", "interface", "java8", "java11", "stream", "servlet"};
    private String[] springSData = {"spring boot", "modules", "spring mvc","DI", "IoC", "SPA", "AOP", "dependency"};
    private String[] jsSData = {"sync", "single-thread", "EC6", "object"};
    private String[] reactSData = {"component", "state", "props", "context API", "react-redux"};
    private String[] DOMSData = {"virtual DOM", "rendering", "paint", "DOM tree"};
    private String[] DBMSSData = {"query", "SQL", "No-SQL", "Transaction","Domain", "schema", "integrity", "consistency"};
    private String[] OOPSData = {"object", "encapsulation", "inheritance", "polymorphism","mariaDB", "PostgreSQL", "oracle"};

    private String[] dummy = {" "};


    public RecomQuestionSupplier(String category) {
        this.category = category;
    }

    // js의 eval()과 비슷한 동적 변수 할당 로직을 구헌하려해봤으나 결국 reflection을 사용해야해서 포기
    public String[] getSList() {
        Map<String, String[]> matchingCategoryMap = new HashMap<>();

        matchingCategoryMap.put("java", javaSData);
        matchingCategoryMap.put("spring", springSData);
        matchingCategoryMap.put("js", jsSData);
        matchingCategoryMap.put("react", reactSData);
        matchingCategoryMap.put("DOM", DOMSData);
        matchingCategoryMap.put("DBMS", DBMSSData);
        matchingCategoryMap.put("OOP", OOPSData);

        return matchingCategoryMap.getOrDefault(category, dummy);
    }



}
