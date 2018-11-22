package com.spring.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.HeroAttrsEntity;
import com.spring.service.HeroAttrsService;

@RestController
@RequestMapping("/attrs")
public class HeroAttrsRest {

	@Autowired
	private HeroAttrsService heroAttrsService;
	
	@GetMapping("/{id}")
	@ResponseBody   
	public HeroAttrsEntity getAttrs(@PathVariable("id") int id){
		try {
			return heroAttrsService.GetAttrs(id);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@PostMapping
	public int addAttrs(@RequestBody HeroAttrsEntity heroAttrs){
		try {
			return heroAttrsService.AddAttrs(heroAttrs);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	@DeleteMapping("/{id}")
	public int deleteAttrs(@PathVariable("id") int id){
		try {
			return heroAttrsService.DeleteAttrs(id);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	@PutMapping
	public int updateAttrs(@RequestBody HeroAttrsEntity heroAttrs){
		try {
			return heroAttrsService.UpdateAttrs(heroAttrs);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return 0;
	}
}
