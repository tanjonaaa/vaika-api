package com.vaika.api.repository.model;

import static jakarta.persistence.GenerationType.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Car {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private String id;

  private String name;
  private String description;
  private double price;
  private String model;
  private String color;
  private String power;
  private int placeNumber;
  private boolean pinned;
  @ManyToOne private CarType type;
  @ManyToOne private MotorType motorType;
  @ManyToOne private Brand brand;

  @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE)
  @JsonManagedReference
  private List<Image> images;
}
