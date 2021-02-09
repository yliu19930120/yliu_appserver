package com.yliu.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import java.time.LocalDate;

@ApiModel("动作")
public class ActionVo extends BaseUserVo{

    /**
     * 动作名字
     */
    @ApiModelProperty("动作名字")
    @NotEmpty(message="姓名不能为空！")
    private String actionName;
    /**
     * 动作分类
     */
    @ApiModelProperty("一级动作分类")
    @NotEmpty(message="分类不能为空！")
    private String typeL1;
    /**
     * 动作分类2
     */
    @ApiModelProperty("二级动作分类")
    private String typeL2;
    /**
     * 重量
     */
    @ApiModelProperty("重量,单位KG")
    @Positive(message="重量必须大于0")
    private Double weight;
    /**
     * 次数
     */
    @ApiModelProperty("次数")
    @Positive(message="次数必须大于0")
    private Integer nums;
    /**
     * 组间休息,单位秒
     */
    @ApiModelProperty("组间休息,单位秒")
    @PositiveOrZero(message="次数必须大于等于0")
    private Integer groupsTimes;
    /**
     * 是否为单边
     */
    @ApiModelProperty("是否为单边,1是,0否")
    private String unilateral;
    /**
     * 训练日期
     */
    @ApiModelProperty("训练日期")
    @NotNull(message = "训练日期不能为空")
    private LocalDate traningDate;

    @ApiModelProperty("速度(一般是体能动作)")
    private Double speed;
    /**
     * 持续时长(一般是体能动作,单位秒)
     */
    @ApiModelProperty("持续时长(一般是体能动作,单位秒)")
    private Double times;

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Integer getGroupsTimes() {
        return groupsTimes;
    }

    public void setGroupsTimes(Integer groupsTimes) {
        this.groupsTimes = groupsTimes;
    }

    public String getUnilateral() {
        return unilateral;
    }

    public void setUnilateral(String unilateral) {
        this.unilateral = unilateral;
    }

    public LocalDate getTraningDate() {
        return traningDate;
    }

    public void setTraningDate(LocalDate traningDate) {
        this.traningDate = traningDate;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getTimes() {
        return times;
    }

    public void setTimes(Double times) {
        this.times = times;
    }

    public String getTypeL1() {
        return typeL1;
    }

    public void setTypeL1(String typeL1) {
        this.typeL1 = typeL1;
    }

    public String getTypeL2() {
        return typeL2;
    }

    public void setTypeL2(String typeL2) {
        this.typeL2 = typeL2;
    }
}
