package Java8Features.FunctionalInterface.Predicate;

//Define a Product class with name, price, category, grade

public class Product {
    private String name;
    private  double price;
    private String category;
    private  Character grade;

    public Product( String name, double price,String category, Character grade) {
        this.category = category;
        this.grade = grade;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Character getGrade() {
        return grade;
    }

    public void setGrade(Character grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", grade=" + grade +
                '}';
    }
}
