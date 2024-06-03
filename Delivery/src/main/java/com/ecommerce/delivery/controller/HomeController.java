package com.ecommerce.delivery.controller;

import com.ecommerce.library.model.DeliveryPerson;
import com.ecommerce.library.model.Order;
import com.ecommerce.library.service.DeliveryPersonService;
import com.ecommerce.library.service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final DeliveryPersonService deliveryPersonService;
    private final OrderService orderService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String home(Model model, Principal principal, HttpSession session) {
        model.addAttribute("title", "Home");
        model.addAttribute("page", "Home");
        model.addAttribute("order", orderService.findALlOrders());
        if (principal != null) {
            String username = principal.getName();
            DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPerson(username);
            model.addAttribute("deliveryPerson", deliveryPerson);
//            session.setAttribute("username", rider.getFirstName() + " " + rider.getLastName());
//            session.setAttribute("riderEmail", deliveryPerson.getUsername());
        }
        return "home";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact");
        model.addAttribute("page", "Contact");
        return "contact-us";
    }

}
