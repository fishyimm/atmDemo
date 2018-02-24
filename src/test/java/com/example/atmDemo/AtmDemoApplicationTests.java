package com.example.atmDemo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.atmDemo.service.NoteService;
import com.example.atmDemo.service.WithdrawService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AtmDemoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class AtmDemoApplicationTests {

	@Autowired
	WithdrawService withdrawService;

	@Autowired
	NoteService noteService;

	public int note20Val;
	public int note50Val;
	public int note100Val;
	public int note500Val;
	public int note1000Val;

	public int note20Qy;
	public int note50Qy;
	public int note100Qy;
	public int note500Qy;
	public int note1000Qy;

	@Test
	public void contextLoads() {
	}

	@Before
	public void setUp() throws Exception {
		this.note20Val = 20;
		this.note50Val = 50;
		this.note100Val = 100;
		this.note500Val = 500;
		this.note1000Val = 1000;

		this.note20Qy = 100;
		this.note50Qy = 100;
		this.note100Qy = 100;
		this.note500Qy = 100;
		this.note1000Qy = 100;

		System.out.println("b4----------------------");
		noteService.setNote20Qy(100);
		noteService.setNote50Qy(100);
		noteService.setNote100Qy(100);
		noteService.setNote500Qy(100);
		noteService.setNote1000Qy(100);
	}

	@Test
	public void test() {
		int withdrawAmount = 1000;

		int remainingAmount = 0;
		int tempVal;
		int tempRemainingNoteQy;
		
		Map<Integer, Integer> noteToWithdraw = new HashMap<Integer, Integer>();

		if (withdrawAmount != 0) {
			if (withdrawAmount > 1000 && noteService.getNote1000Qy() != 0) {
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
					System.out.println("20 error : " + remainingAmount);
					if((noteService.getNote20Val() * noteService.getNote20Qy()) < remainingAmount ) {
						noteToWithdraw.put(20, noteService.getNote20Qy());
						remainingAmount = remainingAmount - (noteService.getNote20Val() * noteService.getNote20Qy());
					}
				}
			}

			if (remainingAmount != 0) {
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
	} 
	
	 @Test
	 public void withdraw10To100() {
		 int[] number = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		 for (int i : number) {
			 System.out.println( "===========================" + i + "===========================");
			 withdrawService.withdraw(i);
			 System.out.println(noteService.toString());
		 }
	 }
	 
	@Test
	public void withdraw90000() {
		withdrawService.withdraw(90000);
		System.out.println(" 90000 = " + noteService.toString());
	}
	
	 @Test
	 public void withdraw15550() {
		 withdrawService.withdraw(15550);
		 System.out.println(" 15550 = " + noteService.toString());
	 }
	 
	 @Test
	 public void withdraw1580() {
		 withdrawService.withdraw(1580);
		 System.out.println(" 1580 = " + noteService.toString());
	 }
	 
	 @Test
	 public void withdraw18950() {
		 withdrawService.withdraw(18950);
		 System.out.println(" 18950 = " + noteService.toString());
	 }
	 
	 @Test
	 public void withdraw1890() {
		 withdrawService.withdraw(890);
		 System.out.println(" 890 = " + noteService.toString());
	 }
	 
	 @Test
	 public void withdraw1700() {
		 withdrawService.withdraw(1700);
		 System.out.println(" 1700 = " + noteService.toString());
	 }
	 
}
