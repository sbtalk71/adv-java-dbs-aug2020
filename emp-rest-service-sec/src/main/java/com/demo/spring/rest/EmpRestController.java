package com.demo.spring.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dao.EmpRepository;
import com.demo.spring.entity.Emp;

@RestController
@RequestMapping("/emp")
public class EmpRestController {

	@Autowired
	private EmpRepository repo;

	@GetMapping(path = "/find/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findEmpById(@PathVariable("empId") int id) {

		Optional<Emp> empOp = repo.findById(id);

		if (empOp.isPresent()) {
			return ResponseEntity.ok(empOp.get());
		} else {
			return ResponseEntity.ok("Emp Not Found..");
		}
	}

	@PostMapping(path = "/save", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity saveEmpToDb(@RequestBody Emp e) {
		if (repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Employee already exists..");
		} else {
			repo.save(e);
			return ResponseEntity.ok("Employee saved successfully..");
		}
	}

	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findAll() {
		return ResponseEntity.ok(repo.findAll());
	}

	@DeleteMapping(path = "/remove", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity deleteEmp(@RequestParam("id") int empId) {
		if (repo.existsById(empId)) {
			repo.deleteById(empId);
			return ResponseEntity.ok("Emp deleted..");
		} else {
			return ResponseEntity.ok("Emp does not exist..");
		}
	}
	
	@PutMapping(path="/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = "text/plain")
	public ResponseEntity updateEmp(@RequestBody Emp e) {
		repo.save(e);
		return ResponseEntity.ok("Employee updated successfully..");
	}
}
