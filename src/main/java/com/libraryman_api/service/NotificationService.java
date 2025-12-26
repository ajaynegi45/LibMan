package com.libraryman_api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.libraryman_api.entity.Reminder;

@Service
public class NotificationService {

    private static final Logger log =
            LoggerFactory.getLogger(NotificationService.class);

    public void sendReminder(Reminder reminder) {
        log.info(
            "Sending reminder for borrowingId: {}, Type: {}",
            reminder.getBorrowingId(),
            reminder.getType()
        );
        // TODO: Integrate with EmailService to send actual email notifications
    }
}
