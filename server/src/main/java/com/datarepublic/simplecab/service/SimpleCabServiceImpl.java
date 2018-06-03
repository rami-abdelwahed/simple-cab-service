package com.datarepublic.simplecab.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datarepublic.simplecab.entity.CabTripDataCacheEntity;
import com.datarepublic.simplecab.repository.SimpleCabRepository;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Service
public class SimpleCabServiceImpl implements SimpleCabService {

	@Autowired
	private SimpleCabRepository simpleCabRepository;

	@Autowired
	private HazelcastInstance hazelcastInstance;

	private IMap<Object, CabTripDataCacheEntity> cache;
	private SimpleDateFormat dateFormat;

	@PostConstruct
	public void initService() {
		cache = hazelcastInstance.getMap("trip-count");
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}

	private void updateCache(String pickupDate, String[] medallions, int tripCount) {
		CabTripDataCacheEntity entity = getFromCache(pickupDate, medallions);
		if (entity == null) {
			entity = new CabTripDataCacheEntity();
			entity.setId(generateCacheId(pickupDate, medallions));
		}
		entity.setTripCount(tripCount);
		cache.put(generateCacheId(pickupDate, medallions), entity);
	}


	private CabTripDataCacheEntity getFromCache(String pickupDate, String[] medallions) {
		long cacheId = generateCacheId(pickupDate, medallions);
		CabTripDataCacheEntity entity = null;
		if (cache.containsKey(cacheId)) {
			entity = cache.get(cacheId);
		}
		return entity;
	}

	private long generateCacheId(String pickupDate, String[] medallions) {
		long cacheId = Objects.hash(pickupDate);
		for (String medallion : medallions) {
			cacheId += Objects.hash(medallion);
		}
		return cacheId;
	}

	@Override
	public void deleteCache() {
		IMap<Object, Object> cache = hazelcastInstance.getMap("trip-count");
		cache.clear();
	}

	@Override
	public Integer getMedallionsSummary(String pickupDate, boolean ignoreCache, String... medallions) throws ParseException {
		Objects.requireNonNull(pickupDate, "Pickup date cannot be null.");
		Objects.requireNonNull(medallions, "Medallions list cannot be null.");
		int result = 0;
		if (medallions.length > 0) {
			if (ignoreCache) {
				Date fromDate = dateFormat.parse(pickupDate);
				result = simpleCabRepository.getCountByMedallionAndPickupDate(Arrays.asList(medallions), fromDate);
				updateCache(pickupDate, medallions, result);
			} else {
				CabTripDataCacheEntity entity = getFromCache(pickupDate, medallions);
				result = entity == null ? getMedallionsSummary(pickupDate, medallions) : entity.getTripCount();
			}
		}
		return result;
	}

	@Override
	public Integer getMedallionsSummary(String pickupDate, String... medallions) throws ParseException {
		return getMedallionsSummary(pickupDate, true, medallions);
	}
}
