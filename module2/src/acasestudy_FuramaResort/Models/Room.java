package acasestudy_FuramaResort.Models;

public class Room extends Services {
    private ExtraService extraService;

    public Room() {
    }

    public Room(String id, String serviceName, double areaUse, double rentPrice, int maxPeople, String rentType) {
        super(id, serviceName, areaUse, rentPrice, maxPeople, rentType);
    }

    public Room(String id, String serviceName, double areaUse, double rentPrice, int maxPeople, String rentType, ExtraService extraService) {
        super(id, serviceName, areaUse, rentPrice, maxPeople, rentType);
        this.extraService = extraService;
    }

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }


    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}
