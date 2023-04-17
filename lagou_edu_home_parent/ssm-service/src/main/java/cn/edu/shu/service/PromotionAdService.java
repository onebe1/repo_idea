package cn.edu.shu.service;

import cn.edu.shu.domains.PromotionAd;
import cn.edu.shu.domains.PromotionAdVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PromotionAdService {

    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVo promotionAdVo);


    public void savePromotionAd(PromotionAd promotionAd);

    public void updatePromotionAd(PromotionAd promotionAd);

    public PromotionAd findPromotionAdById(int id);


    public void updatePromotionAdStatus(int id,int status);
}
