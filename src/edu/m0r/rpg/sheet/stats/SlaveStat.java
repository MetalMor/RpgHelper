/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet.stats;

/**
 *
 * @author m0r
 */
public class SlaveStat extends Stat {
    
    private MasterStat _master;

    protected SlaveStat(Stat stat) {
        super(stat);
        init(stat.getValue(), stat.getModificator());
    }
    
    public MasterStat getMaster() {
        return _master;
    }
    public void setMaster(MasterStat master) {
        if(master.isSlave(this)) return;
        _master = master;
    }
    
    @Override
    public Integer getTotalValue() {
        if(getValue() == null || getMaster().getValue() == null) return null;
        return super.getTotalValue() + getMaster().getTotalValue();
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && ((SlaveStat) obj).getMaster().equals(getMaster());
    }
}
