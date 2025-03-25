import java.sql.Date;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String department;
    private Date hireDate;

    public Employee(int id, String firstName, String lastName, String email, String phone, String department, Date hireDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.hireDate = hireDate;
    }

    // Getters and setters for all fields
}
