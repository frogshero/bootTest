package com.example.bootTest.db.dao;

import com.example.bootTest.db.entity.Document;

public interface DocumentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
}