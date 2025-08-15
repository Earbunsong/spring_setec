package org.example.test_st10.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/admin/users")
    public ResponseEntity<List<Map<String, String>>> getUsers() {
        List<Map<String, String>> users = List.of(
                Map.of("id", "1", "username", "admin", "role", "ADMIN", "email", "admin@example.com"),
                Map.of("id", "2", "username", "user", "role", "USER", "email", "user@example.com"),
                Map.of("id", "3", "username", "john", "role", "USER", "email", "john@example.com")
        );
        return ResponseEntity.ok(users);
    }

    @GetMapping("/admin/stats")
    public ResponseEntity<Map<String, Object>> getAdminStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalUsers", 3);
        stats.put("activeUsers", 2);
        stats.put("totalOrders", 25);
        stats.put("revenue", 15000.50);
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/user/profile")
    public ResponseEntity<Map<String, String>> getUserProfile(Authentication authentication) {
        Map<String, String> profile = new HashMap<>();
        profile.put("username", authentication.getName());
        profile.put("email", authentication.getName() + "@example.com");
        profile.put("role", authentication.getAuthorities().iterator().next().getAuthority());
        return ResponseEntity.ok(profile);
    }

    @PostMapping("/user/profile")
    public ResponseEntity<Map<String, String>> updateUserProfile(
            @RequestBody Map<String, String> profileData,
            Authentication authentication) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Profile updated successfully for " + authentication.getName());
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/admin/users/{userId}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable String userId) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "User with ID " + userId + " deleted successfully");
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
}