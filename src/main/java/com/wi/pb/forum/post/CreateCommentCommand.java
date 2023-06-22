package com.wi.pb.forum.post;

public class CreateCommentCommand {

    private String description;
    private Long forumUserId;
    private Long mainPostId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getForumUserId() {
        return forumUserId;
    }

    public void setForumUserId(Long forumUserId) {
        this.forumUserId = forumUserId;
    }

    public Long getMainPostId() {
        return mainPostId;
    }

    public void setMainPostId(Long mainPostId) {
        this.mainPostId = mainPostId;
    }
}
