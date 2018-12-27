package com.baizhi.fl.service.impl;

import com.baizhi.fl.dao.ChapterDao;
import com.baizhi.fl.entity.Chapter;
import com.baizhi.fl.service.ChapterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by lenovo on 2018/7/7.
 */

@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService {
    //DI
    @Resource(name = "chapterDao")
    private ChapterDao dao;

    @Override
    public void addChapter(Chapter chapter,String urlName) {
        //使用UUID 生成主键
        String uuid = UUID.randomUUID().toString();
        chapter.setId(uuid);
        chapter.setUrl(urlName);
        dao.insertChapter(chapter);

    }
}
