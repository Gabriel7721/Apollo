package com.ecommerce.delivery.controller;

import com.ecommerce.library.dto.CustomerDto;
import com.ecommerce.library.dto.DeliveryPersonDto;
import com.ecommerce.library.model.Customer;
import com.ecommerce.library.model.DeliveryPerson;
import com.ecommerce.library.service.DeliveryPersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LoginController {


    private final DeliveryPersonService deliveryPersonService;
    private final BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "Login Page");
        model.addAttribute("page", "Home");
        return "login";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute("page", "Register");
        model.addAttribute("deliveryPersonDto", new DeliveryPersonDto());
        return "register";
    }


    @PostMapping("/do-register")
    public String registerDeliveryPerson(@Valid @ModelAttribute("deliveryPersonDto") DeliveryPersonDto deliveryPersonDto,
                                   BindingResult result,
                                   Model model) {
        try {
            if (result.hasErrors()) {
                model.addAttribute("deliveryPersonDto", deliveryPersonDto);
                return "register";
            }
            String username = deliveryPersonDto.getUsername();
            DeliveryPerson deliveryPerson = deliveryPersonService.findByUsername(username);
            if (deliveryPerson != null) {
                model.addAttribute("deliveryPersonDto", deliveryPersonDto);
                model.addAttribute("error", "Email has been register!");
                return "register";
            }
            if (deliveryPersonDto.getPassword().equals(deliveryPersonDto.getConfirmPassword())) {
                deliveryPersonDto.setPassword(passwordEncoder.encode(deliveryPersonDto.getPassword()));
                deliveryPersonService.save(deliveryPersonDto);
                model.addAttribute("success", "Register successfully!");
            } else {
                model.addAttribute("error", "Password is incorrect");
                model.addAttribute("deliveryPersonDto", deliveryPersonDto);
                return "register";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Server is error, try again later!");
        }
        return "register";
    }

}
