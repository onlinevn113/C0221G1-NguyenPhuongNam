package model.bean;

public class Contract {
    private int contractId;
    private int employeeId;
    private int customerId;
    private int serviceId;
    private String contractStartDate;
    private String contractEndDate;
    private int contractDeposit;
    private int contractTotal;

    public Contract(int serviceId, String contractStartDate, String contractEndDate, int contractDeposit, int contractTotal) {
        this.serviceId = serviceId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotal = contractTotal;
    }

    public Contract(int contractId) {
        this.contractId = contractId;
    }

    public Contract(int contractId, int employeeId, int customerId, int serviceId, String contractStartDate, String contractEndDate, int contractDeposit, int contractTotal) {
        this.contractId = contractId;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotal = contractTotal;
    }

    public Contract(int employeeId, int customerId, int serviceId, String contractStartDate, String contractEndDate, int contractDeposit, int contractTotal) {
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotal = contractTotal;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public int getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(int contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public int getContractTotal() {
        return contractTotal;
    }

    public void setContractTotal(int contractTotal) {
        this.contractTotal = contractTotal;
    }
}
