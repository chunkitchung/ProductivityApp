package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observer;

/*
 * Represent a user of the application and their stats
 */
public class User implements Serializable{
	int dailyPomos;
	int dailyTasks;
	int totalTasks;
	int totalPomos;
	double studyTime;	
	
	public User() {
		this.dailyPomos = 0;
		this.dailyTasks = 0;
		this.totalPomos = 0;
		this.totalTasks = 0;
		this.studyTime = 0;
	}

	public int getDailyPomos() {
		return dailyPomos;
	}

	public void setDailyPomos(int dailyPomos) {
		this.dailyPomos = dailyPomos;
		save();
	}

	public int getDailyTasks() {
		return dailyTasks;
	}

	public void setDailyTasks(int dailyTasks) {
		this.dailyTasks = dailyTasks;
		save();
	}

	public int getTotalTasks() {
		return totalTasks;
	}

	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
		save();
	}

	public int getTotalPomos() {
		return totalPomos;
	}

	public void setTotalPomos(int totalPomos) {
		this.totalPomos = totalPomos;
		save();
	}

	public Double getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(Double studyTime) {
		this.studyTime = studyTime;
		save();
	}
	
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("user.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(this);
			oos.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("ERROR WRITTING");
		}
	}
	public void addPomo() {
		this.dailyPomos++;
		this.totalPomos++;
		this.studyTime = this.studyTime + 0.5;
	}
	
}
