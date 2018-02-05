package com.me2me.ims.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.me2me.ims.exception.UserNotFoundException;
import com.me2me.ims.mapper.MImsPermissionMapper;
import com.me2me.ims.mapper.auto.ImsUserMapper;
import com.me2me.ims.model.ImsFeature;
import com.me2me.ims.model.ImsUser;
import com.me2me.ims.model.ImsUserExample;
import com.me2me.ims.service.ImsLoginService;

@Service
public class ImsLoginServiceImpl implements ImsLoginService {
	@Autowired
	private ImsUserMapper userMapper;
	@Autowired
	private MImsPermissionMapper mMapper;
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public ImsUser login(String userName, String pwd) throws UserNotFoundException {
		ImsUserExample example = new ImsUserExample();
		example.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(pwd);
		List<ImsUser> user = userMapper.selectByExample(example);
		if (user.size() == 0) {
			throw new UserNotFoundException("用户未找到：" + userName + ",pwd:" + pwd);
		} else {
			return user.get(0);
		}
	}

	@Override
	public List<ImsFeature> getUserPermissions(int uid) {
		return mMapper.getUserPermissons(uid);
	}

}
