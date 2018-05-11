package DAO;

import DTO.ProveedorDto;

/**
 *
 * @author andres
 */
public interface IProveedorDao extends IBaseDao<ProveedorDto> {

    public boolean deshabilitar(ProveedorDto obj);
}
