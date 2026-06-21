package com.example.dao;

import java.util.List;
import com.example.entities.Seller;

public interface SellerDAO {
    void insert(Seller selller);
    void update(Seller selller);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
}

