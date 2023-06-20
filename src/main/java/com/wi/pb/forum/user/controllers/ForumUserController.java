package com.wi.pb.forum.user.controllers;

import com.wi.pb.forum.user.ForumUserFacade;
import com.wi.pb.forum.user.dto.CreateForumUserCommand;
import com.wi.pb.forum.user.dto.ForumUserDTO;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return forumUserFacade.findByUsername(currentPrincipalName);
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
