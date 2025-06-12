package com.example.datas_craping.service;

import com.example.datas_craping.service.dto.ListProducts;
import com.example.datas_craping.service.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO save(ProductDTO dto);

    List<ProductDTO> saveListProduct(ListProducts dto);

    List<ProductDTO> findByNomCompletContainingIgnoreCase(String nomCompletPartiel);

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    ProductDTO findBySlug(String slug);
}
