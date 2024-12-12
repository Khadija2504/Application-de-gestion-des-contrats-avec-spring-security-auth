package com.example.gestioncontrat.config;

import com.example.gestioncontrat.service.interfaces.UserActivityServiceInterface;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class UserActivityFilter extends OncePerRequestFilter {

    private final UserActivityServiceInterface activityService;

    public UserActivityFilter(UserActivityServiceInterface activityService) {
        this.activityService = activityService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getName())) {
            String username = auth.getName();
            String action = request.getMethod();
            String endpoint = request.getRequestURI();

            activityService.logActivity(username, action, endpoint);
        }

        filterChain.doFilter(request, response);
    }
}
