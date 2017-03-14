/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.roll.result;

import edu.m0r.rpg.roll.result.types.DiceResultType;

/**
 *
 * @author m0r
 */
public abstract class AbstractDiceResult {
    private Integer _value;
    
    protected AbstractDiceResult(Integer value) {
        _value = value;
    }
    
    public DiceResultType getResultType() {
        if(!isResolved()) return DiceResultType.UNRESOLVED;
        switch(getValue()) {
            case 1: return DiceResultType.WORST_FAILURE;
            case 2: 
            case 3: return DiceResultType.BAD_FAILURE;
            case 4:
            case 5: return DiceResultType.FAILURE;
            case 6: return DiceResultType.MATRIX;
            case 96: 
            case 97: return DiceResultType.SUCCESS;
            case 98:
            case 99: return DiceResultType.GOOD_SUCCESS;
            case 100: return DiceResultType.BEST_SUCCESS;
            default: return DiceResultType.BROKEN;
        }
    }
    public boolean isResolved() {
        return getValue() != null;
    }
    public Integer getValue() {
        return _value;
    }
    public void setValue(Integer value) {
        _value = value;
    }
}
