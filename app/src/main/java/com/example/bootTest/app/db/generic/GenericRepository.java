package com.example.bootTest.app.db.generic;


import java.lang.reflect.Field;
import java.util.Date;

public abstract class GenericRepository<T extends Object,  PK>{
	
	protected abstract GenericMapper<T, PK> getGenericMapper();

	public int deleteByPrimaryKey(PK id) {
		return this.getGenericMapper().deleteByPrimaryKey(id);
	}

	public T insert(T entity) {
		int flag = this.getGenericMapper().insert(entity);
		if (flag > 0) {
			return entity;
		} else {
			return null;
		}
	}

	public T insertSelective(T entity) {
		int flag = this.getGenericMapper().insertSelective(entity);
		if (flag > 0) {
			return entity;
		} else {
			return null;
		}
	}

	public T selectByPrimaryKey(PK id) {
		return this.getGenericMapper().selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(T entity) {
		try {
			Field f = entity.getClass().getField("updateTime");
			f.set(entity, new Date());
		} catch (Exception e) {
		}

		return this.getGenericMapper().updateByPrimaryKeySelective(entity);
	}

	public int updateByPrimaryKey(T entity) {
		try {
			Field f = entity.getClass().getField("updateTime");
			f.set(entity, new Date());
		} catch (Exception e) {
		}
		return this.getGenericMapper().updateByPrimaryKey(entity);
	}



}
