package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(ProspectusPK.class)
public class Prospectus {
    private String fundId;
    private int prospectusNo;
    private String filePath;
    private Boolean isValid;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private Fund fundByFundId;

    @Id
    @Column(name = "fund_id", nullable = false, length = 8)
    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    @Id
    @Column(name = "prospectus_no", nullable = false)
    public int getProspectusNo() {
        return prospectusNo;
    }

    public void setProspectusNo(int prospectusNo) {
        this.prospectusNo = prospectusNo;
    }

    @Basic
    @Column(name = "file_path", nullable = true, length = 512)
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "is_valid", nullable = true)
    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    @Basic
    @Column(name = "last_updated_at", nullable = true)
    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @Basic
    @Column(name = "ver", nullable = true)
    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prospectus that = (Prospectus) o;
        return prospectusNo == that.prospectusNo &&
                Objects.equals(fundId, that.fundId) &&
                Objects.equals(filePath, that.filePath) &&
                Objects.equals(isValid, that.isValid) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fundId, prospectusNo, filePath, isValid, lastUpdatedAt, ver);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "fund_id", referencedColumnName = "fund_id", nullable = false, insertable = false, updatable = false)})
    public Fund getFundByFundId() {
        return fundByFundId;
    }

    public void setFundByFundId(Fund fundByFundId) {
        this.fundByFundId = fundByFundId;
    }
}
