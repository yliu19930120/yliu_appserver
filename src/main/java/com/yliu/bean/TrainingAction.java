package com.yliu.bean;

import java.time.LocalDate;

public class TrainingAction extends Bean{

    private String userId;
    /**
     * 动作名字
     */
    private String name;
    /**
     * 一级动作分类
     */
    private String typeL1;
    /**
     * 二级动作分类
     */
    private String typeL2;
    /**
     * 重量
     */
    private Double weight;
    /**
     * 次数
     */
    private Integer nums;
    /**
     * 组间休息,单位秒
     */
    private Integer groupsTimes;
    /**
     * 是否为单边
     */
    private String unilateral;
    /**
     * 训练日期
     */
    private LocalDate traningDate;
    /**
     * 速度(一般是体能动作)
     */
    private Double speed;
    /**
     * 持续时长(一般是体能动作,单位秒)
     */
    private Double times;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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