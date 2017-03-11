/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.builder;

import edu.m0r.rpg.roll.Roll;
import edu.m0r.rpg.roll.dice.Dice;
import edu.m0r.rpg.roll.dice.StatDice;
import edu.m0r.rpg.roll.dice.types.DiceType;
import edu.m0r.rpg.sheet.stats.Stat;

/**
 *
 * @author m0r
 */
public class RollBuilder extends RpgElementBuilder {
    
    public Stat _rolledStat;
    
    public int _nDices = 1;
    public int _nSides = 6;
    
    public RollBuilder(AbstractFactory creator) {
        super(creator);
    }
    
    public Roll build(DiceType diceType) {
        if(diceType == null) diceType = DiceType.REGULAR;
        Roll roll = new Roll(_nDices, _nSides);
        if(diceType == DiceType.STAT) roll = buildStatRoll();
        return roll;
    }
    
    private Roll<StatDice> buildStatRoll() {
        if(_rolledStat == null) return null;
        Roll<StatDice> statRoll = new Roll<>(_nDices, _nSides);
        statRoll.setRolledStat(_rolledStat);
        return statRoll;
    }
    
    public RollBuilder setDices(int nDices) {
        _nDices = nDices;
        return this;
    }
    public RollBuilder setSides(int nSides) {
        _nSides = nSides;
        return this;
    }
    public RollBuilder setRolledStat(Stat rolledStat) {
        _rolledStat = rolledStat;
        return this;
    }
    
    
}
