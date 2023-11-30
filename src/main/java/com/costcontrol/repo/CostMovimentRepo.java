package com.costcontrol.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.costcontrol.entities.Moventcost;

@Repository
public interface CostMovimentRepo extends CrudRepository<Moventcost, Integer> {

	@Query(value="SELECT m FROM Moventcost m WHERE m.registerdate >= :startDate AND m.registerdate <= :endDate")
	Iterable<Moventcost> findByDate(String startDate,String endDate);
	
	

}
