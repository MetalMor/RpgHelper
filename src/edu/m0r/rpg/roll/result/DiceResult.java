/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.roll.result;

/**
 *
 * @author m0r
 */
public class DiceResult extends AbstractDiceResult {
    public DiceResult(AbstractDiceResult result) {
        super(result.getValue());
    }
    
    public DiceResult(int value) {
        super(value);
    }
}
