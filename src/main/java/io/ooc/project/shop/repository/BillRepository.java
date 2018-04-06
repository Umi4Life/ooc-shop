package io.ooc.project.shop.repository;

import io.ooc.project.shop.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("BillRepository")
public interface BillRepository extends JpaRepository<Bill,Long>{

}
