package com.baiyang.dao;

import com.baiyang.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    /**
     * 查找管理员自己
     * @param ano
     * @return
     */
    public Admin findAdminByTno(int ano);
    /**
     * 管理员修改自己的密码
     * @param ano
     * @param newApassword
     * @return
     */
    public int updateAdminPass(@Param("ano") int ano,@Param("newApassword") String newApassword);

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    public Admin loginAdmin(Admin admin);
}
