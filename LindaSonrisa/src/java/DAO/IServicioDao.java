package DAO;

import DTO.ServicioDto;

/**
 *
 * @author andres
 */
public interface IServicioDao extends IBaseDao<ServicioDto> {

    public boolean deshabilitar(ServicioDto obj);
    
    public boolean habilitar(ServicioDto obj);
    
}
