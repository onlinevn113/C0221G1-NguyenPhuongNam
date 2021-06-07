package model.bean;

public class CustomerType {
    private int idTypeCustomer;
    private String customerTypeName;

    public CustomerType() {
    }

    public CustomerType(int idTypeCustomer, String customerTypeName) {
        this.idTypeCustomer = idTypeCustomer;
        this.customerTypeName = customerTypeName;
    }

    public int getIdTypeCustomer() {
        return idTypeCustomer;
    }

    public void setIdTypeCustomer(int idTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
