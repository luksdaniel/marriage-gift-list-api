package com.lucasbatista.projects.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "gift")
public class Gift extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String description;

    @Column
    private String observation;

    @Column(nullable = false)
    private boolean hasBuyer = false;

    @Column
    private LocalDateTime buyTime;

    @Column
    private String url;

    @ManyToOne()
    @JoinColumn(name = "wedding_id")
    private Wedding wedding;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return Objects.equals(id, gift.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
