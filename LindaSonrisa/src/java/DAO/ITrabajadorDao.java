package DAO;

import DTO.TrabajadorDto;

/**
 *
 * @author andres
 */
public interface ITrabajadorDao extends IBaseDao<TrabajadorDto> {

    public boolean deshabilitar(TrabajadorDto obj);
    public boolean habilitar(TrabajadorDto obj);
}
