package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.PlayerEntity;
import com.example.demo.Service.PlayerService;


@RestController
@CrossOrigin
public class PlayerController {
	@Autowired
	private PlayerService stuservice;
	
	 @PostMapping("/addPlayer")
	 public String postDetails(@RequestBody PlayerEntity s)
	 {
	 	stuservice.saveDetails(s);
	 	return "Value Added";
	 	
	 }
	
	 @GetMapping("/getPlayer")
	 public List<PlayerEntity> getDetails()
	 {
		
	 	return stuservice.getAllDetails();
	 }
	
	@PutMapping("update/{id}")
    public PlayerEntity updateStudent(@PathVariable int id, @RequestBody PlayerEntity student) {
        return stuservice.updateStudent(id, student);
    }
	
	@DeleteMapping("/DelPlayer/{id}")
	public String DelStud(@PathVariable int id) {
		stuservice.deleteDepartmentById(id);
		
		return "Deleted";
	}
	
	@GetMapping("/paging/{pn}/{ps}")
	public List<PlayerEntity> paging(@PathVariable int pn, @PathVariable int ps){
		return stuservice.getDetails(pn, ps);
	}
	
	//Sort by any field name
	@GetMapping("/sortPlayer/{field}")

	public List<PlayerEntity> getDetailsWithSort(@PathVariable String field)
	{
	List<PlayerEntity> allProducts = stuservice.findDetailsWithSorting(field);
	return allProducts;
	}
	
	@GetMapping("/native/{club}")
	public List<PlayerEntity> findPlayersNative(@PathVariable String club){
		return stuservice.findPlayersNative(club);
	}
}
