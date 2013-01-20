package com.hedgebenefits.daos.impl;


import com.hedgebenefits.domain.User;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class AbstractDaoSupport<T> {

    public abstract SessionFactory getSessionFactory();

    protected void save(T t){
        getSessionFactory().getCurrentSession().save(t);
    }

    protected void flush(){
        getSessionFactory().getCurrentSession().flush();
    }

    protected T load(Class<T> t, Serializable id){
       return (T) getSessionFactory().getCurrentSession().load(t , id);
    }

}
