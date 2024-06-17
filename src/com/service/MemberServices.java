package com.service;

import com.model.Member;

import java.util.List;

public interface MemberServices {
    void addMember(Member m);
    void removeMember(int id);

    List<Member> getAllMembers();
}
