package com.baiyang.dao;

import com.baiyang.domain.Customer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {
    @Query(value = "from Customer where custName=?1")
    public List<Customer> findByCustname2(String name);
//    @Query语句中不能识别update
//    @Modifying //表示修改查询
//    @Query(value = "insert into Customer(custName,custSource,custIndustry,custLevel,custAddress,custPhone) " +
//            "values (?,?,?,?,?,?)")
//    public Integer saveCust2(Customer customer);
    @Query(value = "update Customer set custAddress=?2 where custId=?1")
    @Modifying
    @Transactional
    public void updateCust2(Long id,String address);
    @Query(value = "select * from cst_customer where cust_name=?1",nativeQuery =true)
    public List<Customer> findByCustname3(String name);

    /**
     * =========================命名规范查询====================
     */
    public Customer findByCustName(String custname);
    public Customer findByCustNameOrCustId(String custName,Long id);
    public List<Customer> findByCustNameLikeOrCustSourceLike(String name,String source);
    public List<Customer> findByCustLevelLikeOrCustSourceLike(String level,String source);
    public List<Customer> findByCustIdLessThan(Long custid);
    public List<Customer> findByCustSourceLike(String source);

    /**
     *=================SpecificationExecutor动态查询==============
     * 条件不固定
     */
}
