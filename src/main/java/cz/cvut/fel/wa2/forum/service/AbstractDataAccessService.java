package cz.cvut.fel.wa2.forum.service;

import cz.cvut.fel.wa2.forum.persistence.GenericDao;
import cz.cvut.fel.wa2.forum.persistence.GenericDaoImpl;

public abstract class AbstractDataAccessService {
    protected GenericDao genericDao = new GenericDaoImpl();

//    public void setGenericDao(GenericDao genericDao) {
//        this.genericDao = genericDao;
//    }
//
//    public GenericDao getGenericDao() {
//        return genericDao;
//    }

}