package Furama.repositories;

import Furama.models.Contract;

import java.util.List;

public interface IContractRepository {
    boolean add(Contract contract);

    void edit(String id, Contract contract);

    List<Contract> getList();
}
