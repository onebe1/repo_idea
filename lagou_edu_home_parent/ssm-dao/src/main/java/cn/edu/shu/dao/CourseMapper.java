package cn.edu.shu.dao;

import cn.edu.shu.domains.Course;
import cn.edu.shu.domains.CourseSection;
import cn.edu.shu.domains.CourseVO;
import cn.edu.shu.domains.Teacher;

import java.util.List;

public interface CourseMapper {

    public List<Course> findCourseByCondition(CourseVO courseVO);

    //    新建课程信息
    public int saveCourse(Course course);

    //    新增讲师信息
    public void saveTeacher(Teacher teacher);


    //回显课程信息

    public CourseVO findCourseById(int id);

    //修改课程信息,因为涉及到两张表，所以
    public void updateCourse(Course course);

    //修改教师信息

    public void updateTeacher(Teacher teacher);

    //修改课程状态

    public void updateCourseStatus(Course course);




}
