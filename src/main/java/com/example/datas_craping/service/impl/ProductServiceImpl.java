package com.example.datas_craping.service.impl;

import com.example.datas_craping.model.Product;
import com.example.datas_craping.repository.ProductRepository;
import com.example.datas_craping.service.ProductService;
import com.example.datas_craping.service.dto.ListProducts;
import com.example.datas_craping.service.dto.ProductDTO;
import com.example.datas_craping.utils.SlugUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ModelMapper mapper;

    private final static String PRODUCT_SLUG = "product";


    @Override
    public ProductDTO save(ProductDTO dto) {
        dto.setSlug(SlugUtils.slugify(PRODUCT_SLUG));
        Product product = mapper.map(dto, Product.class);
        return mapper.map(repository.save(product), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> saveListProduct(ListProducts dto) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (ProductDTO productDTO : dto.getListPhone()) {
            productDTOList.add(save(productDTO));
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> findByNomCompletContainingIgnoreCase(String nomCompletPartiel) {
        return repository.findByMarqueContainingIgnoreCase(nomCompletPartiel)
                .stream()
                .map(p -> mapper.map(p, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAll() {
        return repository.findAllWithLienProduitDifferentFromNA()
                .stream()
                .map(p -> mapper.map(p, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        return repository.findById(id)
                .map(p -> mapper.map(p, ProductDTO.class))
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    @Override
    public ProductDTO findBySlug(String slug) {
        return repository.findBySlug(slug)
                .map(p -> mapper.map(p, ProductDTO.class))
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }
}
