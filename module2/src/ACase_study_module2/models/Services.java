package ACase_study_module2.models;

public abstract class Services {
    protected String id;
    protected String nameOfServices;
    protected int areaUsed;
    protected int taxExpenses;
    protected int maxPeople;
    protected String type;

    public Services() {
    }

    public Services(String id, String nameOfServices, int areaUsed, int taxExpenses, int maxPeople, String type) {
        this.id = id;
        this.nameOfServices = nameOfServices;
        this.areaUsed = areaUsed;
        this.taxExpenses = taxExpenses;
        this.maxPeople = maxPeople;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameOfServices() {
        return nameOfServices;
    }

    public void setNameOfServices(String nameOfServices) {
        this.nameOfServices = nameOfServices;
    }

    public int getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(int areaUsed) {
        this.areaUsed = areaUsed;
    }

    public int getTaxExpenses() {
        return taxExpenses;
    }

    public void setTaxExpenses(int taxExpenses) {
        this.taxExpenses = taxExpenses;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract String showInfor();
}
