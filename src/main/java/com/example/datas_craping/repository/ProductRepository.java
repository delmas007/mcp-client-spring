package com.example.datas_craping.repository;

import com.example.datas_craping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findBySlug(String slug);

    @Query("SELECT p FROM Product p WHERE p.lienProduit != 'N/A'")
    List<Product> findAllWithLienProduitDifferentFromNA();


    List<Product> findByMarqueContainingIgnoreCase(String nomCompletPartiel);
}

