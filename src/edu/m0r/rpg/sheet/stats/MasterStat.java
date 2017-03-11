/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet.stats;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m0r
 */
public class MasterStat extends Stat {
    
    private List<SlaveStat> _slaves = new ArrayList<>();
    
    public boolean addSlave(SlaveStat slave) {
        return !isSlave(slave) && _slaves.add(slave);
    }
    public int addSlaves(List<SlaveStat> slaves) {
        if(slaves == null) return 0;
        int count = 0;
        for(SlaveStat slave : slaves) if(addSlave(slave)) count++;
        return count;
        
    }
    
    public boolean isSlave(SlaveStat slave) {
        return _slaves.contains(slave);
    }
    
    public List<SlaveStat> getSlaves() {
        if(_slaves == null) _slaves = new ArrayList<>();
        return _slaves;
    }
    public void setSlaves(List<SlaveStat> slaves) {
        _slaves = slaves;
    }
}
