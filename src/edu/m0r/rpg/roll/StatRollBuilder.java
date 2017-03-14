/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.roll;

import edu.m0r.rpg.roll.dice.StatDice;
import edu.m0r.rpg.roll.result.StatDiceResult;
import edu.m0r.rpg.sheet.stats.Stat;

/**
 *
 * @author m0r
 */
public class StatRollBuilder extends AbstractRollBuilder<StatDice, StatDiceResult> {
    public StatRollBuilder(Stat rolledStat) {
        super(StatDice.class, StatDiceResult.class);
        setRolledStat(rolledStat);
    }
    
    @Override
    public StatRollBuilder setName(String name) {
        return (StatRollBuilder) super.setName(name);
    }
    @Override
    public StatRollBuilder setDices(int nDices) {
        return (StatRollBuilder) super.setDices(nDices);
    }
    @Override
    public StatRollBuilder setSides(int nSides) {
        return (StatRollBuilder) super.setSides(nSides);
    }
    @Override
    public StatRollBuilder setRolledStat(Stat rolledStat) {
        return (StatRollBuilder) super.setRolledStat(rolledStat);
    }
}
