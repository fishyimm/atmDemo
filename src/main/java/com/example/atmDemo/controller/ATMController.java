package com.example.atmDemo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.atmDemo.bean.Note;
import com.example.atmDemo.service.NoteService;
import com.example.atmDemo.service.WithdrawService;

@RestController
public class ATMController {

	@Autowired
	WithdrawService withdrawService;
	
	@Autowired
	NoteService noteService;
	
	@RequestMapping("/addNote")
	public Note addNote(@RequestBody Map<String, String> requestBody, HttpServletResponse response) {
		Note note = new Note();
		if(requestBody != null && requestBody.get("note20Qy") != null && requestBody.get("note50Qy") != null) {
			int note1000Qy = Integer.valueOf(requestBody.get("note1000Qy").toString());
			int note500Qy = Integer.valueOf(requestBody.get("note500Qy").toString());
			int note100Qy = Integer.valueOf(requestBody.get("note100Qy").toString());
			int note50Qy = Integer.valueOf(requestBody.get("note50Qy").toString());
			int note20Qy = Integer.valueOf(requestBody.get("note20Qy").toString());
			
			note.setNote1000Qy(note1000Qy);
			note.setNote500Qy(note500Qy);
			note.setNote100Qy(note100Qy);
			note.setNote50Qy(note50Qy);
			note.setNote20Qy(note20Qy);
			
			noteService.setNote1000Qy(note1000Qy);
			noteService.setNote500Qy(note500Qy);
			noteService.setNote100Qy(note100Qy);
			noteService.setNote50Qy(note50Qy);
			noteService.setNote20Qy(note20Qy);
		}
		
		return note;
	}
	
	@RequestMapping("/getmoney")
	public Note withdraw(@RequestBody Map<String, String> requestBody, HttpServletResponse response) {
		Note note = null;
		if(requestBody.get("amount") != null) {
			note = withdrawService.withdraw(Integer.valueOf(requestBody.get("amount").toString()));
			if(note != null) {
				note.setNote1000Qy(noteService.getNote1000Qy());
				note.setNote500Qy(noteService.getNote500Qy());
				note.setNote100Qy(noteService.getNote100Qy());
				note.setNote50Qy(noteService.getNote50Qy());
				note.setNote20Qy(noteService.getNote20Qy());
			}
		}
		
		return note;
	}
	
}
