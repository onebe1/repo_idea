package cn.edu.shu.controller;

import cn.edu.shu.domains.Course;
import cn.edu.shu.domains.CourseVO;
import cn.edu.shu.domains.ResponseResult;
import cn.edu.shu.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO) {

        List<Course> list = courseService.findCourseByCondition(courseVO);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", list);
        return responseResult;

    }

    //图片上传
    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {


        if (file.isEmpty()) {
            throw new RuntimeException();
        }

        //2.获取项目的部署路径
        String realPath = request.getServletContext().getRealPath("/");

        //路径的截取
        String path = realPath.substring(0, realPath.indexOf("ssm_web"));


        //3.获取原文件名
        String originalFilename = file.getOriginalFilename();


        //4.上传新文件名
        String filename = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));


        //5.文件上上传
        String uploadPath = path + "/upload/";
        File filePath = new File(uploadPath, filename);

        //如果目录不存在就创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录：" + filePath);
        }
        //图片上传了
        file.transferTo(filePath);

        //6.将文件名和文件路径返回，进行响应
        Map<String, String> map = new HashMap<>();

        //将文件名和文件路径返回，进行响应

        map.put("fileName", filename);
        map.put("filePath", "http://localhost:8080/ssm_web/upload/" + filename);

        ResponseResult responseResult = new ResponseResult(true, 200, "图片上传成功", map);

        return responseResult;

    }

    //新增课程信息和修改课程信息要写在同一个方法中
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {

        ResponseResult responseResult = null;
        if (courseVO.getId() == null) {
            courseService.saveCourseOrTeacher(courseVO);
            responseResult = new ResponseResult(true, 200, "新增课程成功", null);
        } else {
            courseService.updateCourseOrTeacher(courseVO);
            responseResult = new ResponseResult(true, 200, "更新课程成功", null);
        }
        return responseResult;


    }

    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(@RequestParam int id) {
        CourseVO courseVO = courseService.findCourseById(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "回显课程成功", courseVO);
        return responseResult;
    }

    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(@RequestParam int id, @RequestParam int status) {
        courseService.updateCourseStatus(id, status);
        ResponseResult responseResult = new ResponseResult(true, 200, "修改课程状态成功", null);
        return responseResult;
    }


}
