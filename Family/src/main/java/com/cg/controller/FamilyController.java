package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Family;

@RestController
public class FamilyController {
	@GetMapping("/family")
	public Family getFamily() {
		Family f=new Family(4, "Bvrm", "Rao");
		return f;
	}
	@GetMapping("/families")
	public List<Family> getFamilies(){
		List<Family> fs=new ArrayList<>();
		
		fs.add(new  Family(3, "Bvrm", "Ramesh"));
		fs.add(new  Family(2, "Vizag", "Mahesh"));
		fs.add(new  Family(1, "Nellore", "Suresh"));
		fs.add(new  Family(5, "warangal", "Dheeresh"));
		
		return fs;
	}
	
	@GetMapping("/families/{familymem}/{familyadd}/{fathername}")
	public Family getById(@PathVariable("familymem") int Member, @PathVariable("familyadd") String address, @PathVariable("fathername") String name  ) {
		return new Family(Member, address, name);
	}

}
