/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet.stats;

import edu.m0r.rpg.RpgElement;

/**
 *
 * @author m0r
 */
public class Stat extends RpgElement {

    private Integer _value;
    private Integer _modificator;
    
    public Integer getValue() {
        return _value;
    }
    public Integer getFullValue() {
        if(getValue() == null) return null;
        return getValue() + getModificator();
    }
    public Integer getTotalValue() {
        return getFullValue();
    }
    public void setValue(Integer value) {
        _value = value;
    }
    public Integer getModificator() {
        return _modificator;
    }
    public void setModificator(Integer modificator) {
        _modificator = modificator;
    }
}
