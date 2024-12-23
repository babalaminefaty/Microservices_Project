package sn.faty.departmentService.services;

import sn.faty.departmentService.dto.DepartementDTO;
import sn.faty.departmentService.entity.Departement;
import sn.faty.departmentService.exceptions.DepartementNotFoundException;
import java.util.List;

public interface IDepartement{

    DepartementDTO addDepartement(DepartementDTO user) ;

    DepartementDTO getDepartementById(Long id) throws DepartementNotFoundException;

    DepartementDTO getDepartementByCode(String code) ;

    List<DepartementDTO> getAllDepartements() ;

    DepartementDTO updateDepartements(Departement user) ;

    void deleteDepartement(Long id) throws DepartementNotFoundException;

}
