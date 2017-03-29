/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet;

import edu.m0r.rpg.RpgElement;
import edu.m0r.rpg.sheet.lists.FieldList;

/**
 *
 * @author m0r
 */
public class Sheet extends RpgElement {
    private FieldList _playerData;
    
    public Sheet(String name) {
        //initPlayerName(name);
    }
    
    private void initPlayerData() {
        //setPlayerData(new FieldList());
    }
    
    public FieldList getPlayerData() {
        return _playerData;
    }
    
    public void setPlayerData(FieldList playerData) {
        _playerData = playerData;
    }
}
