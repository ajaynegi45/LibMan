package com.libraryman_api.entity;
/**
 * Defines the type of reminder to be sent.
 *
 * DUE_SOON   - Reminder sent before the book due date.
 * OVERDUE    - Daily reminder sent after the due date has passed.
 */
public enum ReminderType {
    DUE_SOON,
    OVERDUE
}