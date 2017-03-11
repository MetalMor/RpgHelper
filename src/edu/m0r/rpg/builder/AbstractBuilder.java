/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.builder;

/**
 *
 * @author m0r
 */
public abstract class AbstractBuilder {
    private AbstractFactory _creator;
    public AbstractBuilder(AbstractFactory creator) {
        _creator = creator;
    }
    public RpgFactory getCreator() {
        return (RpgFactory) _creator;
    }
}
