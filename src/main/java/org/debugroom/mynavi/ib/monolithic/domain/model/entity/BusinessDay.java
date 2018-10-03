package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "business_day", schema = "public", catalog = "mynavi_ib")
public class BusinessDay {
    private String yyyymmdd;
    private Boolean isBusinessDay;
    private Timestamp lastUpdatedAt;
    private Integer ver;

    @Id
    @Column(name = "yyyymmdd", nullable = false, length = 8)
    public String getYyyymmdd() {
        return yyyymmdd;
    }

    public void setYyyymmdd(String yyyymmdd) {
        this.yyyymmdd = yyyymmdd;
    }

    @Basic
    @Column(name = "is_business_day", nullable = true)
    public Boolean getBusinessDay() {
        return isBusinessDay;
    }

    public void setBusinessDay(Boolean businessDay) {
        isBusinessDay = businessDay;
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
        BusinessDay that = (BusinessDay) o;
        return Objects.equals(yyyymmdd, that.yyyymmdd) &&
                Objects.equals(isBusinessDay, that.isBusinessDay) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(yyyymmdd, isBusinessDay, lastUpdatedAt, ver);
    }
}
