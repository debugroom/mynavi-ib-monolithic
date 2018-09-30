package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FundFeeRatioPK implements Serializable {
    private String fundId;
    private String validStartDay;

    @Column(name = "fund_id", nullable = false, length = 8)
    @Id
    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    @Column(name = "valid_start_day", nullable = false, length = 8)
    @Id
    public String getValidStartDay() {
        return validStartDay;
    }

    public void setValidStartDay(String validStartDay) {
        this.validStartDay = validStartDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FundFeeRatioPK that = (FundFeeRatioPK) o;
        return Objects.equals(fundId, that.fundId) &&
                Objects.equals(validStartDay, that.validStartDay);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fundId, validStartDay);
    }
}
