package HomeWork_4;

import java.sql.SQLException;
import java.util.List;

public abstract class ProductDAO <E, K> {
    public abstract List <E> findAll() throws SQLException;
    public abstract E findById(K id) throws SQLException;
    public abstract void update(E prod) throws SQLException;
    public abstract void delete(K id) throws SQLException;
    public abstract void insert(E prod) throws SQLException;
}