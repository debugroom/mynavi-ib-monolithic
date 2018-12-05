package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "fund_fee_ratio", schema = "public", catalog = "mynavi_ib")
@IdClass(FundFeeRatioPK.class)
public class FundFeeRatio {
    private String fundId;
    private String validStartDay;
    private BigInteger feeRatio;
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
    @Column(name = "valid_start_day", nullable = false, length = 8)
    public String getValidStartDay() {
        return validStartDay;
    }

    public void setValidStartDay(String validStartDay) {
        this.validStartDay = validStartDay;
    }

    @Basic
    @Column(name = "fee_ratio", nullable = true, precision = 0)
    public BigInteger getFeeRatio() {
        return feeRatio;
    }

    public void setFeeRatio(BigInteger feeRatio) {
        this.feeRatio = feeRatio;
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
        FundFeeRatio that = (FundFeeRatio) o;
        return Objects.equals(fundId, that.fundId) &&
                Objects.equals(validStartDay, that.validStartDay) &&
                Objects.equals(feeRatio, that.feeRatio) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fundId, validStartDay, feeRatio, lastUpdatedAt, ver);
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
