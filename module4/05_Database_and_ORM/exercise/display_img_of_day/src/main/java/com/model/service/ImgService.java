package com.model.service;
import com.model.entity.ImgOfDay;
import java.util.List;
public interface ImgService {
    List<ImgOfDay> showAll();
    void addLike(int id);
    void addComment(ImgOfDay imgOfDay);
}
