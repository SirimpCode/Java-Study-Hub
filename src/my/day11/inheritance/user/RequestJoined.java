package my.day11.inheritance.user;

import my.day11.inheritance.user.company.RecruitPost;
import my.day11.inheritance.user.jobseeker.JobSeeker;

public class RequestJoined {
	private RecruitPost recruit;
	private JobSeeker jobSeeker;
	
	private RequestJoined(RecruitPost recruit, JobSeeker job) {
		this.recruit = recruit;
		this.jobSeeker = job;
	}
	public RecruitPost getRecruitPost() {
		return this.recruit;
	}
	public JobSeeker getJobSeeker() {
		return this.jobSeeker;
	}
	public static RequestJoined of(RecruitPost recruit, JobSeeker job) {
		return new RequestJoined(recruit,job);
	}
	
}
