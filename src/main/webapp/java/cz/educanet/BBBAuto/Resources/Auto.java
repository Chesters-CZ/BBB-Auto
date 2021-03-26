package cz.educanet.BBBAuto.Resources;

public class Auto {
    public String SPZ;
    public String barva;
    public String brand;
    public String model;
    public int rokVyroby;
    public String serialNo;
    public boolean bourane;
    public Palivo pohon;
    public float horsepower;
    public Transmission razeni;
    public boolean klimatizace;

    public Auto() {
        this.SPZ = null;
        this.barva = null;
        this.brand = null;
        this.model = null;
        this.rokVyroby = -1;
        this.serialNo = null;
        this.bourane = false;
        this.pohon = null;
        this.horsepower = -1;
        this.razeni = null;
        this.klimatizace = false;
    }

    public Auto(String SPZ, String barva, String brand, String model, int rokVyroby, String serialNo, boolean bourane, Palivo pohon, float horsepower, Transmission razeni, boolean klimatizace) {
        this.SPZ = SPZ;
        this.barva = barva;
        this.brand = brand;
        this.model = model;
        this.rokVyroby = rokVyroby;
        this.serialNo = serialNo;
        this.bourane = bourane;
        this.pohon = pohon;
        this.horsepower = horsepower;
        this.razeni = razeni;
        this.klimatizace = klimatizace;
    }

    public enum Transmission{
        MANUAL, AUTOMATIC, AUTOMATIC_OR_MANUAL, NONE
    }

    public enum Palivo{
        MANUAL_PROPULSION, DIESEL, GASOLINE, LPG, GASOLINE_OR_ETHANOL, ELECTRICITY, HYDROGEN, DIESEL_HYBRID, GASOLINE_HYBRID, LPG_HYBRID, GASOLINE_OR_ETHANOL_HYBRID, HYDROGEN_HYBRID, MANUAL_PROPULSION_HYBRID, HORSE
    }
}
