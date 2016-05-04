package org.apache.mycat.advisor.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by cjl on 2016/4/25.
 */
@Entity
@Table(name = "tab_order", schema = "", catalog = "advisor")
public class TabOrder {
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    /**
     * 订单编号
     */
    private String orderNumber;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 订单类型
     */
    private Long type;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 支付流水号
     */
    private String paynumber;
    /**
     * 支付渠道
     */
    private Integer paytype;
    /**
     * 订单流程
     */
    private Integer orderStep;
    /**
     * 订单金额
     */
    private Float earnings; //订单金额
    /**
     * 下单人
     */
    private Long orderPeople;
    /**
     * 处理人
     */
    private Long processPeople;

    private long createTime;
    private long updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "earnings", nullable = false, insertable = true, updatable = true)
    public Float getEarnings() {
        return earnings;
    }

    public void setEarnings(Float earnings) {
        this.earnings = earnings;
    }

    @Column(name = "product_id", nullable = false, insertable = true, updatable = true)
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Column(name = "paynumber", nullable = true, insertable = true, updatable = true, length = 32)
    public String getPaynumber() {
        return paynumber;
    }

    public void setPaynumber(String paynumber) {
        this.paynumber = paynumber;
    }


    @Column(name = "paytype", nullable = true, insertable = true, updatable = true)
    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }


    @Column(name = "order_step", nullable = true, insertable = true, updatable = true)
    public Integer getOrderStep() {
        return orderStep;
    }

    public void setOrderStep(Integer orderStep) {
        this.orderStep = orderStep;
    }

    @Column(name = "create_time", nullable = true, insertable = true, updatable = true)
    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
    @Column(name = "update_time", nullable = true, insertable = true, updatable = true)
    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "order_people", nullable = true, insertable = true, updatable = true)
    public Long getOrderPeople() {
        return orderPeople;
    }

    public void setOrderPeople(Long orderPeople) {
        this.orderPeople = orderPeople;
    }
    @Column(name = "process_people", nullable = true, insertable = true, updatable = true)
    public Long getProcessPeople() {
        return processPeople;
    }

    public void setProcessPeople(Long processPeople) {
        this.processPeople = processPeople;
    }

    @Column(name = "order_number", nullable = true, insertable = true, updatable = true)
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    @Column(name = "type", nullable = true, insertable = true, updatable = true)
    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabOrder tabOrder = (TabOrder) o;

        if (id != null ? !id.equals(tabOrder.id) : tabOrder.id != null) return false;
        if (productId != null ? !productId.equals(tabOrder.productId) : tabOrder.productId != null) return false;
        if (status != null ? !status.equals(tabOrder.status) : tabOrder.status != null) return false;
        if (paynumber != null ? !paynumber.equals(tabOrder.paynumber) : tabOrder.paynumber != null) return false;
        if (paytype != null ? !paytype.equals(tabOrder.paytype) : tabOrder.paytype != null) return false;
        if (orderStep != null ? !orderStep.equals(tabOrder.orderStep) : tabOrder.orderStep != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (paynumber != null ? paynumber.hashCode() : 0);
        result = 31 * result + (paytype != null ? paytype.hashCode() : 0);
        result = 31 * result + (orderStep != null ? orderStep.hashCode() : 0);
        return result;
    }
}
