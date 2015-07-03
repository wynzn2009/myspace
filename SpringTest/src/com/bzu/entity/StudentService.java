package com.bzu.entity;

public interface StudentService {
	public StudentDao getStuDao();
	public void setStuDao(StudentDao stuDao);
	public void add(Student stu);
}
