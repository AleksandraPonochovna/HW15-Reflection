package dao;

import java.util.List;

public interface DaoInterface<T> {
    void add(T name);
    List<T> getAll();
}
