/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fatecfranca.dao;

/**
 *
 * @author jr_ac
 */
public final class Paramter {

    private String parameterName;
    private int mySqlType;
    private Object value;
    private String direction;

    public void setParamterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParamterName() {
        return parameterName;
    }

    public void setMySqlType(int mySqlType) {
        this.mySqlType = mySqlType;
    }

    public int getMySqlType() {
        return mySqlType;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return this.direction == null ? "IN" : this.direction;
    }

    public Paramter() {

    }

    public Paramter(String parameterName, int mySqlType, Object value) {
        this.setParamterName(parameterName);
        this.setMySqlType(mySqlType);
        this.setValue(value);
        this.setDirection("IN");
    }

    public Paramter(String parameterName, int mySqlType, Object value, String direction) {
        this.setParamterName(parameterName);
        this.setMySqlType(mySqlType);
        this.setValue(value);
        this.setDirection(direction);
    }
}
