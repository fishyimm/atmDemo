package com.example.atmDemo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atmDemo.bean.Note;

@Service
public class WithdrawService {

	@Autowired
	NoteService noteService;
	
//	version3
	public Note withdraw(int withdrawAmount) {
		int remainingAmount = 0;
		int tempVal;
		int tempRemainingNoteQy;
		final Note note = new Note();
		Map<Integer, Integer> noteToWithdraw = new HashMap<Integer, Integer>();

		if (withdrawAmount != 0) {
			if (withdrawAmount >= 1000 && noteService.getNote1000Qy() != 0) {
				remainingAmount = withdrawAmount % noteService.getNote1000Val();
				tempRemainingNoteQy = withdrawAmount / noteService.getNote1000Val();
				
				if (noteService.getNote1000Qy() >= tempRemainingNoteQy) {
					noteToWithdraw.put(1000, tempRemainingNoteQy);
				} else {
					if((noteService.getNote1000Val() * noteService.getNote1000Qy()) < withdrawAmount ) {
						noteToWithdraw.put(1000, noteService.getNote1000Qy());
						remainingAmount = withdrawAmount - (noteService.getNote1000Val() * noteService.getNote1000Qy());
					}
				}
			} else {
				remainingAmount = withdrawAmount;
			}

			if (remainingAmount >= 500 && noteService.getNote500Qy() != 0) {
				tempVal = remainingAmount % noteService.getNote500Val();
				tempRemainingNoteQy = remainingAmount / noteService.getNote500Val();
				
				if (noteService.getNote500Qy() >= tempRemainingNoteQy) {
					noteToWithdraw.put(500, tempRemainingNoteQy);
					remainingAmount = tempVal;

					System.out.println("500 remainingAmount " + remainingAmount);
				} else {
					if((noteService.getNote500Val() * noteService.getNote500Qy()) < remainingAmount ) {
						noteToWithdraw.put(500, noteService.getNote500Qy());
						remainingAmount = remainingAmount - (noteService.getNote500Val() * noteService.getNote500Qy());
					}					
				}
			}

			if (remainingAmount >= 100 && noteService.getNote100Qy() != 0) {
				tempVal = remainingAmount % noteService.getNote100Val();
				tempRemainingNoteQy = remainingAmount / noteService.getNote100Val();
						
				if (noteService.getNote100Qy() >= tempRemainingNoteQy) {
					noteToWithdraw.put(100, tempRemainingNoteQy);
					remainingAmount = tempVal;

					System.out.println("100 remainingAmount " + remainingAmount);
				} else {
					if((noteService.getNote100Val() * noteService.getNote100Qy()) < remainingAmount ) {
						noteToWithdraw.put(100, noteService.getNote100Qy());
						remainingAmount = remainingAmount - (noteService.getNote100Val() * noteService.getNote100Qy());
					}	
				}
			}

			if ((remainingAmount >= 50 || remainingAmount >= 100) && remainingAmount != 60 && remainingAmount != 80 && noteService.getNote50Qy() != 0) {
				tempVal = remainingAmount % noteService.getNote50Val();
				tempRemainingNoteQy = remainingAmount / noteService.getNote50Val();
				if (noteService.getNote50Qy() >= tempRemainingNoteQy) {
					noteToWithdraw.put(50, tempRemainingNoteQy);
					remainingAmount = tempVal;

					System.out.println("50 remainingAmount " + remainingAmount);
				} else {
					if((noteService.getNote50Val() * noteService.getNote50Qy()) < remainingAmount ) {
						noteToWithdraw.put(50, noteService.getNote50Qy());
						remainingAmount = remainingAmount - (noteService.getNote50Val() * noteService.getNote50Qy());
					}	
				}
			}

			if ((remainingAmount >= 20 && remainingAmount != 30) && noteService.getNote20Qy() != 0) {
				tempVal = remainingAmount % noteService.getNote20Val();
				tempRemainingNoteQy = remainingAmount / noteService.getNote20Val();
				if (noteService.getNote20Qy() >= tempRemainingNoteQy) {
					noteToWithdraw.put(20, tempRemainingNoteQy);
					remainingAmount = tempVal;

					System.out.println("20 remainingAmount " + remainingAmount);
				} else {
					if((noteService.getNote20Val() * noteService.getNote20Qy()) < remainingAmount ) {
						noteToWithdraw.put(20, noteService.getNote20Qy());
						remainingAmount = remainingAmount - (noteService.getNote20Val() * noteService.getNote20Qy());
					}
				}
			}

			if (remainingAmount != 0) {
				note.setError("it's impossible to withdraw : " + withdrawAmount);
				System.out.println("it's impossible to withdraw : " + withdrawAmount);
				noteToWithdraw.clear();
			}
			System.out.println("noteToWithdraw" + noteToWithdraw);
		}

		if (!noteToWithdraw.isEmpty()) {
			noteToWithdraw.forEach((k, v) -> {

				switch (k) {
				case 1000:
					noteService.setNote1000Qy(noteService.getNote1000Qy() - v);
					break;

				case 500:
					noteService.setNote500Qy(noteService.getNote500Qy() - v);
					break;

				case 100:
					noteService.setNote100Qy(noteService.getNote100Qy() - v);
					break;

				case 50:
					noteService.setNote50Qy(noteService.getNote50Qy() - v);
					break;

				case 20:
					noteService.setNote20Qy(noteService.getNote20Qy() - v);
					break;

				default:
				}

				System.out.println("noteService" + noteService.toString());
			});
		}
		return note;
	}
	
//	version 2
//	public void withdraw(int withdrawAmount) {
//		int remainingAmount = 0;
//		int tempVal;
//
//		Map<Integer, Integer> noteToWithdraw = new HashMap<Integer, Integer>();
//
//		if (withdrawAmount != 0) {
//			if (withdrawAmount > 1000 && noteService.getNote1000Qy() != 0) {
//				remainingAmount = withdrawAmount % noteService.getNote1000Val();
//
//				if (noteService.getNote1000Qy() >= withdrawAmount / noteService.getNote1000Val()) {
//					noteToWithdraw.put(1000, withdrawAmount / noteService.getNote1000Val());
//					System.out.println("remainingAmount " + remainingAmount);
//				} else {
//					System.out.println("1000 error");
//					remainingAmount = withdrawAmount;
//				}
//			} else {
//				remainingAmount = withdrawAmount;
//			}
//
//			if (remainingAmount >= 500 && noteService.getNote500Qy() != 0) {
//				tempVal = remainingAmount % noteService.getNote500Val();
//
//				if (noteService.getNote500Qy() >= remainingAmount / noteService.getNote500Val()) {
//					noteToWithdraw.put(500, remainingAmount / noteService.getNote500Val());
//					remainingAmount = tempVal;
//					System.out.println("500 remainingAmount " + remainingAmount);
//				} else {
//					System.out.println("500 error");
//				}
//			}
//
//			if (remainingAmount >= 100 && noteService.getNote100Qy() != 0) {
//				tempVal = remainingAmount % noteService.getNote100Val();
//
//				if (noteService.getNote100Qy() >= remainingAmount / noteService.getNote100Val()) {
//					noteToWithdraw.put(100, remainingAmount / noteService.getNote100Val());
//					remainingAmount = tempVal;
//					System.out.println("100 remainingAmount " + remainingAmount);
//				} else {
//					System.out.println("100 error");
//				}
//			}
//
//			if ((remainingAmount >= 50 || remainingAmount >= 100) && remainingAmount != 60 && remainingAmount != 80 && noteService.getNote50Qy() != 0) {
//				tempVal = remainingAmount % noteService.getNote50Val();
//
//				if (noteService.getNote50Qy() >= remainingAmount / noteService.getNote50Val()) {
//					noteToWithdraw.put(50, remainingAmount / noteService.getNote50Val());
//					remainingAmount = tempVal;
//					System.out.println("50 remainingAmount " + remainingAmount);
//				} else {
//					System.out.println("50 error");
//				}
//			}
//
//			if ((remainingAmount >= 20 && remainingAmount != 30) && noteService.getNote50Qy() != 0) {
//				tempVal = remainingAmount % noteService.getNote20Val();
//
//				if (noteService.getNote20Qy() >= remainingAmount / noteService.getNote20Val()) {
//					noteToWithdraw.put(20, remainingAmount / noteService.getNote20Val());
//					remainingAmount = tempVal;
//					System.out.println("20 remainingAmount " + remainingAmount);
//				} else {
//					System.out.println("20 error");
//				}
//			}
//
//			if (remainingAmount != 0) {
//				System.out.println("it's impossible to withdraw : " + withdrawAmount);
//				noteToWithdraw.clear();
//			}
//			System.out.println("noteToWithdraw" + noteToWithdraw);
//		}
//
//		if (!noteToWithdraw.isEmpty()) {
//			noteToWithdraw.forEach((k, v) -> {
//
//				switch (k) {
//				case 1000:
//					noteService.setNote1000Qy(noteService.getNote1000Qy() - v);
//					break;
//
//				case 500:
//					noteService.setNote500Qy(noteService.getNote500Qy() - v);
//					break;
//
//				case 100:
//					noteService.setNote100Qy(noteService.getNote100Qy() - v);
//					break;
//
//				case 50:
//					noteService.setNote50Qy(noteService.getNote50Qy() - v);
//					break;
//
//				case 20:
//					noteService.setNote20Qy(noteService.getNote20Qy() - v);
//					break;
//
//				default:
//				}
//			});
//		}
//	}
	
//	version1
//	public void withdraw(int withdrawAmount) {
//		
//		this.note20Val = noteService.getNote20Val();
//        this.note50Val = noteService.getNote50Val();
//		this.note20Qy = noteService.getNote20Qy();
//		this.note50Qy = noteService.getNote50Qy();
//		
//		int result = 0;
//		int noteToWithdraw = 0;
//		boolean isNote20 = false;
//		
//		if(withdrawAmount != 0) {
//			result = withdrawAmount%this.note50Val;
//			
//			if(result == 0) {
//				noteToWithdraw = withdrawAmount/this.note50Val;
//			} else {
//				result = withdrawAmount%this.note20Val;
//				if(result == 0) {
//					noteToWithdraw = withdrawAmount/this.note20Val;
//					isNote20 = true;
//				} else {
//					System.out.println("it's impossible to dispense : " + withdrawAmount + " baht");
//				}
//			}
//		} else {
//			System.out.println("enter withdraw amount");
//		}
//		
//		if(noteToWithdraw != 0) {
//			if(isNote20) {
//				if(this.note20Qy >= noteToWithdraw) {
//					this.note20Qy -= noteToWithdraw;
//					noteService.setNote20Qy(this.note20Qy);
//				} else {
//					System.out.println("20 notes left : " + this.note20Qy + "notes : you can withdraw upto = " + this.note20Qy*this.note20Val + " baht");
//				}
//			} else {
//				if(this.note50Qy >= noteToWithdraw) {
//					this.note50Qy -= noteToWithdraw;
//					noteService.setNote50Qy(this.note50Qy);
//				} else {
//					System.out.println("50 notes left : " + this.note50Qy + "notes : you can withdraw upto = " + this.note50Qy*this.note50Val + " baht");
//				}
//			}
//		}
//	}
}

