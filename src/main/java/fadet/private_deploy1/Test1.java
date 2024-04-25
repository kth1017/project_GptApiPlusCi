package fadet.private_deploy1;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
    private String[] javaSData = {"jdk", "jvm", "interface", "java8", "java11", "stream", "servlet"};
    private String category = "";
    private String[] dummy = {" "};

    public Test1(String category) {
        this.category = category;
    }

    public String[] getSList() {
        Map<String, String[]> matchingCategoryMap = new HashMap<>();

        try {
            // Test1 클래스에서 선언된 모든 필드를 가져오기
            Field[] fields = Test1.class.getDeclaredFields();
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

    public static void main(String[] args) {
        Test1 test1 = new Test1("java");

        System.out.println(Arrays.toString(test1.getSList()));
    }
}
