package com.netcraft.hibernate.composite;

import javax.persistence.Embeddable;
import java.io.Serializable;

import static java.util.Objects.hash;

@Embeddable
public class ReferencePK implements Serializable {

    private long attr_id;
    private long object_id;

    public ReferencePK() {
    }

    public ReferencePK(long attr_id, long object_id) {
        this.attr_id = attr_id;
        this.object_id = object_id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;

        if (obj.getClass() == this.getClass()) {
            ReferencePK id = (ReferencePK) obj;
            if (id.attr_id == this.attr_id && id.object_id == this.object_id)
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return hash(attr_id,object_id);
    }
}
