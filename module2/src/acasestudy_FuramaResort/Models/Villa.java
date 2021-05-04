package acasestudy_FuramaResort.Models;

public class Villa extends Services {
    private String standardRoom;
    private String otherConvenientDescription;
    private double poolArea;
    private int numberOfFloor;
    public Villa(String id, String serviceName, double areaUse, double rentPrice, int maxPeople, String rentType, String standardRoom, String otherConvenientDescription, double poolArea, int numberOfFloor) {
        super(id, serviceName, areaUse, rentPrice, maxPeople, rentType);
        this.standardRoom = standardRoom;
        this.otherConvenientDescription = otherConvenientDescription;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }



    public Villa() {
    }


    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherConvenientDescription() {
        return otherConvenientDescription;
    }

    public void setOtherConvenientDescription(String otherConvenientDescription) {
        this.otherConvenientDescription = otherConvenientDescription;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }


    @Override
    public String toString() {
        return "Villa{" +
                "standardRoom='" + standardRoom + '\'' +
                ", otherConvenientDescription='" + otherConvenientDescription + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloor=" + numberOfFloor +
                '}'+super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}
