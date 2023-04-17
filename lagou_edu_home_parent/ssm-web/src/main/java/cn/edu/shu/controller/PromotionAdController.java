package cn.edu.shu.controller;

import cn.edu.shu.domains.PromotionAd;
import cn.edu.shu.domains.PromotionAdVo;
import cn.edu.shu.domains.ResponseResult;
import cn.edu.shu.service.PromotionAdService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/promotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllPromotionAdByPage(PromotionAdVo promotionAdVo) {
        PageInfo<PromotionAd> allPromotionAdByPage = promotionAdService.findAllPromotionAdByPage(promotionAdVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "查找成功", allPromotionAdByPage);
        return responseResult;
    }

    //图片上传
    @RequestMapping("/promotionAdUpload")
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
    @RequestMapping("/saveOrUpdatePromotion")
    public ResponseResult saveOrUpdatePromotion(@RequestBody PromotionAd promotionAd){

        ResponseResult responseResult=null;
        if(promotionAd.getId()==null){
            promotionAdService.savePromotionAd(promotionAd);
            responseResult = new ResponseResult(true, 200, "保存广告成功", null);
        }else {
            promotionAdService.updatePromotionAd(promotionAd);
            responseResult = new ResponseResult(true, 200, "修改广告成功", null);
        }
        return responseResult;
    }

    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(@RequestParam int id){

        PromotionAd promotionAd = promotionAdService.findPromotionAdById(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "回显广告信息成功", promotionAd);

        return responseResult;
    }

    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(int id ,int status){
        promotionAdService.updatePromotionAdStatus(id ,status);
        ResponseResult responseResult = new ResponseResult(true, 200, "修改广告状态成功", null);

        return responseResult;
    }

}
