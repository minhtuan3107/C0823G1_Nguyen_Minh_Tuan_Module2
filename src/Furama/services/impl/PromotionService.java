package Furama.services.impl;

import Furama.models.person.Customer;
import Furama.models.Promotion;
import Furama.repositories.IPromotionRepository;
import Furama.repositories.impl.PromotionRepository;
import Furama.services.IPromotionService;

import java.util.List;

public class PromotionService implements IPromotionService {
    private final IPromotionRepository promotionRepository = new PromotionRepository();

    @Override
    public List<Customer> displayCustomerUserService() {
        return promotionRepository.displayCustomerUserService();
    }

    @Override
    public List<Customer> displayCustomerGetVoucher(Promotion promotion) {
        return promotionRepository.displayCustomerGetVoucher(promotion);
    }
}
