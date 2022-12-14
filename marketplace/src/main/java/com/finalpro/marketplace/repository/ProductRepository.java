package com.finalpro.marketplace.repository;

import com.finalpro.marketplace.model.Product;
import com.finalpro.marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByIdDesc();

    List<Product> findAllByUserOrderByIdDesc(User user);

    List<Product> findAllByTitleContainingIgnoreCaseOrderByIdDesc(String title);

}
