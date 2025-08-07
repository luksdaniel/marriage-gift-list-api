package com.lucasbatista.projects.service;

import com.lucasbatista.projects.entity.Gift;

import java.util.List;

public interface GiftService {

    List<Gift> getAll();

    Gift getById(String id);

    Gift save(Gift gift);

    Gift update(Gift gift);

    Gift buy(String id);

    Gift cancelBuy(String id);

    void delete(Gift gift);
}
