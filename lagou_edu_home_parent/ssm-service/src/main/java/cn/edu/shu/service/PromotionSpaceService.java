package cn.edu.shu.service;

import cn.edu.shu.domains.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {
    public List<PromotionSpace> findAllPromotionSpace();

    public void savePromotionSpace(PromotionSpace promotionSpace);

    public void updatePromotionSpace(PromotionSpace promotionSpace);


    public PromotionSpace findPromotionSpaceById(int id);
}
