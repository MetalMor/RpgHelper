/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.roll.dice;

import edu.m0r.rpg.roll.result.StatDiceResult;
import edu.m0r.rpg.sheet.stats.Stat;

/**
 *
 * @author m0r
 */
public class StatDice extends AbstractDice<StatDiceResult> {
    private Stat _rolledStat;
    
    public StatDice() {
        super(StatDiceResult.class);
    }
    protected StatDice(AbstractDice dice) {
        this();
        setMin(dice.getMin());
        setMax(dice.getMax());
    }
    
    @Override
    public StatDiceResult roll() {
        if(getRolledStat() == null) return null;
        setResult(new StatDiceResult(randomValue()));
        getResult().setRolledStat(getRolledStat());
        return getResult();
    }
    
    public Stat getRolledStat() {
        return _rolledStat;
    }
    public void setRolledStat(Stat rolledStat) {
        _rolledStat = rolledStat;
    }
}
