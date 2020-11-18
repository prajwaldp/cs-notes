package cabbooking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Cab {
  String id;
  Driver driver;
  Location currentLocation;
  CabStatus status;

  public Cab(String id, String driver) {
    this.id = id;
    this.driver = driver;
  }
}
