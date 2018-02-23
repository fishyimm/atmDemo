package com.example.atmDemo.service;

import org.springframework.stereotype.Service;

@Service
public class NoteService {
	
	private int note20Val = 20;
	private int note50Val = 50;
	private int note100Val = 100;
	private int note500Val = 500;
	private int note1000Val = 1000;
	
	private static int note20Qy;
	private static int note50Qy;
	private static int note100Qy;
	private static int note500Qy;
	private static int note1000Qy;
	
	public int getNote20Val() {
		return note20Val;
	}
	public void setNote20Val(int note20Val) {
		this.note20Val = note20Val;
	}
	public int getNote50Val() {
		return note50Val;
	}
	public void setNote50Val(int note50Val) {
		this.note50Val = note50Val;
	}
	public int getNote100Val() {
		return note100Val;
	}
	public void setNote100Val(int note100Val) {
		this.note100Val = note100Val;
	}
	public int getNote500Val() {
		return note500Val;
	}
	public void setNote500Val(int note500Val) {
		this.note500Val = note500Val;
	}
	public int getNote1000Val() {
		return note1000Val;
	}
	public void setNote1000Val(int note1000Val) {
		this.note1000Val = note1000Val;
	}
	public static int getNote20Qy() {
		return note20Qy;
	}
	public static void setNote20Qy(int note20Qy) {
		NoteService.note20Qy = note20Qy;
	}
	public static int getNote50Qy() {
		return note50Qy;
	}
	public static void setNote50Qy(int note50Qy) {
		NoteService.note50Qy = note50Qy;
	}
	public static int getNote100Qy() {
		return note100Qy;
	}
	public static void setNote100Qy(int note100Qy) {
		NoteService.note100Qy = note100Qy;
	}
	public static int getNote500Qy() {
		return note500Qy;
	}
	public static void setNote500Qy(int note500Qy) {
		NoteService.note500Qy = note500Qy;
	}
	public static int getNote1000Qy() {
		return note1000Qy;
	}
	public static void setNote1000Qy(int note1000Qy) {
		NoteService.note1000Qy = note1000Qy;
	}

	@Override
	public String toString() {
		return "NoteService [note20Val=" + note20Val + ", note50Val=" + note50Val + ", note100Val=" + note100Val
				+ ", note500Val=" + note500Val + ", note1000Val=" + note1000Val + ", note20Qy=" + note20Qy
				+ ", note50Qy=" + note50Qy + ", note100Qy=" + note100Qy + ", note500Qy=" + note500Qy + ", note1000Qy="
				+ note1000Qy + "]";
	}	
}
