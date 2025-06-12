package com.example.datas_craping.web;

import com.example.datas_craping.service.ProductService;
import com.example.datas_craping.service.dto.ListProducts;
import com.example.datas_craping.service.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<List<ProductDTO>> create(@RequestBody ListProducts dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveListProduct(dto));
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<ProductDTO> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(service.findBySlug(slug));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchByName(@RequestParam("marque") String query) {
        return ResponseEntity.ok(service.findByNomCompletContainingIgnoreCase(query));
    }



}
