package com.finalpro.marketplace.controller;

import com.finalpro.marketplace.model.User;
import com.finalpro.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthenticationController {

    private final UserRepository userRepository;

    @Autowired
    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            bindingResult.rejectValue("email", "err.email", "Email already exists");
            return "register";
        }

        // Encode raw password to hashed value
        String password = user.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(password);

        // Set encrypted password and default role
        user.setPassword(encryptedPassword);
        user.setRole("USER");

        userRepository.save(user);

        return "redirect:/login";
    }

}
