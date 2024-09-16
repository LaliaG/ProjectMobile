package org.example.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class StockKafkaProducer {
    // Channel pour l'augmentation du stock
    @Inject
    @Channel("stock-increase")
    Emitter<String> stockIncreaseEmitter;


    // Channel pour la diminution du stock
    @Inject
    @Channel("stock-decrease")
    Emitter<String> stockDecreaseEmitter;

    // Méthode pour publier un événement d'augmentation de stock
    public void publishStockIncreaseEvent(Long productId, int newQuantity){
        String message = "Product " + productId + " stock increased to " + newQuantity;
        stockIncreaseEmitter.send(message);
    }

    // Méthode pour publier un événement de diminution de stock
    public void publishStockDecreaseEvent(Long productId, int newQuantity) {
        String message = "Product " + productId + " stock decreased to " + newQuantity;
        stockDecreaseEmitter.send(message);
    }




}
