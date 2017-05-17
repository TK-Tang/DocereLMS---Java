package com.Docere.Course;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Courses")
@Table(name = "Courses")
public class Course implements Serializable {

	private static final long serialVersionUID = -7457000370867954683L;

	public Course() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseID")
	private int courseID;
	
	@NotNull
	@Size(min = 2, max = 128)
	@Column(name = "courseTitle")
	private String courseTitle;
	
	@NotNull
	@Column(name = "courseOwnerID")
	private int courseOwnerID;
	
	@Column(name = "forumID")
	private int forumID;
	
	@NotNull
	@Column(name = "courseSettingsID")
	private int courseSettingsID;
	
	@Column(name = "chatID")
	private int chatID;
	
	@Column(name = "learningResourcesCollectionsID")
	private int learningResourceCollectionID;
	
	@Column(name = "quizCollectionsID")
	private int QuizCollectionsID;
	
	@Column(name = "courseDescription")
	private String courseDescription;

	public int getCourseID() {
		return courseID;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public int getCourseOwnerID() {
		return courseOwnerID;
	}

	public int getForumID() {
		return forumID;
	}

	public int getCourseSettingsID() {
		return courseSettingsID;
	}

	public int getChatID() {
		return chatID;
	}

	public int getQuizCollectionsID() {
		return QuizCollectionsID;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public void setCourseOwnerID(int courseOwnerID) {
		this.courseOwnerID = courseOwnerID;
	}

	public void setForumID(int forumID) {
		this.forumID = forumID;
	}

	public void setCourseSettingsID(int courseSettingsID) {
		this.courseSettingsID = courseSettingsID;
	}

	public void setChatID(int chatID) {
		this.chatID = chatID;
	}

	public void setQuizCollectionsID(int quizCollectionsID) {
		QuizCollectionsID = quizCollectionsID;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
}
