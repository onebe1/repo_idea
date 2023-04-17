package cn.edu.shu.dao;

import cn.edu.shu.domains.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {

    //    分页查询广告信息
    public List<PromotionAd> findAllPromotionAdByPage();

    //    新建广告
    public void savePromotionAd(PromotionAd promotionAd);

    public void updatePromotionAd(PromotionAd promotionAd);


    public PromotionAd findPromotionAdById(int id);


    public void updatePromotionAdStatus(PromotionAd promotionAd);
}
