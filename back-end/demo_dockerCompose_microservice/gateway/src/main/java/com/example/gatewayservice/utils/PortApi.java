package com.example.gatewayservice.utils;

import org.springframework.beans.factory.annotation.Value;

public class PortApi {

//    @Value("${PORT_AUTH}")
    @Value("${PORT_AUTH:8085}")
    public static String portAuth ;
//    @Value("${Port_USER")
    @Value("${PORT_USER:8083}")
    public static String portUser ;
//    @Value("${PORT_ORDER}")
    @Value("${PORT_ORDER:8084}")
    public static String portOrder  ;
//    @Value("${PORT_PRODUCT}")
    @Value("${PORT_PRODUCT:8082}")
    public static String portProduct ;
//    @Value("${Port_DELIVERY")
    @Value("${PORT_DELIVERY:8086}")
    public static String portDelivery ;
//     @Value("${PORT_STOCK}")
    @Value("${PORT_STOCK:8087}")
    public static String portStock  ;

}
