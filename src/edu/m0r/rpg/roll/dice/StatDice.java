/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.roll.dice;

import edu.m0r.rpg.roll.result.DiceResult;
import edu.m0r.rpg.roll.result.StatDiceResult;
import edu.m0r.rpg.sheet.stats.Stat;

/**
 *
 * @author m0r
 */
public class StatDice extends Dice {
    private Stat _rolledStat;
    
    public StatDice(int max) {
        super(max);
    }
    public StatDice(int min, int max) {
        super(min, max);
    }
    
    @Override
    public DiceResult roll() {
        if(getRolledStat() == null) return null;
        StatDiceResult result = (StatDiceResult) getResult();
        result.setRolledStat(getRolledStat());
        return result;
    }
    
    public Stat getRolledStat() {
        return _rolledStat;
    }
    public void setRolledStat(Stat rolledStat) {
        _rolledStat = rolledStat;
    }
}
