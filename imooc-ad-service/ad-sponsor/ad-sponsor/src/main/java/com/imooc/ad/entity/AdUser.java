package com.imooc.ad.entity;

import com.imooc.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_user")
public class AdUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "username", nullable = false)
    private String username;
    @Basic
    @Transient
    @Column(name = "token", nullable = false)
    private String token;
    @Basic
    @Column(name = "user_status", nullable = false)
    private Integer userstatus;
    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    @Basic
    @Column(name = "update_time", nullable = false)
    private Date updatetime;

    public AdUser(String username, String token){
        this.username = username;
        this.token = token;
        this.userstatus = CommonStatus.VALID.getStatus();
        this.createTime = new Date();
        this.updatetime = this.createTime;

    }
}
