package com.wi.pb.forum.user.controllers;

import com.wi.pb.forum.user.ForumUserFacade;
import com.wi.pb.forum.user.dto.CreateForumUserCommand;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class ForumUserController {
    private final ForumUserFacade forumUserFacade;

    public ForumUserController(ForumUserFacade forumUserFacade) {
        this.forumUserFacade = forumUserFacade;
    }

    @GetMapping
    public List<ForumUserDTO> getAllEntities(){
        return forumUserFacade.findAllDto();
    }

    @GetMapping("/current")
    public ForumUserDTO getCurrent(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        return forumUserFacade.findByUsername(userDetails.getUsername());
    }

    @GetMapping("/{id}")
    public Optional<ForumUserDTO> getEntityById(@PathVariable Long id){
        return forumUserFacade.findDtoById(id);
    }

    @PostMapping
    public ForumUserDTO addEntity(@Valid @RequestBody CreateForumUserCommand command) {
        return forumUserFacade.createUser(command);
    }

    @DeleteMapping("/{id}")
    public void deleteEntityById(@PathVariable Long id) {
        forumUserFacade.deleteById(id);
    }

}
