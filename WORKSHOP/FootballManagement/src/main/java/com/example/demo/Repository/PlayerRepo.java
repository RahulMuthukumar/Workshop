package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.PlayerEntity;

public interface PlayerRepo extends JpaRepository<PlayerEntity, Integer> {
	@Query(
			value="SELECT * from player where Gender= ?1",
			nativeQuery=true)
	List<PlayerEntity> findAllPlayersNative(@Param("club") String club); 
	
	
}

