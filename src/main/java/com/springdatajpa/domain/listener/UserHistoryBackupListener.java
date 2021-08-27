package com.springdatajpa.domain.listener;

import com.springdatajpa.domain.User;
import com.springdatajpa.domain.UserHistory;
import com.springdatajpa.repository.UserHistoryRepository;
import com.springdatajpa.utils.BeanUtils;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.PreUpdate;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserHistoryBackupListener {

    @PreUpdate
    public void preUpdate(Object obj) {
        log.info("UserHistoryBackupListener preUpdate 호출");
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) obj;

        UserHistory userHistory = UserHistory.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();

        userHistoryRepository.save(userHistory);
    }
}
