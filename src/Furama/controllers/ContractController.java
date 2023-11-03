package Furama.controllers;

import Furama.models.Contract;
import Furama.services.IContractService;
import Furama.services.impl.ContractService;

import java.util.List;

public class ContractController {
    private final IContractService contractService = new ContractService();

    public void add(Contract contract) {
        contractService.add(contract);
    }

    public void edit(String id, Contract contract) {
        contractService.edit(id, contract);
    }

    public List<Contract> getList() {
        return contractService.getList();
    }
}

