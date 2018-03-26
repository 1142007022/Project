package kaisheng.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kaisheng.project.mapper.AccountMapper;
import kaisheng.project.utils.SqlSessionManger;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;

import kaisheng.project.entitys.Account;
import kaisheng.project.utils.JdbcHelp;
import org.apache.ibatis.session.SqlSession;

public class AccountDao {

	private SqlSession sqlSession = SqlSessionManger.getSqlSession(true);
	private HashMap<String,Object> maps = new HashMap<>();
	public Account findByMobile(String mobile) {
		 return sqlSession.getMapper(AccountMapper.class).findByMobile(mobile);
	}

	public void save(Account acc) {
		sqlSession.getMapper(AccountMapper.class).save(acc);
	}

	public List<Account> findAllByDeptId(String deptId,int accId) {
		List<Account> lists = new ArrayList<>();
		if (StringUtils.isNotEmpty(deptId)) {
			Map<String,Integer> map = new HashMap<>();
			int dId = Integer.parseInt(deptId);
			map.put("deptId",dId);
			map.put("accId",accId);
			lists = sqlSession.getMapper(AccountMapper.class).findAllByDeptId(map);
		} else {
			lists = sqlSession.getMapper(AccountMapper.class).findAllAccount(accId);
		}
		return lists;
	}

	public List<Account> finByPage(String deptId, int start, int pageSize,int accId) {
		maps.put("deptId",deptId);
		maps.put("start",start);
		maps.put("pageSize",pageSize);
		maps.put("accId",accId);
		List<Account> lists = sqlSession.getMapper(AccountMapper.class).finByPage(maps);
		sqlSession.close();
		return lists;
	}

	public List<Account> findAll() {
		return sqlSession.getMapper(AccountMapper.class).findAll();
	}

	public Account findById(int id) {
		return sqlSession.getMapper(AccountMapper.class).findById(id);
	}

	public void changeKey(String password, int id) {
		maps.put("password",password);
		maps.put("id",id);
		sqlSession.getMapper(AccountMapper.class).changeKey(maps);
	}

	public void delById(int accId) {
		String sql = "delete  from t_account where id = ?";
		JdbcHelp.executeUpdate(sql, accId);
	}

	public void editAccount(String username, String mobile, int id) {
		maps.put("userName",username);
		maps.put("id",id);
		sqlSession.getMapper(AccountMapper.class).editAccount(maps);
	}

	public void delAccAnddeptByAccId(int id) {
		String sql = "delete  from t_account_dept where aid = ?";
		JdbcHelp.executeUpdate(sql, id);
	}

	public  Account findEditAccById(int id){
		return sqlSession.getMapper(AccountMapper.class).findEditAccById(id);
	}

	public int getCountByDeptId(String deptId) {
		if(StringUtils.isNotEmpty(deptId)){
			String sql = "select count(*) from t_account_dept  where pid = ?";
			return JdbcHelp.query(sql, new ScalarHandler<Long>(), deptId).intValue();
		}else {
			String sql = "select count(*) from t_account ";
			return JdbcHelp.query(sql, new ScalarHandler<Long>()).intValue();
		}
	}


}
