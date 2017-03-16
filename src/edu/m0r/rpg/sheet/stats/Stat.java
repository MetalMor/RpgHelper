/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet.stats;

import edu.m0r.rpg.RpgElement;
import edu.m0r.rpg.roll.StatRollBuilder;
import edu.m0r.rpg.roll.dice.DiceBuilder;
import edu.m0r.rpg.roll.dice.StatDice;
import edu.m0r.rpg.roll.result.StatDiceResult;

/**
 *
 * @author m0r
 */
public class Stat extends RpgElement {

    private Integer _value;
    private Integer _modificator;

    protected Stat(RpgElement element) {
        init(element.getName());
    }
    
    protected void init(Integer value, Integer modificator) {
        setValue(value);
        setModificator(modificator);
    }
    
    public StatDiceResult roll() {
        return new StatRollBuilder(this).setName("Roll{" + toString() + "}").
                setSides(100).setDices(1).build().doThrow().get(0);
    }
    
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
    
    @Override
    public String toString() {
        return super.toString() + "[" + getValue() + "]";
    }
}
