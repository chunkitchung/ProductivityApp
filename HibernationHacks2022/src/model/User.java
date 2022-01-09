package model;
/*
 * Represent a user of the application and their stats
 */
public class User {
	int dailyPomos;
	int dailyTasks;
	int totalTasks;
	int totalPomos;
	int studyTime;
	public User() {
		this.dailyPomos = 0;
		this.dailyTasks = 0;
		this.totalPomos = 0;
		this.totalTasks = 0;
		this.studyTime = 0;
	}
}
