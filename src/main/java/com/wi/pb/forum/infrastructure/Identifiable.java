package com.wi.pb.forum.infrastructure;

public interface Identifiable<ID> {

    ID getId();

    void setId(ID id);
}
