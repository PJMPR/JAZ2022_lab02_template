package org.example.model.abstraction;

import java.util.List;

public interface IHaveHierarchicalStructure<TItem> extends IHaveId, IHaveParentId {

    List<TItem> getChildren();
    TItem getParent();
    void setParent(TItem parent);
}
