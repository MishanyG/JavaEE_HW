package HomeWork_4;

import java.util.List;

public abstract class OrderDAO <E, K> {
    public abstract List <E> findAll();
    public abstract E findById(K id);
    public abstract void updateOrd(E ord);
    public abstract void deleteOrd(K id);
    public abstract void insertOrd(E ord);
}