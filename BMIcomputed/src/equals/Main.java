package equals;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Xiao", "Ming", 18),
                new Person("Xiao", "Hong", 25),
                new Person("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person("Bob", "Smith", 20));

        System.out.println(exist ? "测试成功!" : "测试失败!");
        Map<String, Integer> map = new HashMap<>();
        map.remove("a");
        map.put("a", 3);
    }
}

class Person {
    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person ot = (Person) o;
            return Objects.equals(this.firstName, ot.firstName) && Objects.equals(this.lastName, ot.lastName) && this.age == ot.age;
        }
        return false;
    }
}


