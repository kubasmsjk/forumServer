package com.wi.pb.forum.post;

import com.wi.pb.forum.post.dto.CommentDTO;

public class CreateCommentCommandHandler {

    private final CommentRepository commentRepository;
    private final MainPostRepository mainPostRepository;
    private final MainPostForumUserRepository mainPostForumUserRepository;
    private final CommentMapper commentMapper;

    public CreateCommentCommandHandler(CommentRepository commentRepository, MainPostRepository mainPostRepository,
                                       MainPostForumUserRepository mainPostForumUserRepository,
                                       CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.mainPostRepository = mainPostRepository;
        this.mainPostForumUserRepository = mainPostForumUserRepository;
        this.commentMapper = commentMapper;
    }

    public CommentDTO handle(CreateCommentCommand command) {
        Comment comment = new Comment();
        mapCommandToViolationNotification(command, comment);

        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toDto(savedComment);
    }

    private void mapCommandToViolationNotification(CreateCommentCommand command,
                                                   Comment comment) {

        ForumUser author = mainPostForumUserRepository.findById(command.getForumUserId()).orElseThrow(() -> new RuntimeException("Cannot find user"));
        MainPost mainPost = mainPostRepository.findById(command.getMainPostId()).orElseThrow(() -> new RuntimeException("Cannot find category"));

        comment.setDescription(command.getDescription());
        comment.setAuthor(author);
        comment.setMainPost(mainPost);

    }


}
