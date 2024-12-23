package sn.faty.departmentService.Controlller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.faty.departmentService.dto.DepartementDTO;
import sn.faty.departmentService.exceptions.DepartementNotFoundException;
import sn.faty.departmentService.services.IDepartement;

import java.util.List;

@RequestMapping("departement")
@RestController
public class DepartementController {

    private IDepartement iDepartement ;

    @Autowired
    public DepartementController(IDepartement iDepartement) {
        this.iDepartement = iDepartement;
    }

    @PostMapping("add/")
    public ResponseEntity <DepartementDTO> addDepartement(@RequestBody DepartementDTO departementDTO){

        return  ResponseEntity.ok().body(iDepartement.addDepartement(departementDTO));

    }

    @GetMapping("getAll/")
    public ResponseEntity <List<DepartementDTO>> getAllDepartment(){

        return ResponseEntity.ok().body(iDepartement.getAllDepartements());

    }

    @GetMapping("getDepartementBy/{id}")
    public ResponseEntity<DepartementDTO> getDepartmentById(@PathVariable("id") Long id) throws DepartementNotFoundException {

        return ResponseEntity.ok().body(iDepartement.getDepartementById(id));

    }

    @GetMapping("getDepartementByCode/{code}")
    public ResponseEntity<DepartementDTO> getDepartmentByCode(@PathVariable("code") String code){

        return ResponseEntity.ok().body(iDepartement.getDepartementByCode(code));

    }

}
