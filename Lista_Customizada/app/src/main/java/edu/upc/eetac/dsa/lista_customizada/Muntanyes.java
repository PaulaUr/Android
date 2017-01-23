package edu.upc.eetac.dsa.lista_customizada;

/**
 * Created by pauli on 19/12/2016.
 */
public class Muntanyes {

    private String name;
   private int altitude;
    // public int locationId;
   // public double latitude;
   // public double longitude;
   // public int floor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAltitude() {
        return String.valueOf(altitude);
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

  /* public Muntanyes fillInTheFields(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        return this;
    }*/
}
