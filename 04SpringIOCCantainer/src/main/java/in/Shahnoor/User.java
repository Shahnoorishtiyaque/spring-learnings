package in.Shahnoor;

//Spring doent handle this because we dont know what will be stored in nakme and age
//also Spring cant handle any .class file bcoz we cant make any changes in JAR files
//Solution is in the AppConfig

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
