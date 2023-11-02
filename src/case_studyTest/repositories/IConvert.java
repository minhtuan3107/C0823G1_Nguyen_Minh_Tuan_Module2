package case_studyTest.repositories;

import java.util.List;

public interface IConvert<E> {
    List<E> convertToObject(List<String> strings);

    List<String> convertToString(List<E> e);
}
