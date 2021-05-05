package com.wmproject.dao;

import java.util.List;

import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.wmproject.domain.MemberVO;
import com.wmproject.domain.RankPagingVO;
 
@Repository
public class MemberDAOImpl implements MemberDAO {
 
    @Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "mappers.memberMapper";
    
    @Override
    public MemberVO selectMemberById(MemberVO vo) throws Exception {
        return sqlSession.selectOne(Namespace+".selectMemberById",vo);
    }

	@Override
	public MemberVO selectMemberByNick(String nickname) throws Exception {
		return sqlSession.selectOne(Namespace+".selectMemberByNick",nickname);
	}

	@Override
	public int checkID(MemberVO vo) throws Exception {
		int result = sqlSession.selectOne(Namespace+".checkID",vo);
		return result;
	}

	@Override
	public int checkNickname(MemberVO vo) throws Exception {
		int result = sqlSession.selectOne(Namespace+".checkNickname",vo);
		return result;
	}

	@Override
	public void signUp(MemberVO vo) throws Exception {
		sqlSession.insert(Namespace+".signUp",vo);
		return;
	}

	@Override
	public int login(MemberVO vo) throws Exception {
		int result = sqlSession.selectOne(Namespace+".login",vo);
		return result;
	}

	@Override
	public void updateProfile(MemberVO vo) throws Exception {
		sqlSession.update(Namespace+".updateProfile", vo);
	}

	@Override
	public List<MemberVO> searchRanking(RankPagingVO vo) throws Exception {
		return sqlSession.selectList(Namespace+".searchRanking", vo);
	}

	@Override
	public int cntMember() throws Exception {
		return sqlSession.selectOne(Namespace+".cntMember");
	}
 
}