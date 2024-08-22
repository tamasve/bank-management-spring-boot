package com.application.bankmanagement.repository;

import com.application.bankmanagement.entity.Notification;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends ListCrudRepository<Notification, Long> {
}
