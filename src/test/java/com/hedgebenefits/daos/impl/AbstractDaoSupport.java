package com.hedgebenefits.daos.impl;


import org.hibernate.SessionFactory;

public abstract class AbstractDaoSupport<T> {

    public abstract SessionFactory getSessionFactory();

    protected void save(T t){
        getSessionFactory().getCurrentSession().save(t);
    }

    protected void flush(){
        getSessionFactory().getCurrentSession().flush();
    }

}
