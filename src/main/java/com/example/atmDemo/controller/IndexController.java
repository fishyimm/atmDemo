package com.example.atmDemo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.atmDemo.service.NoteService;

@Controller
public class IndexController {

	@Autowired
	NoteService noteService;
	
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		model.put("note1000Qy", noteService.getNote1000Qy() != 0 ? noteService.getNote1000Qy() : 0);
		model.put("note500Qy", noteService.getNote500Qy() != 0 ? noteService.getNote500Qy() : 0);
		model.put("note100Qy", noteService.getNote100Qy() != 0 ? noteService.getNote100Qy() : 0);
		model.put("note50Qy", noteService.getNote50Qy() != 0 ? noteService.getNote50Qy() : 0);
		model.put("note20Qy", noteService.getNote20Qy() != 0 ? noteService.getNote20Qy() : 0);
		return "index";
	}
	
	@RequestMapping("/template/{path}")
	public String path(@PathVariable(value="path") String path, Map<String, Integer> model) {
		model.put("note1000Qy", noteService.getNote1000Qy());
		model.put("note500Qy", noteService.getNote500Qy());
		model.put("note100Qy", noteService.getNote100Qy());
		model.put("note50Qy", noteService.getNote50Qy());
		model.put("note20Qy", noteService.getNote20Qy());
		return path;
	}

}
