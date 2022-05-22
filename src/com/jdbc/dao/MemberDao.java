package com.jdbc.dao;
import java.sql.SQLException;
import java.util.List;

import com.jdbc.model.Member;

public interface MemberDao {
    public int add(Member member)
            throws SQLException;
    public void delete(int id)
            throws SQLException;
    public Member getMember(int id)
            throws SQLException;
    public List<Member> getMembers()
            throws SQLException;
    public int update(Member member)
            throws SQLException;
}
