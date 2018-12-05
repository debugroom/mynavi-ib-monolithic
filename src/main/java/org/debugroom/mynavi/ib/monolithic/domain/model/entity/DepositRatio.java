package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "deposit_ratio", schema = "public", catalog = "mynavi_ib")
@IdClass(DepositRatioPK.class)
public class DepositRatio {
    private String depositType;
    private String validStartDay;
    private BigInteger ratio;
    private Timestamp lastUpdatedAt;
    private Integer ver;

    @Id
    @Column(name = "deposit_type", nullable = false, length = 50)
    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
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
    @Column(name = "ratio", nullable = true, precision = 0)
    public BigInteger getRatio() {
        return ratio;
    }

    public void setRatio(BigInteger ratio) {
        this.ratio = ratio;
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
        DepositRatio that = (DepositRatio) o;
        return Objects.equals(depositType, that.depositType) &&
                Objects.equals(validStartDay, that.validStartDay) &&
                Objects.equals(ratio, that.ratio) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(depositType, validStartDay, ratio, lastUpdatedAt, ver);
    }
}
