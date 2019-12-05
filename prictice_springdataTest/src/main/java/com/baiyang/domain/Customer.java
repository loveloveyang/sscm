package com.baiyang.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cst_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键的生成策略：自增长
    @Column(name = "cust_id")
    private Long custId;//客户编号
    @Column(name = "cust_name")
    private String custName;//客户名称
    @Column(name = "cust_source")
    private String custSource;//客户信息来源
    @Column(name = "cust_industry")
    private String custIndustry;//客户所属行业
    @Column(name = "cust_level")
    private String custLevel;//客户级别
    @Column(name = "cust_address")
    private String custAddress;//客户联系地址
    @Column(name = "cust_phone")
    private String custPhone;//客户电话

    //一对多的关系中，把多得一方一般称为从表
    //@OneToMany(targetEntity = LinkMan.class)
    //@JoinColumn(name="lkm_cust_id",referencedColumnName = "cust_id")
    //放弃外键维护权，交给另一方的对象变量(customer)
    //fetch = FetchType.LAZY 延迟加载
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<LinkMan> linkMan=new HashSet<>();

    public Set<LinkMan> getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(Set<LinkMan> linkMan) {
        this.linkMan = linkMan;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}
