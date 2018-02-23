package com.example.atmDemo.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Note {

	private int note1000Val = 1000;
	private int note500Val = 500;
	private int note100Val = 100;
	private int note50Val = 50;
	private int note20Val = 20;
	
	private int note1000Qy;
	private int note500Qy;
	private int note100Qy;
	private int note50Qy;
	private int note20Qy;
	
	private String error;
	
	public int getNote1000Val() {
		return note1000Val;
	}
	public void setNote1000Val(int note1000Val) {
		this.note1000Val = note1000Val;
	}
	public int getNote500Val() {
		return note500Val;
	}
	public void setNote500Val(int note500Val) {
		this.note500Val = note500Val;
	}
	public int getNote100Val() {
		return note100Val;
	}
	public void setNote100Val(int note100Val) {
		this.note100Val = note100Val;
	}
	public int getNote50Val() {
		return note50Val;
	}
	public void setNote50Val(int note50Val) {
		this.note50Val = note50Val;
	}
	public int getNote20Val() {
		return note20Val;
	}
	public void setNote20Val(int note20Val) {
		this.note20Val = note20Val;
	}
	public int getNote1000Qy() {
		return note1000Qy;
	}
	public void setNote1000Qy(int note1000Qy) {
		this.note1000Qy = note1000Qy;
	}
	public int getNote500Qy() {
		return note500Qy;
	}
	public void setNote500Qy(int note500Qy) {
		this.note500Qy = note500Qy;
	}
	public int getNote100Qy() {
		return note100Qy;
	}
	public void setNote100Qy(int note100Qy) {
		this.note100Qy = note100Qy;
	}
	public int getNote50Qy() {
		return note50Qy;
	}
	public void setNote50Qy(int note50Qy) {
		this.note50Qy = note50Qy;
	}
	public int getNote20Qy() {
		return note20Qy;
	}
	public void setNote20Qy(int note20Qy) {
		this.note20Qy = note20Qy;
	}	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "Note [note1000Val=" + note1000Val + ", note500Val=" + note500Val + ", note100Val=" + note100Val
				+ ", note50Val=" + note50Val + ", note20Val=" + note20Val + ", note1000Qy=" + note1000Qy
				+ ", note500Qy=" + note500Qy + ", note100Qy=" + note100Qy + ", note50Qy=" + note50Qy + ", note20Qy="
				+ note20Qy + ", error=" + error + "]";
	}
	
}
