package DAO;

import DTO.ProveedorDto;

/**
 *
 * @author andres
 */
public interface IProveedorDao extends IBaseDao<ProveedorDto> {

    public boolean deshabilitar(ProveedorDto obj);
    public boolean habilitar(ProveedorDto obj);
}
