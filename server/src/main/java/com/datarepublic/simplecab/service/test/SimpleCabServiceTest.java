package com.datarepublic.simplecab.service.test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import org.springframework.test.context.junit4.SpringRunner;

import com.datarepublic.simplecab.repository.SimpleCabRepository;
import com.datarepublic.simplecab.service.SimpleCabService;
import com.datarepublic.simplecab.service.SimpleCabServiceImpl;
import com.hazelcast.core.HazelcastInstance;

@RunWith(SpringRunner.class)
public class SimpleCabServiceTest {

	@MockBean
	private SimpleCabRepository simpleCabRepository;

	@MockBean
	private HazelcastInstance hazelcastInstance;

	@Autowired
	private SimpleCabService simpleCabService;

	private static String MEDALLION = "1234567890";

	@org.springframework.boot.test.context.TestConfiguration
	static class SimpleCabServiceTestConfiguration {
		@Bean
		public SimpleCabService simpleCabService() {
			return new SimpleCabServiceImpl();
		}
	}

	@Test
	public void testGetCount() {
		Timestamp pickupDate = Timestamp.valueOf(LocalDateTime.now());
		Mockito.when(simpleCabRepository.getCountByMedallionAndPickupDate(Arrays.asList(MEDALLION), pickupDate))
				.thenReturn(1);
		int result = simpleCabRepository.getCountByMedallionAndPickupDate(Arrays.asList(MEDALLION), pickupDate);
		assert(result == 1);
	}

}
