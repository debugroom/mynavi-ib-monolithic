package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Fund {
    private String fundId;
    private String fundName;
    private String tradeStartDay;
    private String financialCode;
    private Timestamp tradeStartDate;
    private String maturityDay;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private Collection<BuyableFundByRiskAnswer> buyableFundByRiskAnswersByFundId;
    private FinancialInstitution financialInstitutionByFinancialCode;
    private Collection<FundFeeRatio> fundFeeRatiosByFundId;
    private Collection<FundOrder> fundOrdersByFundId;
    private Collection<Prospectus> prospectusesByFundId;

    @Id
    @Column(name = "fund_id", nullable = false, length = 8)
    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    @Basic
    @Column(name = "fund_name", nullable = true, length = 512)
    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    @Basic
    @Column(name = "trade_start_day", nullable = true, length = 8)
    public String getTradeStartDay() {
        return tradeStartDay;
    }

    public void setTradeStartDay(String tradeStartDay) {
        this.tradeStartDay = tradeStartDay;
    }

    @Basic
    @Column(name = "financial_code", nullable = false, insertable = false, updatable = false,  length = 4)
    public String getFinancialCode() {
        return financialCode;
    }

    public void setFinancialCode(String financialCode) {
        this.financialCode = financialCode;
    }

    @Basic
    @Column(name = "trade_start_date", nullable = true)
    public Timestamp getTradeStartDate() {
        return tradeStartDate;
    }

    public void setTradeStartDate(Timestamp tradeStartDate) {
        this.tradeStartDate = tradeStartDate;
    }

    @Basic
    @Column(name = "maturity_day", nullable = true, length = 8)
    public String getMaturityDay() {
        return maturityDay;
    }

    public void setMaturityDay(String maturityDay) {
        this.maturityDay = maturityDay;
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
        Fund fund = (Fund) o;
        return Objects.equals(fundId, fund.fundId) &&
                Objects.equals(fundName, fund.fundName) &&
                Objects.equals(tradeStartDay, fund.tradeStartDay) &&
                Objects.equals(financialCode, fund.financialCode) &&
                Objects.equals(tradeStartDate, fund.tradeStartDate) &&
                Objects.equals(maturityDay, fund.maturityDay) &&
                Objects.equals(lastUpdatedAt, fund.lastUpdatedAt) &&
                Objects.equals(ver, fund.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fundId, fundName, tradeStartDay, financialCode, tradeStartDate, maturityDay, lastUpdatedAt, ver);
    }

    @OneToMany(mappedBy = "fundByFundId")
    public Collection<BuyableFundByRiskAnswer> getBuyableFundByRiskAnswersByFundId() {
        return buyableFundByRiskAnswersByFundId;
    }

    public void setBuyableFundByRiskAnswersByFundId(Collection<BuyableFundByRiskAnswer> buyableFundByRiskAnswersByFundId) {
        this.buyableFundByRiskAnswersByFundId = buyableFundByRiskAnswersByFundId;
    }

    @ManyToOne
    @JoinColumn(name = "financial_code", referencedColumnName = "financial_code", nullable = false)
    public FinancialInstitution getFinancialInstitutionByFinancialCode() {
        return financialInstitutionByFinancialCode;
    }

    public void setFinancialInstitutionByFinancialCode(FinancialInstitution financialInstitutionByFinancialCode) {
        this.financialInstitutionByFinancialCode = financialInstitutionByFinancialCode;
    }

    @OneToMany(mappedBy = "fundByFundId")
    public Collection<FundFeeRatio> getFundFeeRatiosByFundId() {
        return fundFeeRatiosByFundId;
    }

    public void setFundFeeRatiosByFundId(Collection<FundFeeRatio> fundFeeRatiosByFundId) {
        this.fundFeeRatiosByFundId = fundFeeRatiosByFundId;
    }

    @OneToMany(mappedBy = "fundByFundId")
    public Collection<FundOrder> getFundOrdersByFundId() {
        return fundOrdersByFundId;
    }

    public void setFundOrdersByFundId(Collection<FundOrder> fundOrdersByFundId) {
        this.fundOrdersByFundId = fundOrdersByFundId;
    }

    @OneToMany(mappedBy = "fundByFundId")
    public Collection<Prospectus> getProspectusesByFundId() {
        return prospectusesByFundId;
    }

    public void setProspectusesByFundId(Collection<Prospectus> prospectusesByFundId) {
        this.prospectusesByFundId = prospectusesByFundId;
    }
}
