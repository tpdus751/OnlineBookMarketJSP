package member;

import java.util.List;

public class SYMemberService implements MemberService {
	
	private MemberDAO memberDao;
	
	public SYMemberService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public boolean regist(Member member) {
		if (member == null) return false;
		int result = memberDao.insert(member);
		return result == 1 ? true : false;
	}

	@Override
	public Member login(String userId, String userPwd) {
		return memberDao.select(userId, userPwd);
	}

	@Override
	public Member read(int no) {
		Member member = memberDao.select(no);
		return member;
	}

	@Override
	public List<Member> listAll() {
		List<Member> memberList = memberDao.selectAll();
		return memberList;
	}

	@Override
	public boolean edit(Member member, String oldPwd) {
		if (member == null) return false;
		if (oldPwd == null) return false;
		
		int result = 0;
		
		Member memInfo = memberDao.select(member.getNo());
		if (oldPwd.equals(memInfo.getUserPwd())) {
			result = memberDao.update(member);
		}
		
		return result == 1 ? true : false;
	}

	@Override
	public boolean editAdditionalInfo(int no, String mobile, String email, String address) {
		Member member = new Member();
		
		member.setNo(no);
		member.setMobile(mobile);
		member.setEmail(email);
		member.setAddress(address);
		
		memberDao.updateAdditionalInfo(member);
		
		return false;
	}

	@Override
	public boolean remove(int no) {
		if (memberDao.select(no) == null) return false;
		int result = memberDao.delete(no);
		return result == 1 ? true : false;
	}

}
