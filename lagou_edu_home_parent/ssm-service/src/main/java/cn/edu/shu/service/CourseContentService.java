package cn.edu.shu.service;

import cn.edu.shu.domains.Course;
import cn.edu.shu.domains.CourseSection;

import java.util.List;

public interface CourseContentService {

    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    public Course findCourseByCourseId(int courseId);

    public void saveSection(CourseSection courseSection);

    public void updateSection(CourseSection courseSection);
}
