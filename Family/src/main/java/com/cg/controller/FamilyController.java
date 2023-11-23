package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Family;

@RestController
@RequestMapping("/families")
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
	//http://localhost:8080/families/query?familymem=3&familyadd=bhsd&fathername=ed
	@GetMapping("/families/query")
	public Family param(@RequestParam int familymem, @RequestParam String familyadd, @RequestParam String fathername ) {
		return new Family(familymem, familyadd, fathername);
		
	}
	
	//
	@GetMapping("/families/create")
	public Family createFamily(@RequestBody Family f) {
		System.out.println(f.getFamilyadd());
		System.out.println(f.getFamilyadd());
		System.out.println(f.getFathername());
		return f;
	}
	@PutMapping("/families/{familymem}/update")
	public Family updateFamily(@RequestBody Family f, int familymem) {
		System.out.println(f.getFamilyadd());
		System.out.println(f.getFathername());
		return f;
	}
	@DeleteMapping("/families/{familymem}/delete")
	public String deleteFamily(@PathVariable("familymem") int Member) {
		System.out.println(Member);
		return "Sucessfully Deleted";
	}

}
