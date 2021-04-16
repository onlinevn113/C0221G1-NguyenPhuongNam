package ACase_study_module2.models;

public class Villa extends Services {
    protected String roomStandard;
    protected String confortable;
    protected int areaOfSwimmingPool;
    protected int numberOfFloors;

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getConfortable() {
        return confortable;
    }

    public void setConfortable(String confortable) {
        this.confortable = confortable;
    }

    public int getAreaOfSwimmingPool() {
        return areaOfSwimmingPool;
    }

    public void setAreaOfSwimmingPool(int areaOfSwimmingPool) {
        this.areaOfSwimmingPool = areaOfSwimmingPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Villa() {
    }

    public Villa(String roomStandard, String comfortable, int areaOfSwimmingPool, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.confortable = comfortable;
        this.areaOfSwimmingPool = areaOfSwimmingPool;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String id, String nameOfServices, int areaUsed, int taxExpenses, int maxPeople, String type, String roomStandard, String confortable, int areaOfSwimmingPool, int numberOfFloors) {
        super(id, nameOfServices, areaUsed, taxExpenses, maxPeople, type);
        this.roomStandard = roomStandard;
        this.confortable = confortable;
        this.areaOfSwimmingPool = areaOfSwimmingPool;
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInfor() {
        return "Villa{" +
                ", id='" + id + '\'' +
                ", nameOfServices='" + nameOfServices + '\'' +
                ", areaUsed=" + areaUsed +
                ", taxExpenses=" + taxExpenses +
                ", maxPeople=" + maxPeople +
                ", type='" + type + '\'' +
                "roomStandard='" + roomStandard + '\'' +
                ", confortable='" + confortable + '\'' +
                ", areaOfSwimmingPool=" + areaOfSwimmingPool +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
