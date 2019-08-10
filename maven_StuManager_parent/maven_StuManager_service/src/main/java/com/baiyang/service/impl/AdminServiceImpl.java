package com.baiyang.service.impl;

import com.baiyang.dao.AdminDao;
import com.baiyang.domain.Admin;
import com.baiyang.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin findAdminByTno(int ano) {
        return null;
    }

    @Override
    public int updateAdminPass(int ano, String newApassword) {
        return adminDao.updateAdminPass(ano,newApassword);
    }
}
