package com.husnaBiyikli.Library.Controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.husnaBiyikli.Library.Entitys.role;
import com.husnaBiyikli.Library.Entitys.user;
import com.husnaBiyikli.Library.EnumRole.enumRole;
import com.husnaBiyikli.Library.Services.userService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    userService userService;

    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    public String showLoginForm() {
        return "login1";
    }

    @GetMapping("/registerPage")
    public String registerPage(Model model, user user) {
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") user user) {
        Set<role> roles = new HashSet<>();
        role role = new role();
        role.setRole(enumRole.ROLE_STANDART);
        roles.add(role);
        user.setRoles(roles);
        userService.saveUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/current-user")
    public ResponseEntity<?> getCurrentUser() {
        try {
            user currentUser = userService.gettCurrentUser();
            return ResponseEntity.ok(currentUser);
        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kullanıcı bulunamadı: " + ex.getMessage());
        } catch (SecurityException ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Giriş yapmış bir kullanıcı bulunamadı.");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bir hata oluştu.");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        request.getSession(false).invalidate();
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Başarıyla çıkış yapıldı");
    }

}
