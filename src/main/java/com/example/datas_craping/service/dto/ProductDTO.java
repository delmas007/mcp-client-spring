package com.example.datas_craping.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String productId;
    @JsonProperty("nom_complet")
    private String nomComplet;
    private String marque;
    private String ram;
    private String stockage;
    private String batterie;
    private String ecran;
    @JsonProperty("appareil_photo")
    private String appareilPhoto;
    private String prix;
    @JsonProperty("image_produit")
    private String imageProduit;
    @JsonProperty("lien_produit")
    private String lienProduit;
    private String disponibilite;
    @JsonProperty("avis_utilisateurs")
    private String avisUtilisateurs;
    @JsonProperty("source_site")
    private String sourceSite;
    private String slug;
}

