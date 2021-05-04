package acasestudy_FuramaResort.Models;

public abstract class Services  {
    protected String id;
    protected String serviceName;
    protected double areaUse;
    protected double rentPrice;
    protected int maxPeople;
    protected String rentType;

    public Services() {
    }

    public Services(String id, String serviceName, double areaUse, double rentPrice, int maxPeople, String rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.areaUse = areaUse;
        this.rentPrice = rentPrice;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", areaUse=" + areaUse +
                ", rentPrice=" + rentPrice +
                ", maxPeople=" + maxPeople +
                ", rentType='" + rentType + '\'' +
                '}';
    }

    public abstract void showInfor();
}
