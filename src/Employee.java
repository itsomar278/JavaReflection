public class Employee implements Comparable<Employee>{
    int id;
    int age ;
    String Name;

    public Employee(int id, int age, String name) {
        this.id = id;
        this.age = age;
        Name = name;
    }

    public Employee() {
    }

    public int CalcSalary(int hours, int rate) {
        return( (hours * rate) + age ) ;
    }

    @Override
    public int compareTo(Employee o) {
        if(!this.Name.equals(o.Name))
         {
             return 0;
         }
        else
        {
            return 1;
        }

    }
}
