package com.service;

import com.model.Member;

import java.util.List;

public interface MemberService {
    void addMember(Member m);
    void deleteMember(int id);

    List<Member> getAllMembers();
}
