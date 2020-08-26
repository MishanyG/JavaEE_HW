package HomeWork_4;

import java.sql.SQLException;
import java.util.List;

public abstract class CategoryDAO <E, K> {
    public abstract List <E> findAll() throws SQLException;
    public abstract E findById(K id) throws SQLException;
    public abstract void updateCat(E cat) throws SQLException;
    public abstract void deleteCat(K id) throws SQLException;
    public abstract void insertCat(E cat) throws SQLException;
}