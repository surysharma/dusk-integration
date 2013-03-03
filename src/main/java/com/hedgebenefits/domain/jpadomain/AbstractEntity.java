package com.hedgebenefits.domain.jpadomain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created with IntelliJ IDEA.
 * User: sureshsharma
 * Date: 01/03/2013
 * Time: 19:21
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
