package DAO;

import DTO.ClienteDto;

/**
 *
 * @author andres
 */
public interface IClienteDao extends IBaseDao<ClienteDto> {

    public boolean deshabilitar(ClienteDto cliente);
    
    public boolean habilitar(ClienteDto cliente);
    

}
