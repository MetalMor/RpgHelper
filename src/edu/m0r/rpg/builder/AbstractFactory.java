/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.builder;

import edu.m0r.rpg.util.Constants;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m0r
 */
public abstract class AbstractFactory {
    
    private String _name;
    
    private static final List<RpgFactory> _instances = new ArrayList<>();
    private List<RpgElementBuilder> _builders = new ArrayList<>();
    
    protected AbstractFactory(String name) {
        _name = name;
    }
    
    public static RpgFactory getInstance(String name) {
        if(name == null) throw new NullPointerException(Constants.STR_ERROR_NULL_INSTANCE_NAME);
        if(name.isEmpty()) throw new IllegalArgumentException(Constants.STR_ERROR_EMPTY_INSTANCE_NAME);
        RpgFactory instance = new RpgFactory(name);
        if(_instances.contains(instance)) instance = getInstanceByName(name);
        else _instances.add(instance);
        return instance;
    }
    
    protected RpgElementBuilder makeBuilder() {
        RpgElementBuilder builder = new RpgElementBuilder(this);
        getBuilders().add(builder);
        return builder;
    }
    
    private static RpgFactory getInstanceByName(String name) {
        for(RpgFactory instance : _instances) 
            if(name.equals(instance.getName())) return instance;
        return null;
    }
    
    private static boolean checkAllowedInstance(AbstractFactory currentInstance) {
        for(AbstractFactory instance : _instances)
            if(currentInstance.equals(instance)) return false;
        return true;
    }
    
    protected List<RpgElementBuilder> getBuilders() {
        return _builders;
    }
    protected void setBuilders(List<RpgElementBuilder> builders) {
        _builders = builders;
    }
    public String getName() {
        return _name;
    }
    public void setName(String name) {
        _name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof AbstractFactory)) return false;
        AbstractFactory other = (AbstractFactory) obj;
        return other.getName().equals(other.getName());
    }
}
