package org.example.tools;

import org.example.model.abstraction.IHaveHierarchicalStructure;

public class Hierarchy <TItem extends IHaveHierarchicalStructure<TItem>>{

    TItem root;

    public void setRootElement(TItem root){
        this.root=root;
    }

    public TItem findElementById(int id){
        return getById(id, this.root);
    }

    private TItem getById(int id, TItem current){
        if(current.getId()==id) return current;
        for (TItem child :
                current.getChildren()) {
            return getById(id, child);
        }
        return null;
    }


}
