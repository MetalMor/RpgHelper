/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.builder;
import edu.m0r.rpg.sheet.stats.MasterStat;
import edu.m0r.rpg.sheet.stats.SlaveStat;
import edu.m0r.rpg.sheet.stats.Stat;
import java.util.List;

/**
 *
 * @author m0r
 */
public class StatBuilder extends RpgElementBuilder {
    private Integer _value;
    private Integer _modificator;
    private MasterStat _master;
    private List<SlaveStat> _slaves;

    public StatBuilder(AbstractFactory creator) {
        super(creator);
    }
    
    @Override
    public Stat build() {
        Stat stat = (Stat) super.build();
        stat.setValue(_value);
        stat.setModificator(_modificator);
        return stat;
    }
    
    public MasterStat buildMaster() {
        if(_slaves == null) return null;
        Stat stat = build();
        if(stat.getValue() == null) return null;
        MasterStat master = (MasterStat) stat;
        master.setSlaves(_slaves);
        return master;
    }
    
    public SlaveStat buildSlave() {
        if(_master == null) return null;
        SlaveStat slave = (SlaveStat) build();
        slave.setMaster(_master);
        return slave;
    }
    
    @Override
    public StatBuilder setName(String name) {
        return (StatBuilder) super.setName(name);
    }
    public StatBuilder setValue(Integer value) {
        if(_value == null) _modificator = null;
        else if(_modificator == null) _modificator = 0;
        _value = value;
        return this;
    }
    public StatBuilder setModificator(Integer modificator) {
        if(_value == null) return this;
        else if(modificator == null) modificator = 0;
        _modificator = modificator;
        return this;
    }
    public StatBuilder setMaster(MasterStat master) {
        _master = master;
        return this;
    }
    public StatBuilder setSlaves(List<SlaveStat> slaves) {
        _slaves = slaves;
        return this;
    }
}
