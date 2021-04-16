package ACase_study_module2.models;

public class House extends Services {
    protected String roomStandard;
    protected String confortable;
    protected int numberOfFloors;

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getComfortable() {
        return confortable;
    }

    public void setComfortable(String comfortable) {
        this.confortable = comfortable;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public House() {
    }

    public House(String roomStandard, String comfortable, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.confortable = comfortable;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String id, String nameOfServices, int areaUsed, int taxExpenses, int maxPeople, String type, String roomStandard, String comfortable, int numberOfFloors) {
        super(id, nameOfServices, areaUsed, taxExpenses, maxPeople, type);
        this.roomStandard = roomStandard;
        this.confortable = comfortable;
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInfor() {
        return "House{" +
                ", id='" + id + '\'' +
                ", nameOfServices='" + nameOfServices + '\'' +
                ", areaUsed=" + areaUsed +
                ", taxExpenses=" + taxExpenses +
                ", maxPeople=" + maxPeople +
                ", type='" + type + '\'' +
                "roomStandard='" + roomStandard + '\'' +
                ", comfortable='" + confortable + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
