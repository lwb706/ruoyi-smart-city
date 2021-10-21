package com.ruoyi.goods.domain;
//字段数据表
public class DictData {

    private int dictCode;
    private String dictLabel;
    private String dictValue;
    private String dictType;
    private String remark;
    private String createBy;
    private String updateTime;
    private String updateBy;
    private String createTime;


    public int getDictCode () {
        return dictCode;
    }

    public void setDictCode ( int dictCode ) {
        this.dictCode = dictCode;
    }

    public String getDictLabel () {
        return dictLabel;
    }

    public void setDictLabel ( String dictLabel ) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue () {
        return dictValue;
    }

    public void setDictValue ( String dictValue ) {
        this.dictValue = dictValue;
    }

    public String getDictType () {
        return dictType;
    }

    public void setDictType ( String dictType ) {
        this.dictType = dictType;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark ( String remark ) {
        this.remark = remark;
    }

    public String getCreateBy () {
        return createBy;
    }

    public void setCreateBy ( String createBy ) {
        this.createBy = createBy;
    }

    public String getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime ( String updateTime ) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy () {
        return updateBy;
    }

    public void setUpdateBy ( String updateBy ) {
        this.updateBy = updateBy;
    }

    public String getCreateTime () {
        return createTime;
    }

    public void setCreateTime ( String createTime ) {
        this.createTime = createTime;
    }

}
