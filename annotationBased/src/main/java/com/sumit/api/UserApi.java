package com.sumit.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sumit.model.Role;
import com.sumit.model.User;
import com.sumit.model.UserInfo;
import com.sumit.repository.RoleRepository;
import com.sumit.repository.UserInfoRepository;
import com.sumit.repository.UserRepository;

@Component
public class UserApi implements IUserApi{
	@Resource
	UserRepository userRepository;
	@Resource
	RoleRepository roleRepo;
	@Resource
	UserInfoRepository infoRipo;
	@Override
	public List<User> findAllUser() {
		
		return userRepository.findAll();
	}
	
	@Transactional
	@Override
	public void createNewUser(User user ,UserInfo info) {
		Role role = new Role();
		User userToSave = userRepository.save(user);
		role.setUser(userToSave);
		role.setRole("ROLE_USER");
		roleRepo.save(role);
		info.setUser(userToSave);
		infoRipo.save(info);
	
	}

	@Override
	public int countNumberOfDatas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUserByUserName(String username) {
		 User name = userRepository.findUser(username);
		return name;
	}
	



}

