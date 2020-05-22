package com.xnote.manage.modules.admin.bean;

public class AdminRoleFunctionRelation {
    private String id;

    private String roleId;

    private String funcId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId == null ? null : funcId.trim();
    }

    @Override
    public String toString() {
        return "AdminRoleFunctionRelation{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", funcId='" + funcId + '\'' +
                '}';
    }
}