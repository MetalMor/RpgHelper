/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg;

/**
 *
 * @author m0r
 */
public class RpgElement implements IRpgElement {
    private String _name;
    
    protected RpgElement() { }
    
    protected final void init(String name) {
        setName(name);
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
        if(!(obj instanceof RpgElement)) return false;
        RpgElement other = (RpgElement) obj;
        return other.getName().equals(getName());
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
