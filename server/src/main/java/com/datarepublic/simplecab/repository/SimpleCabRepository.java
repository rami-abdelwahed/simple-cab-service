package com.datarepublic.simplecab.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.datarepublic.simplecab.entity.CabTripDataEntity;

public interface SimpleCabRepository extends CrudRepository<CabTripDataEntity, Long> {

  @Query("SELECT count(c) FROM CabTripDataEntity c WHERE c.medallion in :medallions and"
		  +" date(c.pickupDatetime) = :pickupDateFrom")
  Integer getCountByMedallionAndPickupDate(@Param("medallions") List<String> medallions,
													   @Param("pickupDateFrom") Date pickupDateFrom);
}
