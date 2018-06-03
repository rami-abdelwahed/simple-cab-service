package com.datarepublic.simplecab.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datarepublic.simplecab.entity.CabTripDataEntity;
import com.datarepublic.simplecab.service.SimpleCabService;

@Controller
@RequestMapping(path="/cabservice")
public class CabServiceController {

	@Autowired
	private SimpleCabService simpleCabService;

	@PostMapping("/query")
	public @ResponseBody Integer getMedallions (@RequestParam String[] medallions,
																@RequestParam String pickupDate,
																@RequestParam boolean ignoreCache)
			throws ParseException {
		return simpleCabService.getMedallionsSummary(pickupDate, ignoreCache, medallions);
	}

	@GetMapping("/clearcache")
	public @ResponseBody String clearCache () {
		simpleCabService.deleteCache();
		return "Cache invalidated.";
	}

}
