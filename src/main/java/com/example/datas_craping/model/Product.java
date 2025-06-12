package com.example.datas_craping.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_complet")
    private String nomComplet;
    private String marque;
    private String ram;
    private String stockage;
    private String batterie;
    private String ecran;
    @Column(name = "appareil_photo")
    private String appareilPhoto;
    private String prix;
    @Column(name = "image_produit")
    private String imageProduit;
    @Column(name = "lien_produit")
    private String lienProduit;
    private String disponibilite;
    @Column(name = "avis_utilisateurs")
    private String avisUtilisateurs;
    @Column(name = "source_site")
    private String sourceSite;
    private String slug;
}

