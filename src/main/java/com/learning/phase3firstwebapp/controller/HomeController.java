package com.learning.phase3firstwebapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
	@GetMapping(value="/")
	public String indexMapping()
	{
		System.out.println("indexMaping executed ");
		return "server is up and running!";
	}
	@GetMapping(value="/hi")
	public String hiMapping()
	{
		System.out.println("hiMaping executed ");
		return "hi today is a good day !";
	}
	@GetMapping(value="/hello")
	public String helloMapping(@RequestParam("name")String name)
	{
		System.out.println("helloMaping with RequestParam executed with input name : "+name);
		return "hi user , "+name;
	}
	@GetMapping(value="/message")
	public String messageMapping(@RequestParam("message")String message)
	{
		System.out.println("messageMaping with RequestParam executed with input message : "+message);
		return "hi user , this is your message : "+message;
	}
	
	@GetMapping(value="/message/{id}")
	public String msgMapping(@PathVariable("id") int id)
	{
		if(id==1000)
		{
			System.out.println("in if statement of messageMaping with id : "+id);
			return "message of ID : "+id;
		}	
		else
		{
			System.out.println("in else statement of messageMaping with id : "+id);
			return "no message found";
		}
	}
}
