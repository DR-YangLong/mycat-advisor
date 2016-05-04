package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by cjl on 2016/4/25.
 */
@Entity
@Table(name = "tab_order_advisor", schema = "", catalog = "advisor")
public class TabOrderAdvisor {
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    private Long orderId;
    private Long advisorId;
    private Date estBeginDate;
    private Date estEndDate;
    private Date actBeginDate;
    private Date actEndDate;
    private Float estEarnings;
    private Float actEarnings;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name = "order_id", nullable = false, insertable = true, updatable = true)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    
    @Column(name = "advisor_id", nullable = false, insertable = true, updatable = true)
    public Long getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(Long advisorId) {
        this.advisorId = advisorId;
    }

    
    @Column(name = "est_begin_date", nullable = true, insertable = true, updatable = true)
    public Date getEstBeginDate() {
        return estBeginDate;
    }

    public void setEstBeginDate(Date estBeginDate) {
        this.estBeginDate = estBeginDate;
    }

    
    @Column(name = "est_end_date", nullable = true, insertable = true, updatable = true)
    public Date getEstEndDate() {
        return estEndDate;
    }

    public void setEstEndDate(Date estEndDate) {
        this.estEndDate = estEndDate;
    }

    
    @Column(name = "act_begin_date", nullable = true, insertable = true, updatable = true)
    public Date getActBeginDate() {
        return actBeginDate;
    }

    public void setActBeginDate(Date actBeginDate) {
        this.actBeginDate = actBeginDate;
    }

    
    @Column(name = "act_end_date", nullable = true, insertable = true, updatable = true)
    public Date getActEndDate() {
        return actEndDate;
    }

    public void setActEndDate(Date actEndDate) {
        this.actEndDate = actEndDate;
    }

    
    @Column(name = "est_earnings", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getEstEarnings() {
        return estEarnings;
    }

    public void setEstEarnings(Float estEarnings) {
        this.estEarnings = estEarnings;
    }

    
    @Column(name = "act_earnings", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getActEarnings() {
        return actEarnings;
    }

    public void setActEarnings(Float actEarnings) {
        this.actEarnings = actEarnings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabOrderAdvisor that = (TabOrderAdvisor) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (advisorId != null ? !advisorId.equals(that.advisorId) : that.advisorId != null) return false;
        if (estBeginDate != null ? !estBeginDate.equals(that.estBeginDate) : that.estBeginDate != null) return false;
        if (estEndDate != null ? !estEndDate.equals(that.estEndDate) : that.estEndDate != null) return false;
        if (actBeginDate != null ? !actBeginDate.equals(that.actBeginDate) : that.actBeginDate != null) return false;
        if (actEndDate != null ? !actEndDate.equals(that.actEndDate) : that.actEndDate != null) return false;
        if (estEarnings != null ? !estEarnings.equals(that.estEarnings) : that.estEarnings != null) return false;
        if (actEarnings != null ? !actEarnings.equals(that.actEarnings) : that.actEarnings != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (advisorId != null ? advisorId.hashCode() : 0);
        result = 31 * result + (estBeginDate != null ? estBeginDate.hashCode() : 0);
        result = 31 * result + (estEndDate != null ? estEndDate.hashCode() : 0);
        result = 31 * result + (actBeginDate != null ? actBeginDate.hashCode() : 0);
        result = 31 * result + (actEndDate != null ? actEndDate.hashCode() : 0);
        result = 31 * result + (estEarnings != null ? estEarnings.hashCode() : 0);
        result = 31 * result + (actEarnings != null ? actEarnings.hashCode() : 0);
        return result;
    }
}
