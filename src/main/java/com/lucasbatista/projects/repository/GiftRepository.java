package com.lucasbatista.projects.repository;

import com.lucasbatista.projects.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<Gift, String> {
}
