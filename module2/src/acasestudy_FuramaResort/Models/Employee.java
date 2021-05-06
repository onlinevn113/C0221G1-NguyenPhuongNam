package acasestudy_FuramaResort.Models;

public class Employee {
    private String id;
    private String employeeName;
    private String employeAge;
    private String emloployeAddress;

    public Employee() {
    }

    public Employee(String id, String employeeName, String employeAge, String emloployeAddress) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeAge = employeAge;
        this.emloployeAddress = emloployeAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeAge() {
        return employeAge;
    }

    public void setEmployeAge(String employeAge) {
        this.employeAge = employeAge;
    }

    public String getEmloployeAddress() {
        return emloployeAddress;
    }

    public void setEmloployeAddress(String emloployeAddress) {
        this.emloployeAddress = emloployeAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeAge='" + employeAge + '\'' +
                ", emloployeAddress='" + emloployeAddress + '\'' +
                '}';
    }
}
