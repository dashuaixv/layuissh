package com.gt.sys.dao.impl;

import com.gt.sys.dao.*;
import org.hibernate.*;
import org.hibernate.transform.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import javax.persistence.*;
import javax.persistence.Query;
import java.io.*;
import java.util.*;

/**
 * @Auther:herun
 * @Date: 2018/9/5 16:15
 * @Description:baseDao基础类，其他dao继承此类
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements IBaseDao<T> {
    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    public List<T> find(String hql) {
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Query q = entityManager.createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        return q.getResultList();
    }

    @Override
    public List<T> find(String hql, int page, int rows) {
        Query q = entityManager.createQuery(hql);
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).getResultList();
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
        Query q = entityManager.createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).getResultList();
    }

    @Override
    public List<Map> findBySql(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();
    }

    @Override
    public List<Map> findBySql(String sql, int page, int rows) {
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.setFirstResult((page - 1) * rows).setMaxResults(rows).getResultList();
    }

    @Override
    public List<Map> findBySql(String sql, Map<String, Object> params) {
        Query query = entityManager.createNativeQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();
    }

    @Override
    public List<Map> findBySql(String sql, Map<String, Object> params, int page, int rows) {
        Query query = entityManager.createNativeQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.setFirstResult((page - 1) * rows).setMaxResults(rows).getResultList();

    }


    @Override
    public T save(T o) {
        return entityManager.merge(o);
    }


    @Override
    public void delete(T o) {
        entityManager.remove(o);
    }


    @Override
    public T update(T o) {
        return entityManager.merge(o);
    }


    @Override
    public void saveOrUpdate(T o) {
        entityManager.merge(o);
    }

    @Override
    public T getById(Class<T> c, Serializable id) {
        return entityManager.find(c, id);
    }

    @Override
    public T getById(Class<T> c, Serializable id, LockModeType lockModeType) {
        return entityManager.find(c, id, lockModeType);
    }

    @Override
    public T getByHql(String hql) {
        Query q = entityManager.createQuery(hql);
        List<T> l = q.getResultList();
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }

    @Override
    public T getByHql(String hql, LockModeType lockModeType) {
        Query q = entityManager.createQuery(hql);
        q.setLockMode(lockModeType);
        List<T> l = q.getResultList();
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }

    @Override
    public T getByHql(String hql, Map<String, Object> params) {
        Query q = entityManager.createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        List<T> l = q.getResultList();
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }

    @Override
    public T getByHql(String hql, Map<String, Object> params, LockModeType lockModeType) {
        Query q = entityManager.createQuery(hql);
        q.setLockMode(lockModeType);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        List<T> l = q.getResultList();
        if (l != null && l.size() > 0) {
            return l.get(0);
        }
        return null;
    }


    @Override
    public List findByHqL(String hql) {
        Query q = entityManager.createQuery(hql);
        return q.getResultList();
    }

    @Override
    public List findByHqL(String hql, Map<String, Object> params) {
        Query q = entityManager.createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        return q.getResultList();
    }

    @Override
    public List findByHqL(String hql, int page, int rows) {
        Query q = entityManager.createQuery(hql);
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).getResultList();
    }

    @Override
    public List findByHqL(String hql, Map<String, Object> params, int page, int rows) {
        Query q = entityManager.createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).getResultList();
    }


    @Override
    public int executeSql(String sql) {
        Query q = entityManager.createNativeQuery(sql);
        return q.executeUpdate();
    }



    @Override
    public int executeSql(String sql, Map<String, Object> params) {
        Query q = entityManager.createNativeQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        return q.executeUpdate();
    }


    @Override
    public Long countBySql(String sql) {
        Query q = entityManager.createNativeQuery(sql);
        Object o = q.getSingleResult();
        return Long.parseLong(o.toString());
    }

    @Override
    public Long countBySql(String sql, Map<String, Object> params) {
        Query q = entityManager.createNativeQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        Object o = q.getSingleResult();
        return Long.parseLong(o.toString());
    }

    @Override
    public Long count(String hql) {
        Query q = entityManager.createQuery(hql);
        return (Long) q.getSingleResult();
    }

    @Override
    public Long count(String hql, Map<String, Object> params) {
        Query q = entityManager.createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        return (Long) q.getSingleResult();
    }


    @Override
    public int executeHql(String hql) {
        Query q = entityManager.createQuery(hql);
        return q.executeUpdate();
    }


    @Override
    public int executeHql(String hql, Map<String, Object> params) {
        Query q = entityManager.createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        return q.executeUpdate();
    }
}
