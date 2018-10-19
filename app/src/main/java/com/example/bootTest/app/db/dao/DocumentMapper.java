package com.example.bootTest.app.db.dao;

import com.example.bootTest.app.db.entity.Document;

public interface DocumentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
}