package com.springboot.project.uber.uberApp.controllers;

import com.springboot.project.uber.uberApp.dto.*;
import com.springboot.project.uber.uberApp.services.AuthService;
import com.springboot.project.uber.uberApp.services.DriverService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
        return new ResponseEntity<>(authService.signUp(signUpDto), HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/onBoardNewDriver/{userId}")
    ResponseEntity<DriverDto> onBoardNewDriver(@PathVariable Long userId,
                                               @RequestBody OnBoardDriverDto onBoardDriverDto){
        return new ResponseEntity<>(authService.onBoardNewDriver(userId,
                onBoardDriverDto.getVehicleId()), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto,
                                           HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String token[]= authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        Cookie cookie= new Cookie("token", token[1]);
        cookie.setHttpOnly(true);
        httpServletResponse.addCookie(cookie);
        return ResponseEntity.ok(new LoginResponseDto(token[0]));
    }

    @PostMapping("/refresh")
    ResponseEntity<LoginResponseDto> refresh(HttpServletRequest request){
        String refreshToken= Arrays.stream(request.getCookies())
                .filter(cookie -> "refreshToken".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElseThrow(()->new AuthenticationServiceException("Refresh token not found inside the Cookies"));
        String accessToken= authService.refreshToken(refreshToken);
        return ResponseEntity.ok(new LoginResponseDto(accessToken));
    }
}
