package com.datarepublic.simplecab.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;

@Configuration
public class HazelcastConfiguration {

	@Bean
	public Config config() {
		return new Config().addMapConfig(
				new MapConfig()
						.setName("trip-count")
						.setEvictionPolicy(EvictionPolicy.LRU)
						.setTimeToLiveSeconds(2400))
						.setProperty("hazelcast.logging.type","slf4j");
	}
}
