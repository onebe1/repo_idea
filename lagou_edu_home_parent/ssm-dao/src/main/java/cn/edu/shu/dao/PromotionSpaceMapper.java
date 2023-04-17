package cn.edu.shu.dao;

import cn.edu.shu.domains.PromotionSpace;

import java.util.List;

public interface PromotionSpaceMapper {

    // 查询广告位列表查询
    public List<PromotionSpace> findAllPromotionSpace();


    public void savePromotionSpace(PromotionSpace promotionSpace);


    public void updatePromotionSpace(PromotionSpace promotionSpace);


    //回显广告位名称
    public PromotionSpace findPromotionSpaceById(int id);
}
