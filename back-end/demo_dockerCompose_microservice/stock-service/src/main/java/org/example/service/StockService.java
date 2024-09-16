package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.entity.Stock;
import org.example.kafka.StockKafkaProducer;
import org.example.repository.StockRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class StockService {

    @Inject
    StockRepository stockRepository;


    @Inject
    StockKafkaProducer stockKafkaProducer;


    public Optional<Stock> findByProductId(Long productId) {
        return stockRepository.findByProductId(productId);
    }

    public List<Stock> findAll() {
        List<Stock> stocks = stockRepository.listAll();
        return stocks;
    }

    @Transactional
    public Stock createStock(Long productId, int quantity) {
        Stock stock = new Stock();
        stock.setProductId(productId);
        stock.setQuantity(quantity);
        stockRepository.persist(stock);
        return stock;
    }

    @Transactional
    public Stock updateStock(Long id, int quantity) {
        Stock stock = stockRepository.findById(id);
        if (stock != null) {
            stock.setQuantity(quantity);
            stockRepository.persist(stock);
        }
        return stock;
    }

    @Transactional
    public boolean deleteStock(Long id) {
        return stockRepository.deleteById(id);
    }


    @Transactional
    public void increaseStock(Long productId, int quantity) {
        Optional<Stock> stockOpt = stockRepository.findByProductId(productId);

        if (stockOpt.isPresent()) {
            Stock stock = stockOpt.get();
            stock.setQuantity(stock.getQuantity() + quantity);
            stockRepository.persist(stock);

            stockKafkaProducer.publishStockIncreaseEvent(productId,quantity);

        }
    }

    @Transactional
    public Stock createOrUpdateStock(Long productId, int quantity) {
        Optional<Stock> stockOpt = findByProductId(productId);

        Stock stock;
        if (stockOpt.isPresent()) {
            stock = stockOpt.get();
            stock.setQuantity(quantity);
        } else {
            stock = new Stock();
            stock.setProductId(productId);
            stock.setQuantity(quantity);
        }
        stockRepository.persist(stock);
        return stock;
    }

    public void restockProduct(String productId, int quantity) {
    }

    public void decreaseStock(String productId, int quantity) {
    }

    public Object getStockByProduct(String productId) {
        return null;
    }
}
