package my.day11.inheritance.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import my.day11.inheritance.user.company.RecruitPost;
import my.day11.inheritance.user.jobseeker.JobSeeker;

public class RequestJoined {
	private RecruitPost recruit;
	private JobSeeker jobSeeker;
	private String applyMotive;
	private String createdAt;
	
	public RequestJoined(){
		
	}
	public void setMotive(String motive) {
		this.applyMotive = motive;
	}
	
	private RequestJoined(RecruitPost recruit, JobSeeker job, String motive) {
		this.recruit = recruit;
		this.jobSeeker = job;
		this.applyMotive = motive;
		this.createdAt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	public String getApplyMotive() {
		return applyMotive;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public RecruitPost getRecruitPost() {
		return this.recruit;
	}
	public JobSeeker getJobSeeker() {
		return this.jobSeeker;
	}
	public static RequestJoined of(RecruitPost recruit, JobSeeker job, String motive) {
		return new RequestJoined(recruit,job, motive);
	}
	
}
