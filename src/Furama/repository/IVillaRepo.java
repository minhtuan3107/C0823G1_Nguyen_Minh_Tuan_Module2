package Furama.repository;

import Furama.model.Facility;
import Furama.model.Villa;

import java.util.LinkedHashMap;

public interface IVillaRepo {
    void add(Villa villa);

    void delete(String id);

    LinkedHashMap<Facility, Villa> getList();

    void edit(String id, Villa villa);
}
