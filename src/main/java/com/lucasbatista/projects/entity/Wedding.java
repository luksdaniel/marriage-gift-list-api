package com.lucasbatista.projects.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "wedding")
public class Wedding extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String addressLat;

    @Column
    private String addressLong;

    @Column(nullable = false)
    private String bride;

    @Column(nullable = false)
    private String groom;

    @Column
    private String weddingAddress;

    @Column
    private LocalDate weddingDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wedding wedding = (Wedding) o;
        return Objects.equals(id, wedding.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
