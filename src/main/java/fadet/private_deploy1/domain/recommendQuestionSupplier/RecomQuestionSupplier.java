package fadet.private_deploy1.domain.recommendQuestionSupplier;

import fadet.private_deploy1.Test1;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
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

// reflection을 사용하여 코드 수정, 기존 하드 코딩 매핑은 주석 처리
// private 필드 접근 상관 없음, 가독성은 주석으로 대체, 성능은 테스트시 큰 차이 없기에 수정
//    public String[] getSList() {
//        Map<String, String[]> matchingCategoryMap = new HashMap<>();
//
//        matchingCategoryMap.put("java", javaSData);
//        matchingCategoryMap.put("spring", springSData);
//        matchingCategoryMap.put("js", jsSData);
//        matchingCategoryMap.put("react", reactSData);
//        matchingCategoryMap.put("DOM", DOMSData);
//        matchingCategoryMap.put("DBMS", DBMSSData);
//        matchingCategoryMap.put("OOP", OOPSData);
//
//        return matchingCategoryMap.getOrDefault(category, dummy);
//    }

    public String[] getSList() {
        Map<String, String[]> matchingCategoryMap = new HashMap<>();

        try {
            // Test1 클래스에서 선언된 모든 필드를 가져오기
            Field[] fields = RecomQuestionSupplier.class.getDeclaredFields();
            for (Field field : fields) {
                // 필드의 이름과 category가 일치하는 경우 해당 필드를 가져와서 matchingCategoryMap에 넣기
                if (field.getName().equals(category+"SData")) {
                    field.setAccessible(true); // private 필드에 접근 가능하도록 설정
                    matchingCategoryMap.put(category, (String[]) field.get(this));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return matchingCategoryMap.getOrDefault(category, dummy);
    }



}
