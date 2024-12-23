package sn.faty.departmentService.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.faty.departmentService.entity.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,Long> {

    Departement findDepartementByDepartementCode(String code) ;
}
