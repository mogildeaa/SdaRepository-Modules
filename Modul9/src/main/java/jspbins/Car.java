package jspbins;

public class Car {

    String brand;
    String type;
    int year;
    double km;

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public double getKm() {
        return km;
    }

    public Car(String brand, String type, int year, double km) {
        this.brand = brand;
        this.type = type;
        this.year = year;
        this.km = km;
    }

    public String toString() {
        return "Masina: - brand:" + brand + " - type:" + type + " - year:" + year + " - km:" + km;
    }
}
