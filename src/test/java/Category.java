import org.apache.commons.lang3.RandomStringUtils;

public class Category {

    private String name;

    public Category( String charUP, String categoryName) {

        categoryName = RandomStringUtils.randomAlphanumeric(4).toLowerCase();
        this.name = charUP + categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
