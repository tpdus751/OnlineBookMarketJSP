package member;

import java.util.List;

public interface MemberService {
	boolean regist(Member member);
	Member login(String userId, String userPwd);
	Member read(int no);
	List<Member> listAll();
	boolean edit(Member member, String oldPwd);
	boolean editAdditionalInfo(int no, String mobile, String email, String address);
	boolean remove(int no);
}
