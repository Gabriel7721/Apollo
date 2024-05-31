package com.ecommerce.delivery.controller;

import com.ecommerce.library.dto.CustomerDto;
import com.ecommerce.library.dto.DeliveryPersonDto;
import com.ecommerce.library.model.City;
import com.ecommerce.library.model.Country;
import com.ecommerce.library.service.CityService;
import com.ecommerce.library.service.CountryService;
import com.ecommerce.library.service.DeliveryPersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DeliveryPersonController {
    private final DeliveryPersonService deliveryPersonService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        String username = principal.getName();
        DeliveryPersonDto deliveryPersonDto = deliveryPersonService.getDeliveryPerson(username);
        model.addAttribute("deliveryPerson", deliveryPersonDto);
        model.addAttribute("title", "Profile");
        model.addAttribute("page", "Profile");
        return "rider-information";

    }

    @PostMapping("/update-profile")
    public String updateProfile(@Valid @ModelAttribute("deliveryPerson") DeliveryPersonDto deliveryPersonDto,
                                BindingResult result,
                                RedirectAttributes attributes,
                                Model model,
                                Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        String username = principal.getName();
        DeliveryPersonDto deliveryPerson = deliveryPersonService.getDeliveryPerson(username);
        if (result.hasErrors()) {
            return "rider-information";
        }
        deliveryPersonService.update(deliveryPersonDto);
        DeliveryPersonDto deliveryUpdate = deliveryPersonService.getDeliveryPerson(principal.getName());
        attributes.addFlashAttribute("success", "Update successfully!");
        model.addAttribute("deliveryPerson", deliveryUpdate);
        return "redirect:/profile";
    }


    @GetMapping("/change-password")
    public String changePassword(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        model.addAttribute("title", "Change password");
        model.addAttribute("page", "Change password");
        return "change-password";
    }

    @PostMapping("/change-password")
    public String changePass(@RequestParam("oldPassword") String oldPassword,
                             @RequestParam("newPassword") String newPassword,
                             @RequestParam("repeatNewPassword") String repeatPassword,
                             RedirectAttributes attributes,
                             Model model,
                             Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        } else {
            DeliveryPersonDto rider = deliveryPersonService.getDeliveryPerson(principal.getName());
            if (passwordEncoder.matches(oldPassword, rider.getPassword())
                    && !passwordEncoder.matches(newPassword, oldPassword)
                    && !passwordEncoder.matches(newPassword, rider.getPassword())
                    && repeatPassword.equals(newPassword) && newPassword.length() >= 5) {
                rider.setPassword(passwordEncoder.encode(newPassword));
                deliveryPersonService.changePass(rider);
                attributes.addFlashAttribute("success", "Your password has been changed successfully!");
                return "redirect:/profile";
            } else {
                model.addAttribute("message", "Your password is wrong");
                return "change-password";
            }
        }
    }
}
