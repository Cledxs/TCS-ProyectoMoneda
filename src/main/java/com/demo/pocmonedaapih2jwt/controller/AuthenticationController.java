package com.demo.pocmonedaapih2jwt.controller;

import com.demo.pocmonedaapih2jwt.model.AuthenticationResponse;
import com.demo.pocmonedaapih2jwt.utils.TokenUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping()
@AllArgsConstructor
public class AuthenticationController {

  @Autowired
  private TokenUtils jwtUtil;

  @PostMapping("/authenticate")
  public AuthenticationResponse authenticate(@RequestParam("userName") String userName, @RequestParam("password") String password) throws Exception {

    if (userName.equals("userdemo") && password.equals("password")) {
      String jwt = jwtUtil.generateToken(userName);
      return new AuthenticationResponse(jwt);
    } else {
      throw new RuntimeException("Usuario no encontrado");
    }
  }
}