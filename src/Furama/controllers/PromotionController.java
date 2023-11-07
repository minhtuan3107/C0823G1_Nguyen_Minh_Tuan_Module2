package Furama.controllers;

import Furama.models.Customer;
import Furama.models.Promotion;
import Furama.services.IPromotionService;
import Furama.services.impl.PromotionService;

import java.util.List;

public class PromotionController {
    private final IPromotionService promotionService = new PromotionService();

    public List<Customer> displayCustomerUserService() {
        return promotionService.displayCustomerUserService();
    }

    public List<Customer> displayCustomerGetVoucher(Promotion promotion) {
        return promotionService.displayCustomerGetVoucher(promotion);
    }
}
