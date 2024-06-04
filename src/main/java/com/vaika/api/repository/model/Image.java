package com.vaika.api.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
public class Image {
  @Id private String id;
  private String url;
  @ManyToOne @JsonBackReference private Car car;
}
