/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.roll;

import edu.m0r.rpg.roll.dice.Dice;
import edu.m0r.rpg.roll.result.DiceResult;
import edu.m0r.rpg.sheet.stats.Stat;

/**
 *
 * @author m0r
 */
public class RollBuilder extends AbstractRollBuilder<Dice, DiceResult> {
    public RollBuilder() {
        super(Dice.class, DiceResult.class);
    }
    
    @Override
    public RollBuilder setName(String name) {
        return (RollBuilder) super.setName(name);
    }
    @Override
    public RollBuilder setDices(int nDices) {
        return (RollBuilder) super.setDices(nDices);
    }
    @Override
    public RollBuilder setSides(int nSides) {
        return (RollBuilder) super.setSides(nSides);
    }
}
