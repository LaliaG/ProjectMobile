package com.example.springsecurityjwt.filter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class IpFilterWhiteList extends OncePerRequestFilter {


    private static final List<String> WHITELISTED_IPS = Arrays.asList(
            "127.0.0.1", // Ipv4 localhost
            "0:0:0:0:0:0:0:1" // Ipv6 localhost
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String remoteAddr = request.getRemoteAddr();

        if (!WHITELISTED_IPS.contains(remoteAddr)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Forbidden IP Address");
            return;
        }

        filterChain.doFilter(request, response);
    }



}
