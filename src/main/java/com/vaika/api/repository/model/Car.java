package com.vaika.api.repository.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

  @OneToMany(mappedBy = "car")
  @JsonManagedReference
  private List<Image> images;
}
