package Furama.repositories;

import Furama.models.person.Customer;
import Furama.models.Promotion;

import java.util.List;

public interface IPromotionRepository {
    List<Customer> displayCustomerUserService();

    List<Customer> displayCustomerGetVoucher(Promotion promotion);
}
