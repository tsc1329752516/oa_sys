package com.gec.oasys.pojo;

public class SysUser {
    private Integer id;

    private String loginName;

    private String pwd;

    private String img;

    private String email;

    private String sex;

    private String mobile;

    private String status;

    private String name;

    private Integer orgId;

    public SysUser(Integer id, String loginName, String pwd, String img, String email, String sex, String mobile, String status, String name, Integer orgId) {
        this.id = id;
        this.loginName = loginName;
        this.pwd = pwd;
        this.img = img;
        this.email = email;
        this.sex = sex;
        this.mobile = mobile;
        this.status = status;
        this.name = name;
        this.orgId = orgId;
    }

    public SysUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginName=").append(loginName);
        sb.append(", pwd=").append(pwd);
        sb.append(", img=").append(img);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", mobile=").append(mobile);
        sb.append(", status=").append(status);
        sb.append(", name=").append(name);
        sb.append(", orgId=").append(orgId);
        sb.append("]");
        return sb.toString();
    }
}