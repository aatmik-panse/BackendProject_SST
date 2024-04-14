package dev.aatmik.demoapi.repositories;

import dev.aatmik.demoapi.models.Product;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Id id);

}