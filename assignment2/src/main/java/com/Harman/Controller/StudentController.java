package com.Harman.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Harman.Controller.StudentService;
import com.Harman.model.Details;


@RestController

public class StudentController {

	@RequestMapping("/hello")
	public String sayhi() {
		return "hello!!!";
	}
	
	@Autowired
	private StudentService Service;
	
	@RequestMapping("/details")//display all details
	public List<Details> getAlldetails() {
		return Service.getAlldetails();
		//"all the topics";
	}
	
	@RequestMapping("/details/{id}")//display specific topic
	public Details getdetail(@PathVariable String id) {
		return Service.getdetail(id)
;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/details")//add detail
	public void addDetail(@RequestBody Details d) {
		Service.addDetail(d);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/details/{id}")//delete detail
	public void adddetail( @PathVariable String id) {
		Service.deletedetail(id);
	}
}

