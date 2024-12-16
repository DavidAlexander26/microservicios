package com.synopsis.capacitacion.product.repository;

import com.synopsis.capacitacion.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.code = :code")
    Optional<ProductEntity> findProductByCode(@Param("code") String code);

    Optional<ProductEntity> findByCode(String code);

}
