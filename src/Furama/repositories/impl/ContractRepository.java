package Furama.repositories.impl;

import Furama.models.Contract;
import Furama.repositories.IContractRepository;
import Furama.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    private final String COMMA = ",";
    private final String FILE = "D:\\module2Again\\src\\Furama\\utils\\DataContract.csv";

    @Override
    public boolean add(Contract contract) {
        List<Contract> contractList = getList();
        for (Contract contract1 : contractList) {
            if (contract1.getId().equals(contract.getId())) {
                return false;
            }
        }
        List<Contract> contractList1 = new ArrayList<>();
        contractList1.add(contract);
        ReadAndWrite.write(convertToString(contractList1), FILE, true);
        return true;
    }

    @Override
    public void edit(String id, Contract contract) {
        List<Contract> contractList = getList();
        for (Contract contract1 : contractList) {
            if (contract1.getId().equals(id)) {
                contract1.setIdBooking(contract.getIdBooking());
                contract1.setDeposit(contract.getDeposit());
                contract1.setPrice(contract.getPrice());
            }
        }
    }

    @Override
    public List<Contract> getList() {
        List<String> stringList = ReadAndWrite.read(FILE);
        List<Contract> contractList = convertToObject(stringList);
        return contractList;
    }

    public List<String> convertToString(List<Contract> contractList) {
        List<String> stringList = new ArrayList<>();
        for (Contract contract : contractList) {
            stringList.add(contract.getId() + COMMA +
                    contract.getIdBooking() + COMMA +
                    contract.getDeposit() + COMMA +
                    contract.getPrice());
        }
        return stringList;
    }

    public List<Contract> convertToObject(List<String> stringList) {
        List<Contract> contractList = new ArrayList<>();
        String[] line;
        for (String str : stringList) {
            line = str.split(COMMA);
            contractList.add(new Contract(line[0], line[1], line[2], line[3]));
        }
        return contractList;
    }
}
