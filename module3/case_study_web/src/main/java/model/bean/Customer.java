package model.bean;

public class Customer {
    private int idCustomer;
    private int idTypeCustomer;
    private String name;
    private String dateOfBirth;
    private int sex;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    private int contractId;




    public Customer(int idCustomer, String name, String dateOfBirth, int contractId) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contractId = contractId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdTypeCustomer() {
        return idTypeCustomer;
    }

    public void setIdTypeCustomer(int idTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Customer(int idTypeCustomer, String name, String dateOfBirth, int sex, String idCard, String phoneNumber, String email, String address) {
        this.idTypeCustomer = idTypeCustomer;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Customer(int idCustomer, int idTypeCustomer, String name, String dateOfBirth, int sex, String idCard, String phoneNumber, String email, String address) {
        this.idCustomer = idCustomer;
        this.idTypeCustomer = idTypeCustomer;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}
