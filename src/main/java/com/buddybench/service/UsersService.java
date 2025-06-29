package com.buddybench.service;

import com.buddybench.entity.Users;
import com.buddybench.repository.UsersRepository;
import com.buddybench.utils.Constants;
import com.buddybench.utils.UsersDetailsImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements UserDetailsService {


    @Autowired
    protected UsersRepository usersRepository;


    public Users saveUsersDetails(Users users) {
        Users data = new Users();
        data.setFirstName(users.getFirstName());
        data.setMiddleName(users.getMiddleName());
        data.setLastName(users.getLastName());
        data.setUserName(users.getUserName());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        data.setPassword(encodedPassword);
        data.setEmailId(users.getEmailId());
        data.setLoginStatus(false);
        data.setIsVerified(Constants.InActive);
        data.setCreatedAt(Constants.getDateAndTime());
        data.setUpdated(Constants.getDateAndTime());
        return usersRepository.save(data);
    }

    public List<Users> getUsersDetails() {
     return usersRepository.findAll();
    }

    public Optional<Users> findByEmailId(String emailId) {
        return usersRepository.findByEmailId(emailId);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = usersRepository.findByEmailId(username);
        if (users != null) {
            return UsersDetailsImpl.buildUserWithAuth(users);
        } else {
            Users user = (Users) usersRepository.findByuserName(username);
            return UsersDetailsImpl.buildUserWithAuth(Optional.ofNullable(user));
        }

    }
}
