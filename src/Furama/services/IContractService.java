package Furama.services;

import Furama.models.Contract;

import java.util.List;

public interface IContractService {
    boolean add(Contract contract);

    void edit(String id, Contract contract);

    List<Contract> getList();
}
