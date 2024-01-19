package com.costcontrol.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.costcontrol.entities.Moventcost;

@Repository
public interface CostMovimentRepo extends CrudRepository<Moventcost, Integer> {

	@Query(value="SELECT m FROM Moventcost m WHERE m.dateregister >= :startDate AND m.dateregister <= :endDate")
	Iterable<Moventcost> findByDate(String startDate,String endDate);
	
	@Query(value="SELECT m, SUM(m.currencyvalue) as currency FROM Moventcost m WHERE m.dateregister >= :startDate AND m.dateregister <= :endDate GROUP BY m.direction ")
	Iterable<Moventcost> findByDateGrouped(String startDate,String endDate);
	

}
