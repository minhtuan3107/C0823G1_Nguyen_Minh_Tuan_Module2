package Furama.services;

import Furama.models.Customer;
import Furama.models.Promotion;

import java.util.List;

public interface IPromotionService {
    List<Customer> displayCustomerUserService();

    List<Customer> displayCustomerGetVoucher(Promotion promotion);
}
