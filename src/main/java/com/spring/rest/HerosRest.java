package com.spring.rest;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.entity.HerosEntity;
import com.spring.service.HerosService;
import com.spring.util.FileUtils;

@RestController
@RequestMapping("/heros")
public class HerosRest {
	
	@Autowired
	private HerosService herosService;
	
	@GetMapping("/all/{categoryId}")
	@ResponseBody
	public List<HerosEntity> getAllHeros(@PathVariable("categoryId") int categoryId){
		try {
			return herosService.HerosGetAll(categoryId);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public HerosEntity getHeros(@PathVariable("id") int id){
		try {
			return herosService.HerosGet(id);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@PostMapping
	public int addHeros(@RequestBody HerosEntity heros){
		try {
			return herosService.HerosAdd(heros);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	@PutMapping()
	public int updateHeros(@RequestBody HerosEntity heros){
		try {
			return herosService.HerosUpdate(heros);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	@DeleteMapping("/{id}")
	public int deleteHeros(@PathVariable("id") int id){
		try {
			return herosService.HerosDelete(id);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return id;
	}
	
	//图片上传
	@PostMapping("/file")
	@ResponseBody
    public String uploadImg(@RequestParam("file") MultipartFile file,
            HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = "./src/main/resources/static/img/";
        try {
            FileUtils.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        //返回json
        		
        return "img/"+fileName;
    }
	
	
}

