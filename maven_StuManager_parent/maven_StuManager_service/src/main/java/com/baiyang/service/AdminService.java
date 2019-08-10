package com.baiyang.service;

import com.baiyang.domain.Admin;

public interface AdminService {
    /**
     * 查找管理员自己
     * @param ano
     * @return
     */
    public Admin findAdminByTno(int ano);

    /**
     * 管理员修改自己密码
     * @param ano
     * @param newApassword
     * @return
     */
    public int updateAdminPass(int ano,String newApassword);
}
