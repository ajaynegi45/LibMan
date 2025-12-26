package com.libraryman_api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryman_api.entity.Reminder;
/**
 * Repository for accessing and managing Reminder entities.
 *
 * Provides optimized queries to fetch only pending reminders
 * scheduled for a specific date.
 */

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    List<Reminder> findByReminderDateAndSentFalse(LocalDate date);
}
