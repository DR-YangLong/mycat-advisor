package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by cjl on 2016/4/25.
 */
@Entity
@Table(name = "tab_order_extend", schema = "", catalog = "advisor")
public class TabOrderExtend {
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    private Long orderId;
    private Integer type;
    private String beginDate;
    private String endDate;
    private Integer onlineDay;
    private Long advisor1;
    private Long advisor2;
    private Long advisor3;
    @Column(name = "memo", nullable = true, insertable = true, updatable = true)
    private String memo;
    private Integer sceneDay;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name = "order_id", nullable = true, insertable = true, updatable = true)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    
    @Column(name = "type", nullable = true, insertable = true, updatable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    
    @Column(name = "begin_date", nullable = true, insertable = true, updatable = true)
    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    
    @Column(name = "end_date", nullable = true, insertable = true, updatable = true)
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    
    @Column(name = "online_day", nullable = true, insertable = true, updatable = true)
    public Integer getOnlineDay() {
        return onlineDay;
    }

    public void setOnlineDay(Integer onlineDay) {
        this.onlineDay = onlineDay;
    }

    
    @Column(name = "advisor1", nullable = true, insertable = true, updatable = true)
    public Long getAdvisor1() {
        return advisor1;
    }

    public void setAdvisor1(Long advisor1) {
        this.advisor1 = advisor1;
    }

    
    @Column(name = "advisor2", nullable = true, insertable = true, updatable = true)
    public Long getAdvisor2() {
        return advisor2;
    }

    public void setAdvisor2(Long advisor2) {
        this.advisor2 = advisor2;
    }

    
    @Column(name = "advisor3", nullable = true, insertable = true, updatable = true)
    public Long getAdvisor3() {
        return advisor3;
    }

    public void setAdvisor3(Long advisor3) {
        this.advisor3 = advisor3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabOrderExtend that = (TabOrderExtend) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (beginDate != null ? !beginDate.equals(that.beginDate) : that.beginDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (onlineDay != null ? !onlineDay.equals(that.onlineDay) : that.onlineDay != null) return false;
        if (advisor1 != null ? !advisor1.equals(that.advisor1) : that.advisor1 != null) return false;
        if (advisor2 != null ? !advisor2.equals(that.advisor2) : that.advisor2 != null) return false;
        if (advisor3 != null ? !advisor3.equals(that.advisor3) : that.advisor3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (onlineDay != null ? onlineDay.hashCode() : 0);
        result = 31 * result + (advisor1 != null ? advisor1.hashCode() : 0);
        result = 31 * result + (advisor2 != null ? advisor2.hashCode() : 0);
        result = 31 * result + (advisor3 != null ? advisor3.hashCode() : 0);
        return result;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }

    public void setSceneDay(Integer sceneDay) {
        this.sceneDay = sceneDay;
    }
    @Column(name = "scene_day", nullable = true, insertable = true, updatable = true)
    public Integer getSceneDay() {
        return sceneDay;
    }
}
