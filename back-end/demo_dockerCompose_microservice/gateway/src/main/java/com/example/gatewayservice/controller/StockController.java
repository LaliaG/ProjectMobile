package com.example.gatewayservice.controller;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/stock")
public class StockController {

    @Inject
    private StockService stockService;

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
}
