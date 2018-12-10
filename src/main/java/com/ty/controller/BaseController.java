package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/10/27.
 */
public class BaseController<T> {

    @Autowired
    T baseService;
}
