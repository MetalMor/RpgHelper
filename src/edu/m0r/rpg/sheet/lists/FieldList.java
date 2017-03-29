/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet.lists;

import edu.m0r.rpg.RpgElement;
import edu.m0r.rpg.sheet.fields.Field;

/**
 *
 * @author m0r
 * @param <F>
 */
public class FieldList extends RpgList<Field<?>> {

    public FieldList(RpgList<Field<?>> rpgList) {
        super(rpgList);
    }

}
