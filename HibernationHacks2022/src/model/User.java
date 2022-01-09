package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

/*
 * Represent a user of the application and their state
 * Allows the state to be opened on app startup
 * 
 * Used in observer pattern to update panels in the view of application
 */
public class User implements Serializable{
	int dailyPomos;
	int dailyTasks;
	int totalTasks;
	int totalPomos;
	double studyTime;
	int day;
	ArrayList<Observer> observers;
	
	public User() {
		this.dailyPomos = 0;
		this.dailyTasks = 0;
		this.totalPomos = 0;
		this.totalTasks = 0;
		this.studyTime = 0;
		int day = new Date().getDay();
		observers = new ArrayList<Observer>();
	}
	 
	public void setDay(int i) {
		this.day = i;
	}
	public void attatch(Observer o) {
		this.observers.add(o);
	}
	
	//notifies observers of change in state
	public void notifyObservers(){
		for(Observer o : this.observers) {
			o.update(null, this);
		}
		System.out.println("observers notified");
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

	public double getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(double studyTime) {
		this.studyTime = studyTime;
		save();
	}
	
	//check if date needs to be updated
	public void startup() {
		Date tempDate = new Date();
		if(this.day != tempDate.getDay()) {
			this.dailyPomos = 0;
			this.dailyTasks = 0;
			this.day = tempDate.getDay();
		}
	}
	
	//saves the state of the User
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
	
	//Used to account for a pomodoro that was just completed
	public void addPomo() {
		startup();
		this.dailyPomos++;
		this.totalPomos++;
		this.studyTime = this.studyTime + 0.5;
		save();
		notifyObservers();
	}
	
}
