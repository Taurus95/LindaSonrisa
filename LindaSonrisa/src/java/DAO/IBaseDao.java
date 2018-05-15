package DAO;

import java.util.List;

/**
 *
 * @author andres
 * @param <T>
 */

public interface IBaseDao<T> {

    public List<T> listar();

    public boolean agregar(T obj);

    public boolean modificar(T obj);
    
    public T buscar(T obj);

}
