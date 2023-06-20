package com.wi.pb.forum.violationNotification;

public class CreateViolationNotificationCommand {

    private Long postId;
    private String description;
    private Long informerId;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getInformerId() {
        return informerId;
    }

    public void setInformerId(Long informerId) {
        this.informerId = informerId;
    }
}
