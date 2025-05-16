package jsbrfs.core.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@MappedSuperclass //sen her şeyin başısın
public abstract class BaseEntity  {
    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deleteAt;

    @PrePersist
    protected void onCreate(){
        createdAt=LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        updatedAt=LocalDateTime.now();
    }
//    @PreRemove
//    protected void onDelete(){
//        deleteAt=LocalDateTime.now();
//    }
    //bunu güncelleme yapacağımız için bu anatasyon çalışmaz

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }
}

