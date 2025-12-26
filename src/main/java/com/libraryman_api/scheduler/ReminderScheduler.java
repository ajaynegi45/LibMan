package com.libraryman_api.scheduler;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.libraryman_api.entity.Reminder;
import com.libraryman_api.repository.ReminderRepository;
import com.libraryman_api.service.NotificationService;

/**
 * Scheduler responsible for sending due-date and overdue book reminders.
 *
 * <p>This scheduler runs daily and processes only reminders that are due
 * on the current date, avoiding unnecessary full-table scans.</p>
 */
@Component
public class ReminderScheduler {

    private static final Logger log =
            LoggerFactory.getLogger(ReminderScheduler.class);

    private final ReminderRepository reminderRepository;
    private final NotificationService notificationService;

    public ReminderScheduler(ReminderRepository reminderRepository,
                             NotificationService notificationService) {
        this.reminderRepository = reminderRepository;
        this.notificationService = notificationService;
    }

    /**
     * Sends reminders scheduled for the current date.
     *
     * <p>Runs daily at 9 AM. A reminder is marked as sent only after
     * successful notification delivery.</p>
     */
    @Scheduled(cron = "0 0 9 * * ?")
    @Transactional
    public void sendDueReminders() {

        LocalDate today = LocalDate.now();
        List<Reminder> reminders =
                reminderRepository.findByReminderDateAndSentFalse(today);

        for (Reminder reminder : reminders) {
            try {
                notificationService.sendReminder(reminder); // actual notification
                reminder.setSent(true);
            } catch (Exception e) {
                log.error(
                    "Failed to send reminder for borrowingId: {}",
                    reminder.getBorrowingId(),
                    e
                );
            }
        }

        reminderRepository.saveAll(reminders);
    }
}
