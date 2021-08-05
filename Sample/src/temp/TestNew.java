package temp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestNew {

    public static void main(String[] args) {

        Employee e1 = new Employee("a", 100.0, 24);
        Employee e2 = new Employee("b", 110.0, 25);
        Employee e3 = new Employee("c", 120.0, 26);

        List<Employee> empList = Arrays.asList(e1, e2, e3);
        empList = empList.stream().filter(employee -> employee.salary > 100.0).collect(Collectors.toList());
        System.out.println(empList);
    }

}

class Employee {
    String name;
    double salary;
    int age;

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
