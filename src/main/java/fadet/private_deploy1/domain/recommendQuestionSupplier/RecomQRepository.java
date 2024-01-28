package fadet.private_deploy1.domain.recommendQuestionSupplier;

public interface RecomQRepository {
    public void clear();
    public void saveCategory(String c);
    public String getSavedCategory();
    public String[] getList();

    public String[] getSList();
}
