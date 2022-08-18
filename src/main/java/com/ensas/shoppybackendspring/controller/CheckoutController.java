package com.ensas.shoppybackendspring.controller;

import com.ensas.shoppybackendspring.dtos.PurchaseDto;
import com.ensas.shoppybackendspring.dtos.PurchaseResponseDto;
import com.ensas.shoppybackendspring.services.imp.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class CheckoutController {

    private final CheckoutService checkoutService;
    @PostMapping("/purchase")
    public PurchaseResponseDto placeOrder(@RequestBody PurchaseDto purchaseDto){
        return checkoutService.placeOrder(purchaseDto);
    }
}
