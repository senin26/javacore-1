package ru.yusdm.javacore.lesson9genericsbegin.autoservice.common.business.search;

public abstract class BaseSearchCondition {
    protected Long id;
    /**
     * Germany BMW
     * Russia   Ural
     * Germany AUDI
     *
     */

    /**
     * Germany BMW
     * Germany AUDI
     * Russia   Ural
     *
     */

    /**
     *  Germany AUDI
     *  Germany BMW
     * Russia   Ural
     *
     */

    protected OrderDirection orderDirection;
    protected OrderType orderType = OrderType.SIMPLE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDirection getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(OrderDirection orderDirection) {
        this.orderDirection = orderDirection;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public boolean needOrdering() {
        return orderDirection != null && orderType != null;
    }
}