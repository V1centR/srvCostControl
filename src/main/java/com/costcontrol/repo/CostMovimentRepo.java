package com.costcontrol.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.costcontrol.entities.Moventcost;

@Repository
public interface CostMovimentRepo extends CrudRepository<Moventcost, Integer> {

}
