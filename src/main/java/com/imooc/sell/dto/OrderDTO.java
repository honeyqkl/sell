package com.imooc.sell.dto;


import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
//数据传输对象 避免实体类为其他层服务
public class OrderDTO {


    //订单id
    private String orderId;

    //买家名字
    private String buyerName;

    //买家手机号
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //微信id
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态 默认为0新下单
    private Integer orderStatus;

    //支付状态 默认为0未支付
    private Integer payStatus;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    //例如这个属性如果写到entity中 因为数据库表中没有这个字段会报错 可用用    @Transient 来避免 可这样混淆了层与层的关系
    List<OrderDetail> orderDetailList;

}
