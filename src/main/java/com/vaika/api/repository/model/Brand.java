package com.vaika.api.repository.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Brand {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private String id;

  private String name;

  @Column(name = "logo_url")
  private String logoUrl;
}
