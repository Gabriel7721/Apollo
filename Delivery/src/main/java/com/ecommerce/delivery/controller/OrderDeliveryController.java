package com.ecommerce.delivery.controller;

import com.ecommerce.library.dto.DeliveryPersonDto;
import com.ecommerce.library.dto.ProductDto;
import com.ecommerce.library.model.DeliveryPerson;
import com.ecommerce.library.model.Order;
import com.ecommerce.library.model.OrderDelivery;
import com.ecommerce.library.model.ShoppingCart;
import com.ecommerce.library.service.DeliveryPersonService;
import com.ecommerce.library.service.OrderDeliveryService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class OrderDeliveryController {
    private final OrderDeliveryService orderDeliveryService;
    private final DeliveryPersonService deliveryPersonService;
    @RequestMapping(value = "/save-order-delivery", method = RequestMethod.POST, params = "action=create")
    public String saveOrderDelivery(@RequestParam("deliveryPersonId") String riderEmail,
                             @RequestParam("orderId") Long orderId,
                             Model model,
                             Principal principal,
                             HttpSession session) {
        if (principal == null) {
            return "redirect:/login";
        }

        DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPerson(riderEmail);
        Order order = new Order();
        order.setId(orderId);

        OrderDelivery orderDelivery = orderDeliveryService.saveOrderDelivery(order, deliveryPerson);
        model.addAttribute("orderDelivery", orderDelivery);
        return "redirect:/order-delivery-detail";

    }
}
