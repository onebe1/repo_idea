package cn.edu.shu.controller;

import cn.edu.shu.domains.Course;
import cn.edu.shu.domains.CourseSection;
import cn.edu.shu.domains.ResponseResult;
import cn.edu.shu.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;


    @RequestMapping("/findSectionAndLessonByCourseId")
    public ResponseResult findSectionAndLessonByCourseId(@RequestParam Integer courseId) {
        List<CourseSection> sectionList = courseContentService.findSectionAndLessonByCourseId(courseId);
        ResponseResult responseResult = new ResponseResult(true, 200, "查找成功", sectionList);
        return responseResult;
    }

    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(@RequestParam Integer courseId) {
        Course course = courseContentService.findCourseByCourseId(courseId);
        ResponseResult responseResult = new ResponseResult(true, 200, "查找成功", course);
        return responseResult;
    }

    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveSection(@RequestBody CourseSection courseSection) {
        ResponseResult responseResult=null;
        if (courseSection.getId()==null){
            courseContentService.saveSection(courseSection);
            responseResult = new ResponseResult(true, 200, "新建课程信息成功", courseSection);
        }else{
            courseContentService.updateSection(courseSection);
            responseResult = new ResponseResult(true, 200, "修改课程信息成功", courseSection);
        }

        return responseResult;
    }



}
