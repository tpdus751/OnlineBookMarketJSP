package member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.OracleJDBConnection;

public class OracleMemberDAO implements MemberDAO {

	@Override
	public int insert(Member member) {
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = new StringBuilder()
				.append("insert into member (no, userid, userpwd, nickname, regdate, mobile, email, address) ")
				.append("values (member_seq.nextval, ?, ?, ?, sysdate, ?, ?, ?)")
				.toString();
		
		int result = 0;
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, member.getUserId());
			jdbc.pstmt.setString(2, member.getUserPwd());
			jdbc.pstmt.setString(3, member.getNickname());
			jdbc.pstmt.setString(4, member.getMobile());
			jdbc.pstmt.setString(5, member.getEmail());
			jdbc.pstmt.setString(6, member.getAddress());
			
			result = jdbc.pstmt.executeUpdate();
			System.out.println("1행이 업데이트 되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		
		return result;
	}

	@Override
	public Member select(int no) {
		Member member = null;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "select * from member where no = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, no);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			if (jdbc.rs.next()) {
				member = new Member(
						jdbc.rs.getInt("no"),
						jdbc.rs.getString("userid"),
						jdbc.rs.getString("userpwd"),
						jdbc.rs.getString("nickname"),
						jdbc.rs.getDate("regdate"),
						jdbc.rs.getString("mobile"),
						jdbc.rs.getString("email"),
						jdbc.rs.getString("address")
				);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return member;
	}

	@Override
	public Member select(String userId, String userPwd) {
		Member member = null;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "select * from member where userid = ? and userpwd = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, userId);
			jdbc.pstmt.setString(2,  userPwd);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			if (jdbc.rs.next()) {
				member = new Member(
						jdbc.rs.getInt("no"),
						jdbc.rs.getString("userid"),
						jdbc.rs.getString("userpwd"),
						jdbc.rs.getString("nickname"),
						jdbc.rs.getDate("regdate"),
						jdbc.rs.getString("mobile"),
						jdbc.rs.getString("email"),
						jdbc.rs.getString("address")
				);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return member;
	}

	@Override
	public List<Member> selectAll() {
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		List<Member> memberList = new ArrayList<>();
		
		String sql = "select * from member";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			while (jdbc.rs.next()) {
				Member member = new Member(
						jdbc.rs.getInt("no"),
						jdbc.rs.getString("userid"),
						jdbc.rs.getString("userpwd"),
						jdbc.rs.getString("nickname"),
						jdbc.rs.getDate("regdate"),
						jdbc.rs.getString("mobile"),
						jdbc.rs.getString("email"),
						jdbc.rs.getString("address")
				);
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return memberList;
	}
	
	@Override
	public int update(Member member) {
		OracleJDBConnection jdbc = new OracleJDBConnection();

		// sql문
		String sql = new StringBuilder()
				.append("update member ")
				.append("set userpwd = ?, nickname = ? ")
				.append("where no = ?")
				.toString();

		int result = 0;
		
		try {
			// PS 객체, 매개변수 set
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, member.getUserPwd());
			jdbc.pstmt.setString(2, member.getNickname());
			jdbc.pstmt.setInt(3, member.getNo());

			// sql 실행~~~~
			result = jdbc.pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return result;
	}

	@Override
	public int updateAdditionalInfo(Member member) {
		OracleJDBConnection jdbc = new OracleJDBConnection();

		// sql문
		String sql = new StringBuilder()
				.append("update member ")
				//.append("set password=?, nickname=?")
				.append("set mobile=?, email=?, address=?")
				.append("where no=?")
				.toString();

		int result = 0;
		
		try {
			// PS 객체, 매개변수 set
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, member.getMobile());
			jdbc.pstmt.setString(2, member.getEmail());
			jdbc.pstmt.setString(3, member.getAddress());
			jdbc.pstmt.setInt(4, member.getNo());

			// sql 실행~~~~
			result = jdbc.pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return result;
	}

	@Override
	public int delete(int no) {
		int result = 0;
		
		// DB 연결
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		// sql문 만들기
		String sql = "delete member where no=?";
		
		try {
			// PreparedStatement 객체 생성 <- sql문
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			// 파라미터 set
			jdbc.pstmt.setInt(1, no);
			
			// 실행
			result = jdbc.pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원닫기
			jdbc.close();
		}
				
		return result;
	}



}
