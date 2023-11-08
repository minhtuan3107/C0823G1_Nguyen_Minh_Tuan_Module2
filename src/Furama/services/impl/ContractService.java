package Furama.services.impl;

import Furama.models.Contract;
import Furama.repositories.IContractRepository;
import Furama.repositories.impl.ContractRepository;
import Furama.services.IContractService;

import java.util.List;

public class ContractService implements IContractService {
    private final IContractRepository contractRepository = new ContractRepository();

    @Override
    public boolean add(Contract contract) {
        return contractRepository.add(contract);
    }

    @Override
    public void edit(String id, Contract contract) {
        contractRepository.edit(id, contract);
    }

    @Override
    public List<Contract> getList() {
        return contractRepository.getList();
    }

}
