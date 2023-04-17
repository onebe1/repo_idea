package cn.edu.shu.service;

import cn.edu.shu.domains.Course;
import cn.edu.shu.domains.CourseVO;
import cn.edu.shu.domains.Teacher;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {

    public List<Course> findCourseByCondition(CourseVO courseVO);

//    添加课程及讲师信息
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    //回显章节信息
    public CourseVO findCourseById(int id);



    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;


    public void updateCourseStatus(int id,int status);


}
