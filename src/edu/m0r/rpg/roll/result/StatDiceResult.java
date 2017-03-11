/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.roll.result;

import edu.m0r.rpg.sheet.stats.Stat;

/**
 *
 * @author m0r
 */
public class StatDiceResult extends DiceResult {
    private Stat _rolledStat;
    
    public StatDiceResult(Integer value, Stat rolledStat) {
        super(value);
        _rolledStat = rolledStat;
    }
    
    public Stat getRolledStat() {
        return _rolledStat;
    }
    public void setRolledStat(Stat rolledStat) {
        _rolledStat = rolledStat;
    }
    public boolean isWin() {
        if(!isResolved()) return false;
        return 100 < getResult();
    }
    public Integer getResult() {
        if(!isResolved()) return null;
        return getValue() + getRolledStat().getTotalValue();
    }
}
