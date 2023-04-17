package cn.edu.shu.dao;

import cn.edu.shu.domains.Course;
import cn.edu.shu.domains.CourseSection;

import java.util.List;

public interface CourseContentMapper {

    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    public Course findCourseByCourseId(int courseId);

    //新增章节信息
    public void saveSection(CourseSection courseSection);

    //修改章节信息
    public void updateSection(CourseSection courseSection);
}
