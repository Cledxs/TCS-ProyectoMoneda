package com.demo.pocmonedaapih2jwt.security;

import com.demo.pocmonedaapih2jwt.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Slf4j
@Component
public class JWTAuthFilter extends OncePerRequestFilter {

  private TokenUtils jwtUtil = new TokenUtils();
  private final String HEADER_NAME = "Authorization";
  private final String HEADER_PREFIX_VALUE = "Bearer ";

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

    String jwt = ofNullable(request.getHeader(HEADER_NAME)).map(header -> header.replace(HEADER_PREFIX_VALUE, "")).orElse(null);

    if (jwt != null && jwtUtil.validateToken(jwt)) {
      setContext(jwt);
    } else {
      clearContext();
    }
    chain.doFilter(request, response);
  }

  private static void clearContext() {
    SecurityContextHolder.clearContext();
  }

  private void setContext(String jwt) {
    Claims claims = jwtUtil.getClaims(jwt);

    List<String> authorities = (List) claims.get("authorities");

    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
        authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    SecurityContextHolder.getContext().setAuthentication(auth);
  }
}
