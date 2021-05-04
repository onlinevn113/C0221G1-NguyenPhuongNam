package acasestudy_FuramaResort.Models;

public class House extends Services {
    private String standardRoom;
    private String otherConvenientDescription;
    private int numberOfFloor;

    public House() {
    }

    public House(String id, String serviceName, double areaUse, double rentPrice, int maxPeople, String rentType) {
        super(id, serviceName, areaUse, rentPrice, maxPeople, rentType);
    }

    public House(String id, String serviceName, double areaUse, double rentPrice, int maxPeople, String rentType, String standardRoom, String otherConvenientDescription, int numberOfFloor) {
        super(id, serviceName, areaUse, rentPrice, maxPeople, rentType);
        this.standardRoom = standardRoom;
        this.otherConvenientDescription = otherConvenientDescription;
        this.numberOfFloor = numberOfFloor;
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

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "standardRoom='" + standardRoom + '\'' +
                ", otherConvenientDescription='" + otherConvenientDescription + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                '}'+super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}
