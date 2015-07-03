package com.bzu.entity;

public class StudentServiceImp implements StudentService {
	StudentDao stuDao = null;
	@Override
	public StudentDao getStuDao() {
		// TODO Auto-generated method stub
		return stuDao;
	}

	@Override
	public void setStuDao(StudentDao stuDao) {
		// TODO Auto-generated method stub
		this.stuDao = stuDao;
	}

	@Override
	public void add(Student stu) {
		// TODO Auto-generated method stub
		stuDao.add(stu);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
