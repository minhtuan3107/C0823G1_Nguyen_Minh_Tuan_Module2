package Furama.repositories;

import Furama.models.Contract;

import java.util.List;

public interface IContractRepository {
    void add(Contract contract);

    void edit(String id, Contract contract);

    List<Contract> getList();
}
