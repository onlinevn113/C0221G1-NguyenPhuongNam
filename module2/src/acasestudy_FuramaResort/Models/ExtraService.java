package acasestudy_FuramaResort.Models;

public class ExtraService {
    private String extraServiceName;
    private String unit;
    private double price;


    public ExtraService(String extraServiceName, String unit, double price) {
        this.extraServiceName = extraServiceName;
        this.unit = unit;
        this.price = price;
    }

    public String getExtraServiceName() {
        return extraServiceName;
    }

    public void setExtraServiceName(String extraServiceName) {
        this.extraServiceName = extraServiceName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
