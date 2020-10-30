package com.gt.sys.service.impl;

import com.gt.sys.dao.*;
import com.gt.sys.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

/**
 * @功能说明：baseService实现类，其他serviceImpl基础此类
 * @作者： herun
 * @创建日期：2015-09-23
 * @版本号：V1.0
 */
@Service("baseService")
public class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private IBaseDao<T> baseDao;

    @Override
    public List<T> find(String hql) {
        return baseDao.find(hql);
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        return baseDao.find(hql, params);
    }

    @Override
    public List<T> find(String hql, int page, int rows) {
        return baseDao.find(hql, page, rows);
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
        return baseDao.find(hql, params, page, rows);
    }

    @Override
    public List<Map> findBySql(String sql) {
        return baseDao.findBySql(sql);
    }

    @Override
    public List<Map> findBySql(String sql, int page, int rows) {
        return baseDao.findBySql(sql, page, rows);
    }

    @Override
    public List<Map> findBySql(String sql, Map<String, Object> params) {
        return baseDao.findBySql(sql, params);
    }

    @Override
    public List<Map> findBySql(String sql, Map<String, Object> params, int page, int rows) {
        return baseDao.findBySql(sql, params, page, rows);
    }

    @Override
    public T save(T o) {
        return baseDao.save(o);
    }

    @Override
    public void delete(T o) {
        baseDao.delete(o);
    }

    @Override
    public T update(T o) {
        return baseDao.update(o);
    }

    @Override
    public void saveOrUpdate(T o) {
        baseDao.saveOrUpdate(o);
    }

    @Override
    public T getById(Class<T> c, Serializable id) {
        return baseDao.getById(c, id);
    }

    @Override
    public T getById(Class<T> c, Serializable id, LockModeType lockModeType) {
        return baseDao.getById(c, id, lockModeType);
    }

    @Override
    public T getByHql(String hql) {
        return baseDao.getByHql(hql);
    }

    @Override
    public T getByHql(String hql, LockModeType lockModeType) {
        return baseDao.getByHql(hql, lockModeType);
    }

    @Override
    public T getByHql(String hql, Map<String, Object> params) {
        return baseDao.getByHql(hql, params);
    }

    @Override
    public T getByHql(String hql, Map<String, Object> params, LockModeType lockModeType) {
        return baseDao.getByHql(hql, params, lockModeType);
    }

    @Override
    public List findByHqL(String hql) {
        return baseDao.findByHqL(hql);
    }

    @Override
    public List findByHqL(String hql, Map<String, Object> params) {
        return baseDao.findByHqL(hql, params);
    }

    @Override
    public List findByHqL(String hql, int page, int rows) {
        return baseDao.findByHqL(hql, page, rows);
    }

    @Override
    public List findByHqL(String hql, Map<String, Object> params, int page, int rows) {
        return baseDao.findByHqL(hql, params, page, rows);
    }

    @Override
    public int executeSql(String sql) {
        return baseDao.executeSql(sql);
    }

    @Override
    public int executeSql(String sql, Map<String, Object> params) {
        return baseDao.executeSql(sql,params);
    }

    @Override
    public Long countBySql(String sql) {
        return baseDao.countBySql(sql);
    }

    @Override
    public Long countBySql(String sql, Map<String, Object> params) {
        return baseDao.countBySql(sql, params);
    }

    @Override
    public Long count(String hql) {
        return baseDao.count(hql);
    }

    @Override
    public Long count(String hql, Map<String, Object> params) {
        return baseDao.count(hql, params);
    }

    @Override
    public int executeHql(String hql) {
        return baseDao.executeHql(hql);
    }

    @Override
    public int executeHql(String hql, Map<String, Object> params) {
        return baseDao.executeHql(hql, params);
    }
}
