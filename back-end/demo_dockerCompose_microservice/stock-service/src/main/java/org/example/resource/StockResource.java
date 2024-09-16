package org.example.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entity.Stock;
import org.example.service.StockService;

import java.util.List;

@Path("/stock")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StockResource {

    @Inject
    StockService stockService;

    @POST
    @Path("/restock/{productId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response restockProduct(@PathParam("productId") String productId, @QueryParam("quantity") int quantity) {
        stockService.restockProduct(productId, quantity);
        return Response.ok().build();
    }

    @POST
    @Path("/decrease/{productId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response decreaseStock(@PathParam("productId") String productId, @QueryParam("quantity") int quantity) {
        stockService.decreaseStock(productId, quantity);
        return Response.ok().build();
    }

    @GET
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStockByProduct(@PathParam("productId") String productId) {
        return Response.ok(stockService.getStockByProduct(productId)).build();
    }

    @GET
    public List<Stock> getAllStocks() {
        return stockService.findAll();
    }

    @GET
    @Path("/{productId}")
    public Response getProductStock(@PathParam("productId") Long productId) {
        return stockService.findByProductId(productId)
                .map(stock -> Response.ok(stock).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response createStock(Stock stock) {
        Stock created = stockService.createStock(stock.getProductId(), stock.getQuantity());
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateStock(@PathParam("id") Long id, Stock stock) {
        Stock updated = stockService.updateStock(id, stock.getQuantity());
        if (updated != null) {
            return Response.ok(updated).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStock(@PathParam("id") Long id) {
        boolean deleted = stockService.deleteStock(id);
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @GET
    @Path("/{productId}/increase")
    public Response increaseStock(@PathParam("productId") Long productId, @QueryParam("quantity") int quantity) {
        stockService.increaseStock(productId, quantity);
        return Response.ok().build();
    }
}

