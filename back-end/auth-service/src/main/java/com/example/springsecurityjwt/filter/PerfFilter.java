package com.example.springsecurityjwt.filter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class PerfFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException, IOException {
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        long duree = System.currentTimeMillis() - startTime;
        System.out.println("La requête : " + request.getRequestURI() + " a mis : " + duree + "ms");
    }
}