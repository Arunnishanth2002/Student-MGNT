package com.example.student.controller;
import com.example.student.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.student.User;
import com.example.student.repository.UserRepository;
import com.example.student.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<User>> register(@RequestBody User user)
    {
        //DEBUG
        System.out.println("------Debug Start------");
        System.out.println("username: "+user.getUsername());
        System.out.println("password : "+user.getPassword());
        System.out.println("-------debug end------");

       User saved=repo.save(user);

       return ResponseEntity.status(201).body(new ApiResponse<>("Success",saved,"user registerd successfully"));
    }

    @PostMapping("/login")
    public String login(@RequestBody User user)
    {
        //debug
        System.out.println("Login debug");
        System.out.println("username: "+user.getUsername());
        System.out.println("password: "+user.getPassword());

        User u = repo.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!u.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}