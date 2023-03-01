package com.jsconf.photogram.service;

import com.jsconf.photogram.domain.user.User;
import com.jsconf.photogram.domain.user.UserRepository;
import com.jsconf.photogram.handler.ex.CustomValidationApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User userUpdate(int id, User user) {
        // 1.영속화
        User userEntity = userRepository.findById(id).orElseThrow(() -> { return new CustomValidationApiException("찾을 수 없는 id입니다.");}); // 1.무조건 찾았다. get() 2.못찾았다 Exception 발동시킬께 orElseThrow()

        // 2.영속화된 오브젝트 수정 - 더티체킹 (업데이트)
        userEntity.setName(user.getName());

        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        userEntity.setPassword(encPassword);
        userEntity.setBio(user.getBio());
        userEntity.setWebsite(user.getWebsite());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());

        return userEntity;
    } // 더티체킹이 일어나서 업데이트가 완료됨
}
