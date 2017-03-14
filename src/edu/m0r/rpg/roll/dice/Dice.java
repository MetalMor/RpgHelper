/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.roll.dice;

import edu.m0r.rpg.roll.result.DiceResult;

/**
 *
 * @author m0r
 */
public class Dice extends AbstractDice<DiceResult> {
    public Dice() {
        super(DiceResult.class);
    }
    protected Dice(AbstractDice dice) {
        this();
        setMin(dice.getMin());
        setMax(dice.getMax());
    }
}
