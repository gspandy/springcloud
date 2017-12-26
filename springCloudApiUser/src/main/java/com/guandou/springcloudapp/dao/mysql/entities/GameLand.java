package com.guandou.springcloudapp.dao.mysql.entities;


import org.apache.ibatis.jdbc.SQL;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author 周润德
 * @since 2017-12-26
 */

public class GameLand{




    private Integer id;

    private String ownerId;
    /**
     * 状态 0 未开垦 1待播种  2正在生长  3已经成熟 4已分配贯豆
     */
    private Integer status;
    /**
     * 土地买入时间
     */

    private Date createDate;
    /**
     * 可收获时间
     */

    private Date receiveDate;
    /**
     * 是否删除
     */

    private Integer isDelete;
    /**
     * 积分
     */
    private String records;
    /**
     * 排序
     */

    private Integer orderNo;
    /**
     * 土地价格
     */
    private BigDecimal price;
    /**
     * 种子价值
     */

    private BigDecimal seedsPrice;


    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnerId(){
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getStatus(){
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate(){
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getReceiveDate(){
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Integer getIsDelete(){
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRecords(){
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public Integer getOrderNo(){
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSeedsPrice(){
        return seedsPrice;
    }

    public void setSeedsPrice(BigDecimal seedsPrice) {
        this.seedsPrice = seedsPrice;
    }


    @Override
    public String toString(){
        return"GameLand{"+
                "id="+ id +
                ", ownerId="+ ownerId +
                ", status="+ status +
                ", createDate="+ createDate +
                ", receiveDate="+ receiveDate +
                ", isDelete="+ isDelete +
                ", records="+ records +
                ", orderNo="+ orderNo +
                ", price="+ price +
                ", seedsPrice="+ seedsPrice +
                "}";
    }



    public String selectByBean(final GameLand bean){

        return new SQL(){{
            String rs=" ID AS id, owner_id AS ownerId, status, create_date AS createDate, receive_date AS receiveDate, is_delete AS isDelete, records, ORDER_NO AS orderNo, price, seeds_price AS seedsPrice";

            SELECT(rs);
            FROM("game_land");
            if(bean.getId()!=null){
                WHERE("ID = #{id}");
            }
            if(bean.getOwnerId()!=null){
                WHERE("owner_id = #{ownerId}");
            }
            if(bean.getStatus()!=null){
                WHERE("status = #{status}");
            }
            if(bean.getCreateDate()!=null){
                WHERE("create_date = #{createDate}");
            }
            if(bean.getReceiveDate()!=null){
                WHERE("receive_date = #{receiveDate}");
            }
            if(bean.getIsDelete()!=null){
                WHERE("is_delete = #{isDelete}");
            }
            if(bean.getRecords()!=null){
                WHERE("records = #{records}");
            }
            if(bean.getOrderNo()!=null){
                WHERE("ORDER_NO = #{orderNo}");
            }
            if(bean.getPrice()!=null){
                WHERE("price = #{price}");
            }
            if(bean.getSeedsPrice()!=null){
                WHERE("seeds_price = #{seedsPrice}");
            }
        }}.toString();
    }

    public String insertBean(final GameLand bean)
    {
        return new SQL(){{
            INSERT_INTO("game_land");
            if(bean.getId()!=null){
                VALUES("ID"," #{id}");
            }
            if(bean.getOwnerId()!=null){
                VALUES("owner_id"," #{ownerId}");
            }
            if(bean.getStatus()!=null){
                VALUES("status"," #{status}");
            }
            if(bean.getCreateDate()!=null){
                VALUES("create_date"," #{createDate}");
            }
            if(bean.getReceiveDate()!=null){
                VALUES("receive_date"," #{receiveDate}");
            }
            if(bean.getIsDelete()!=null){
                VALUES("is_delete"," #{isDelete}");
            }
            if(bean.getRecords()!=null){
                VALUES("records"," #{records}");
            }
            if(bean.getOrderNo()!=null){
                VALUES("ORDER_NO"," #{orderNo}");
            }
            if(bean.getPrice()!=null){
                VALUES("price"," #{price}");
            }
            if(bean.getSeedsPrice()!=null){
                VALUES("seeds_price"," #{seedsPrice}");
            }
        }}.toString();
    }

    public String updateBean(final GameLand bean)
    {
        return new SQL(){{
            UPDATE("game_land");
            if(bean.getId()!=null){
                SET("ID = #{id}");
            }
            if(bean.getOwnerId()!=null){
                SET("owner_id = #{ownerId}");
            }
            if(bean.getStatus()!=null){
                SET("status = #{status}");
            }
            if(bean.getCreateDate()!=null){
                SET("create_date = #{createDate}");
            }
            if(bean.getReceiveDate()!=null){
                SET("receive_date = #{receiveDate}");
            }
            if(bean.getIsDelete()!=null){
                SET("is_delete = #{isDelete}");
            }
            if(bean.getRecords()!=null){
                SET("records = #{records}");
            }
            if(bean.getOrderNo()!=null){
                SET("ORDER_NO = #{orderNo}");
            }
            if(bean.getPrice()!=null){
                SET("price = #{price}");
            }
            if(bean.getSeedsPrice()!=null){
                SET("seeds_price = #{seedsPrice}");
            }
            if(bean.getId()!=null){
                WHERE("ID = #{id}");
            }
            if(bean.getOwnerId()!=null){
                WHERE("owner_id = #{ownerId}");
            }
            if(bean.getStatus()!=null){
                WHERE("status = #{status}");
            }
            if(bean.getCreateDate()!=null){
                WHERE("create_date = #{createDate}");
            }
            if(bean.getReceiveDate()!=null){
                WHERE("receive_date = #{receiveDate}");
            }
            if(bean.getIsDelete()!=null){
                WHERE("is_delete = #{isDelete}");
            }
            if(bean.getRecords()!=null){
                WHERE("records = #{records}");
            }
            if(bean.getOrderNo()!=null){
                WHERE("ORDER_NO = #{orderNo}");
            }
            if(bean.getPrice()!=null){
                WHERE("price = #{price}");
            }
            if(bean.getSeedsPrice()!=null){
                WHERE("seeds_price = #{seedsPrice}");
            }


        }}.toString();
    }
    public String deleteBean(final GameLand bean)
    {
        return new SQL(){{
            DELETE_FROM("game_land");
            if(bean.getId()!=null){
                WHERE("ID = #{id}");
            }
            if(bean.getOwnerId()!=null){
                WHERE("owner_id = #{ownerId}");
            }
            if(bean.getStatus()!=null){
                WHERE("status = #{status}");
            }
            if(bean.getCreateDate()!=null){
                WHERE("create_date = #{createDate}");
            }
            if(bean.getReceiveDate()!=null){
                WHERE("receive_date = #{receiveDate}");
            }
            if(bean.getIsDelete()!=null){
                WHERE("is_delete = #{isDelete}");
            }
            if(bean.getRecords()!=null){
                WHERE("records = #{records}");
            }
            if(bean.getOrderNo()!=null){
                WHERE("ORDER_NO = #{orderNo}");
            }
            if(bean.getPrice()!=null){
                WHERE("price = #{price}");
            }
            if(bean.getSeedsPrice()!=null){
                WHERE("seeds_price = #{seedsPrice}");
            }
        }}.toString();
    }
}