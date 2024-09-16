package org.example.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.entity.Stock;

import java.util.Optional;

@ApplicationScoped
public class StockRepository implements PanacheRepository<Stock> {

    public Optional<Stock> findByProductId(Long productId) {
        return find("productId", productId).firstResultOptional();
    }
}
