package com.lucasbatista.projects.service;

import com.lucasbatista.projects.entity.Gift;
import com.lucasbatista.projects.exceptions.ResourceNotFoundException;
import com.lucasbatista.projects.repository.GiftRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class GiftServiceImp implements GiftService{

    private final GiftRepository repository;

    @Autowired
    public GiftServiceImp(GiftRepository repository) {
        this.repository = repository;
    }

    public List<Gift> getAll() {
        return this.repository.findAll();
    }

    public Gift getById(String id) {
        return (Gift)this.repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Gift not found");
        });
    }

    public Gift save(Gift gift) {
        if (gift.getId() != null) {
            throw new IllegalArgumentException("Id cannot be passed here");
        } else {
            return (Gift)this.repository.save(gift);
        }
    }

    public Gift update(Gift gift) {
        if (gift.getId() == null) {
            throw new IllegalArgumentException("Id field is mandatory");
        } else if (this.getById(gift.getId()) == null) {
            throw new ResourceNotFoundException("Gift not found");
        } else {
            return (Gift)this.repository.save(gift);
        }
    }

    public Gift buy(String id) {
        Gift gift = this.getById(id);
        gift.setBuyTime(LocalDateTime.now());
        gift.setHasBuyer(true);
        return (Gift)this.repository.save(gift);
    }

    public Gift cancelBuy(String id) {
        Gift gift = this.getById(id);
        gift.setBuyTime(null);
        gift.setHasBuyer(false);
        return (Gift)this.repository.save(gift);
    }

    public void delete(Gift gift) {
        this.repository.delete(gift);
    }
}
