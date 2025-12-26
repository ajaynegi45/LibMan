package com.libraryman_api.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/**
 * Entity representing a scheduled reminder for borrowed books.
 *
 * <p>This entity is created at the time of borrowing a book and is used to
 * efficiently schedule due-date and overdue notifications without scanning
 * all borrow records daily.</p>
 *
 * <p>Each reminder is triggered on a specific date and marked as sent
 * after notification delivery.</p>
 */

@Entity
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long borrowingId;
    private LocalDate reminderDate;
    private boolean sent;
    @Enumerated(EnumType.STRING)
    private ReminderType type;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public Long getBorrowingId() {
		return borrowingId;
	}

	public void setBorrowingId(Long borrowingId) {
		this.borrowingId = borrowingId;
	}
	
	
	
	public LocalDate getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(LocalDate reminderDate) {
		this.reminderDate = reminderDate;
	}
	
	  
	  
	public boolean isSent() {
		return sent;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}
	
	
	
	public ReminderType getType() {
		return type;
	}

	public void setType(ReminderType type) {
		this.type = type;
	}

	
    
  

    
}