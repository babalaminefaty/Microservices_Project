package sn.faty.departmentService.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.faty.departmentService.dto.DepartementDTO;
import sn.faty.departmentService.entity.Departement;
import sn.faty.departmentService.exceptions.DepartementNotFoundException;
import sn.faty.departmentService.repository.DepartementRepository;
import sn.faty.departmentService.services.IDepartement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentImpl implements IDepartement {

    private DepartementRepository departementRepository ;
    private ModelMapper modelMapper ;

    @Autowired
    public DepartmentImpl(DepartementRepository departementRepository, ModelMapper modelMapper) {
        this.departementRepository = departementRepository;
        this.modelMapper= modelMapper ;
    }

    @Override
    public DepartementDTO addDepartement(DepartementDTO departementDTO) {

        Departement departement= modelMapper.map(departementDTO,Departement.class) ;

        Departement deprtmentSaved= departementRepository.save(departement);

        DepartementDTO departmentDTO= modelMapper.map(deprtmentSaved, DepartementDTO.class);

        return departmentDTO;
    }

    @Override
    public DepartementDTO getDepartementById(Long id) throws DepartementNotFoundException {

        Optional<Departement> departmentOptional= departementRepository.findById(id) ;

        if(departmentOptional.isEmpty()){

            throw new DepartementNotFoundException() ;
        }

        return modelMapper.map(departmentOptional.get(),DepartementDTO.class) ;
    }

    /**
     * @param code
     * @return
     */
    @Override
    public DepartementDTO getDepartementByCode(String code) {
        Departement departement= departementRepository.findDepartementByDepartementCode(code);

         return  modelMapper.map(departement, DepartementDTO.class) ;
    }

    /**
     * @return
     */

    @Override
    public List<DepartementDTO> getAllDepartements() {
        return departementRepository.findAll().stream().
                map(departement -> modelMapper.map(departement, DepartementDTO.class)).collect(Collectors.toList());
    }

    /**
     * @param user
     * @return
     */
    @Override
    public DepartementDTO updateDepartements(Departement user) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteDepartement(Long id) throws DepartementNotFoundException {

        departementRepository.findById(id).orElseThrow( () -> new DepartementNotFoundException()) ;

        departementRepository.deleteById(id);
    }
}
