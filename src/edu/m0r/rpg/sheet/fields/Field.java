/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet.fields;

import edu.m0r.rpg.RpgElement;

/**
 *
 * @author m0r
 * @param <C>
 */
public class Field<C> extends RpgElement {
    
    private final Class<C> _contentType;
    
    private C _content;
    
    protected Field(Class<C> contetType) {
        _contentType = contetType;
    }
    
    public Class<C> getValueType() {
        return _contentType;
    }
    
    public C getContent() {
        return _content;
    }
    
    public void setContent(C value) {
        _content = value;
    }
}
