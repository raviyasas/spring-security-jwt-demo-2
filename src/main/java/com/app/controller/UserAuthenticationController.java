package com.app.controller;

import com.app.security.JwtTokenUtil;
import com.app.entity.TokenRequest;
import com.app.entity.TokenResponse;
import com.app.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserAuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody TokenRequest request) throws Exception {

        authenticate(request.getUsername(), request.getPassword());
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new TokenResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
