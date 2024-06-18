package com.service;

import com.model.Book;
import com.model.Member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberServicesImpl implements MemberServices {
    @Override
    public void addMember(Member m) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DatabaseUtil.getConnection();
            String sql = "insert into member (name, contact) values('" + m.getName() + "', '" + m.getContact() + "')";
            Statement stm = con.createStatement();
            stm.execute(sql);
            System.out.println("Member successfully added!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeMember(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DatabaseUtil.getConnection();
            String sql = "delete from member where id = '"+id+"'";
            Statement stm = con.createStatement();
            stm.execute(sql);
            System.out.println("Member removed successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DatabaseUtil.getConnection();
            String sql = "select * from member";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Member m = new Member();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                m.setContact(rs.getString("contact"));
//                System.out.println("Book ID: " + id);
//                System.out.println("Book Title: " + title);
//                System.out.println("Book Author: " + author);
//                System.out.println("Book Availability Status: " + avail);
                members.add(m);
            }

            rs.close();
            stm.close();
            con.close();

            System.out.println("All members shown successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
        return members;
    }
}
