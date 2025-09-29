package csc207.todo_list;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Domain model for a single to-do item.
 *
 * Data-only class with behavior stubs; UI/persistence should depend on this.
 */
public class Task {

    /** Stable identifier for persistence and UI selection. */
    private final UUID id;

    private String title;
    private String description;
    private LocalDate dueDate;
    private Priority priority;
    private boolean completed;

    /** Priority levels for tasks. */
    public enum Priority { LOW, MEDIUM, HIGH }

    // -------------------- Constructors --------------------

    /** Minimal constructor (reasonable defaults). */
    public Task(String title) {
        this(UUID.randomUUID(), title, "", null, Priority.MEDIUM, false);
    }

    /** Full constructor. */
    public Task(UUID id, String title, String description,
                LocalDate dueDate, Priority priority, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = completed;
    }

    // -------------------- Getters / Setters --------------------

    public UUID getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    // -------------------- Behavior (stubs; no implementation yet) --------------------

    /** Mark the task as complete. */
    public void markComplete() {
        // TODO: set 'completed' to true and record any audit info if needed
    }

    /** Mark the task as incomplete. */
    public void markIncomplete() {
        // TODO: set 'completed' to false
    }

    /** Toggle the completion status. */
    public void toggleComplete() {
        // TODO: flip 'completed'
    }

    /** Rename the task. */
    public void rename(String newTitle) {
        // TODO: validate and update title
    }

    /** Update non-title details in one call. */
    public void updateDetails(String newDescription, LocalDate newDueDate, Priority newPriority) {
        // TODO: update description, dueDate, priority (with validation as desired)
    }

    // Optional: equals/hashCode/toString could be added later based on 'id'
}
