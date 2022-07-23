package com.kharis.todo.service;

import com.kharis.todo.model.AppUser;
import com.kharis.todo.repository.AppUserRepo;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final AppUserRepo appUserRepo;

    @Override
    public void createUser(AppUser newUser) {
        appUserRepo.save(newUser);
    }

    @Override
    public void updateUser(AppUser user) {
        appUserRepo.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        appUserRepo.deleteById(userId);
    }

    @Override
    public List<AppUser> getAllUser() {
        return appUserRepo.findAll();
    }

    @Override
    public AppUser getUserById(Long userId) {
        return appUserRepo.findById(userId).orElse(null);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return appUserRepo.findByUsername(username).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Collection<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
