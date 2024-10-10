package com.ruoyi.commondata.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 生产机构对象 system_organization
 * 
 * @author lyf
 * @date 2024-10-09
 */
public class SystemOrganization extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String id;

    /** $column.columnComment */
    @Excel(name = "组织机构id")
    private String organizationID;

    /** $column.columnComment */
    @Excel(name = "生产机构层次码")
    private String levelCode;

    /** $column.columnComment */
    private String databaseID;

    /** $column.columnComment */
    @Excel(name = "生产机构名称")
    private String name;

    /** $column.columnComment */
    @Excel(name = "生产线类型")
    private String type;

    /** $column.columnComment */
    @Excel(name = "${comment}")
    private String levelType;

    /** $column.columnComment */
    @Excel(name = "${comment}")
    private Long coefficientAltitude;

    /** $column.columnComment */
    @Excel(name = "${comment}")
    private Long rawToClinkerCoff;

    /** $column.columnComment */
    @Excel(name = "${comment}")
    private String enabled;

    /** $column.columnComment */
    @Excel(name = "法人代表")
    private String legalRepresentative;

    /** $column.columnComment */
    @Excel(name = "生产机构地址")
    private String address;

    /** $column.columnComment */
    @Excel(name = "联系人")
    private String contacts;

    /** $column.columnComment */
    @Excel(name = "联系人信息")
    private String contactInfo;

    /** $column.columnComment */
    @Excel(name = "投产日期")
    private Date commissioningDate;

    /** $column.columnComment */
    @Excel(name = "主要产品")
    private String products;

    /** $column.columnComment */
    @Excel(name = "备注")
    private String remarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(String organizationID) {
        this.organizationID = organizationID;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }


    public String getDatabaseID() {
        return databaseID;
    }

    public void setDatabaseID(String databaseID) {
        this.databaseID = databaseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public Long getCoefficientAltitude() {
        return coefficientAltitude;
    }

    public void setCoefficientAltitude(Long coefficientAltitude) {
        this.coefficientAltitude = coefficientAltitude;
    }

    public Long getRawToClinkerCoff() {
        return rawToClinkerCoff;
    }

    public void setRawToClinkerCoff(Long rawToClinkerCoff) {
        this.rawToClinkerCoff = rawToClinkerCoff;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Date getCommissioningDate() {
        return commissioningDate;
    }

    public void setCommissioningDate(Date commissioningDate) {
        this.commissioningDate = commissioningDate;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "SystemOrganization{" +
                "id='" + id + '\'' +
                ", organizationID=" + organizationID +
                ", levelCode='" + levelCode + '\'' +
                ", databaseID=" + databaseID +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", levelType='" + levelType + '\'' +
                ", coefficientAltitude=" + coefficientAltitude +
                ", rawToClinkerCoff=" + rawToClinkerCoff +
                ", enabled='" + enabled + '\'' +
                ", legalRepresentative='" + legalRepresentative + '\'' +
                ", address='" + address + '\'' +
                ", contacts='" + contacts + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", commissioningDate=" + commissioningDate +
                ", products='" + products + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
