package enigma.travelwise.controller;

import enigma.travelwise.service.AuthService;
import enigma.travelwise.utils.dto.AuthDTO;
import enigma.travelwise.utils.dto.RefreshTokenDTO;
import enigma.travelwise.utils.dto.RegisterDTO;
import enigma.travelwise.utils.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthDTO req) {
        log.info("Login request: {}", req.getUsername());
        return Response.renderJSON(
                authService.login(req)
        );
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO req) {
        return Response.renderJSON(
                authService.register(req),
                "Success",
                HttpStatus.CREATED
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@Valid @RequestBody RefreshTokenDTO req) {
        return Response.renderJSON(
                authService.refreshToken(req.getRefreshToken())
        );
    }
}