package com.example.bootTest.app.db.generic;

public interface GenericMapper<T, PK> {

	int deleteByPrimaryKey(PK id);

	int insert(T record);

	int insertSelective(T record);

	T selectByPrimaryKey(PK id);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);

}
