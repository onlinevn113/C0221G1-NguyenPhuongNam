package com.model.service.impl;

import com.model.entity.ImgOfDay;
import com.model.repository.BaseRepository;
import com.model.service.ImgService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import java.util.List;
@Service
public class ImgServiceIpml implements ImgService {

    @Override
    public List<ImgOfDay> showAll() {
        return BaseRepository.entityManager.createQuery(
                "select i " +
                        "from ImgOfDay i",ImgOfDay.class).getResultList();
    }

    @Override
    public void addComment(ImgOfDay imgOfDay) {
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(imgOfDay);
        entityTransaction.commit();
    }

    @Override
    public void addLike(int id) {
        ImgOfDay imgOfDay=BaseRepository.entityManager.find(ImgOfDay.class,id);
        imgOfDay.setLike(imgOfDay.getLike()+1);
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(imgOfDay);
        entityTransaction.commit();
    }


}
