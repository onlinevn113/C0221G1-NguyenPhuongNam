package ACase_study_module2.models;

public class Room extends Services {
    protected String freeService;

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public Room(){}
    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String id, String nameOfServices, int areaUsed, int taxExpenses, int maxPeople, String type, String freeService) {
        super(id, nameOfServices, areaUsed, taxExpenses, maxPeople, type);
        this.freeService = freeService;
    }

    @Override
    public String showInfor() {
        return "Room{" +
                ", id='" + id + '\'' +
                ", nameOfServices='" + nameOfServices + '\'' +
                ", areaUsed=" + areaUsed +
                ", taxExpenses=" + taxExpenses +
                ", maxPeople=" + maxPeople +
                ", type='" + type + '\'' +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
