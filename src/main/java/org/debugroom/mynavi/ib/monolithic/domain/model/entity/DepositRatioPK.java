package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepositRatioPK implements Serializable {
    private String depositType;
    private String validStartDay;

    @Column(name = "deposit_type", nullable = false, length = 50)
    @Id
    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
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
        DepositRatioPK that = (DepositRatioPK) o;
        return Objects.equals(depositType, that.depositType) &&
                Objects.equals(validStartDay, that.validStartDay);
    }

    @Override
    public int hashCode() {

        return Objects.hash(depositType, validStartDay);
    }
}
