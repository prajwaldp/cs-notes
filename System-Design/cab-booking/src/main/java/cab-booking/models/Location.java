package cabbooking.models;

import java.util.Date;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Location {
  double latitude;
  double longitude;
  Date lastUpdatedAt;
}
