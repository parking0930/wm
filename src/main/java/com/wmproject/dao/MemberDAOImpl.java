package com.wmproject.dao;

import java.util.List;

import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.wmproject.domain.MemberVO;
 
@Repository
public class MemberDAOImpl implements MemberDAO {
 
    @Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "mappers.memberMapper";
    
    @Override
    public List<MemberVO> selectMember() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectMember");
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
 
}