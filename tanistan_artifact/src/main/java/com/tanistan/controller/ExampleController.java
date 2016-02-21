package com.tanistan.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tanistan.repository.Example;
import com.tanistan.repository.ExampleRepository;


@Controller
public class ExampleController {

	Logger logger = Logger.getLogger("ExampleController.java");
	
	@Autowired
	ExampleRepository repo;
	
	public class User {
		String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		int age;
	}
	
	@RequestMapping(value = "/greeting/{user}", method = RequestMethod.GET)
	public @ResponseBody String greeting(@PathVariable User user){
		logger.info("********* First Test Log... *************");
		Example ex = new Example();
		ex.setName(user.getName());
		repo.testSave(ex);
		
		
		return "Greetings...!! from "+ user.getName() + "jrebel run";
	}

}
