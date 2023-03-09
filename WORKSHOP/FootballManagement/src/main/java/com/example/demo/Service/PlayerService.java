package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.PlayerEntity;
import com.example.demo.Repository.PlayerRepo;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepo stu;
	
	 public PlayerEntity saveDetails(PlayerEntity s)
	 {
	 	return stu.save(s);
	 }
	 public List<PlayerEntity> getAllDetails()
	 {
	 	return stu.findAll();
	 }
	
	 public PlayerEntity updateStudent(int id, PlayerEntity student) {
	        return stu.saveAndFlush(student);
	    }
	 public void deleteDepartmentById(int id)
	    {
	        stu.deleteById(id);
	    }
	 public List<PlayerEntity> getDetails(int pageNo,int pageSize){
		 Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize);
		 Page<PlayerEntity> page = stu.findAll(pageable);
		 List<PlayerEntity> players = page.getContent();
		 return players;
	 }
	 
	 public List<PlayerEntity> findDetailsWithSorting(String field){
		 return stu.findAll(Sort.by(Sort.Direction.ASC,field));
	 }
	 
	 public List<PlayerEntity> findPlayersNative(String club){
		 return stu.findAllPlayersNative(club);
	 }
}
