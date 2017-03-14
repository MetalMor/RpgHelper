/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet.stats;
import edu.m0r.rpg.RpgElementBuilder;
import java.util.List;

/**
 *
 * @author m0r
 * @param <S>
 */
public class StatBuilder<S extends Stat> extends RpgElementBuilder {
    protected Integer _value;
    protected Integer _modificator;
    protected MasterStat _master;
    protected List<SlaveStat> _slaves;

    public StatBuilder() { }
    
    @Override
    public S build() {
        S stat = (S) new Stat(super.build());
        stat.setName(_name);
        stat.setValue(_value);
        stat.setModificator(_modificator);
        if(_master != null) {
            
        } else if(_slaves != null) {
            
        }
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
    public StatBuilder<S> setName(String name) {
        return (StatBuilder) super.setName(name);
    }
    public StatBuilder<S> setValue(Integer value) {
        if(_value == null) _modificator = null;
        else if(_modificator == null) _modificator = 0;
        _value = value;
        return this;
    }
    public StatBuilder<S> setModificator(Integer modificator) {
        if(_value == null) return this;
        else if(modificator == null) modificator = 0;
        _modificator = modificator;
        return this;
    }
    public StatBuilder<S> setMaster(MasterStat master) {
        _master = master;
        return this;
    }
    public StatBuilder<S> setSlaves(List<SlaveStat> slaves) {
        _slaves = slaves;
        return this;
    }
}
