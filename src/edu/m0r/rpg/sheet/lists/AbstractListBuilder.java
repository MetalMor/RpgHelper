/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.sheet.lists;

import edu.m0r.rpg.RpgElement;
import edu.m0r.rpg.RpgElementBuilder;
import edu.m0r.rpg.util.Reflection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m0r
 * @param <L>
 * @param <E>
 */
public abstract class AbstractListBuilder<L extends RpgList<E>, E extends RpgElement> extends RpgElementBuilder {
    
    private final Class<L> _listType;
    
    private List<E> _list = new ArrayList<>();
    
    protected AbstractListBuilder(Class<L> listType) {
        super();
        _listType = listType;
    }
    
    @Override
    public L build() {
        L rpgList = (L) Reflection.getInstance(_listType.getConstructors()[0], super.build());
        rpgList.addAll(_list);
        return rpgList;
    }
    
    public AbstractListBuilder<L, E> setList(List<E> list) {
        if(list == null) list = new ArrayList<>();
        _list = list;
        return this;
    }
}
