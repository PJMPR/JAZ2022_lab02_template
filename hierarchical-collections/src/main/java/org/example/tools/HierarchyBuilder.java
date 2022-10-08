package org.example.tools;


import org.example.model.abstraction.IHaveHierarchicalStructure;

import java.util.List;

public class HierarchyBuilder<TItem extends IHaveHierarchicalStructure<TItem>> {
    private List<TItem> items;
    TItem currentHead;

    public void setElements(List<TItem> items) {
        this.items = items;
    }

    public void buildHierarchy() {
        for (TItem item :
                items) {
            if (item.getParentId() == null) {
                this.currentHead = item;
                continue;
            }
            item.setParent(findParentById(item.getParentId()));
        }
    }


    public TItem getRootElement() {
        return currentHead;
    }

    private TItem findParentById(int id) {
        for (TItem item :
                items) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }


}
