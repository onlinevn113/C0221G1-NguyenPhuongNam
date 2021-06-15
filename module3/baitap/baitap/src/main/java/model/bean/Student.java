package model.bean;

public class Student {
    private int id;
    private String name;
    private int gender;
    private String birthday;
    private String email;
    private String address;

    public Student(String name, int gender, String birthday, String email, String address) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
    }

    public Student(int id, String name, int gender, String birthday, String email, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
