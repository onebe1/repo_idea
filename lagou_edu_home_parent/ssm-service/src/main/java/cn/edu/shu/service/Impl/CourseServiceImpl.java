package cn.edu.shu.service.Impl;

import cn.edu.shu.dao.CourseMapper;
import cn.edu.shu.domains.Course;
import cn.edu.shu.domains.CourseVO;
import cn.edu.shu.domains.Teacher;
import cn.edu.shu.service.CourseService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {


    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {

        List<Course> courseList = courseMapper.findCourseByCondition(courseVO);
        return courseList;
    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
//        封装课程信息
        Course course = new Course();

        ConvertUtils.register(new DateConverter(null), java.util.Date.class);
        BeanUtils.copyProperties(course,courseVO);


//       补全课程信息
        Date date = new Date();


        course.setCreateTime(date);
        course.setUpdateTime(date);
        courseMapper.saveCourse(course);

        //获取新插入id值
        int id = course.getId();

        //封装讲师信息

        Teacher teacher = new Teacher();

        BeanUtils.copyProperties(teacher, courseVO);

//        补全讲师信息
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        teacher.setIsDel(0);
        teacher.setCourseId(id);

//        保存讲师信息
        courseMapper.saveTeacher(teacher);

    }

    @Override
    public CourseVO findCourseById(int id) {

        CourseVO courseVO = courseMapper.findCourseById(id);
        return courseVO;
    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {

        Course course = new Course();
//        刚开始我想着创建时间会不会被更新掉，
        ConvertUtils.register(new DateConverter(null), java.util.Date.class);
        BeanUtils.copyProperties(course, courseVO);
        Date date = new Date();
        course.setUpdateTime(date);

        //保存课程信息
        courseMapper.updateCourse(course);

        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);

        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(date);
        courseMapper.updateTeacher(teacher);

    }

    @Override
    public void updateCourseStatus(int id,int status) {
        Course course = new Course();
        Date date = new Date();
        course.setId(id);
        course.setStatus(status);
        course.setUpdateTime(date);
        courseMapper.updateCourseStatus(course);
    }

}
