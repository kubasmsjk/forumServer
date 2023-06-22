package com.wi.pb.forum.post.controllers;

import com.wi.pb.forum.post.CreateMainPostCommand;
import com.wi.pb.forum.post.MainPostFacade;
import com.wi.pb.forum.post.dto.MainPostDTO;
import com.wi.pb.forum.post.dto.MainPostEditDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/main-post")
public class MainPostController {

    private final MainPostFacade mainPostFacade;

    public MainPostController(MainPostFacade mainPostFacade) {
        this.mainPostFacade = mainPostFacade;
    }

    @GetMapping
    public List<MainPostDTO> getAllEntities(){
        return mainPostFacade.findAllDto();
    }

    @GetMapping("/{id}")
    public Optional<MainPostDTO> getEntityById(@PathVariable Long id){
        return mainPostFacade.findDtoById(id);
    }

    @PostMapping
    public MainPostDTO addEntity(@Valid @RequestBody CreateMainPostCommand command) {
        return mainPostFacade.createMainPost(command);
    }

    @DeleteMapping("/{id}")
    public void deleteEntityById(@PathVariable Long id) {
        mainPostFacade.deleteById(id);
    }

    @PutMapping
    public MainPostDTO update(@RequestBody MainPostEditDTO mainPostEditDTO){
        return mainPostFacade.update(mainPostEditDTO);
    }

    @PostMapping("/follow/{id}")
    public void follow(@PathVariable("id") Long id) {
        mainPostFacade.follow(id);
    }

    @PostMapping("/unfollow/{id}")
    public void unfollow(@PathVariable("id") Long id) {
        mainPostFacade.unfollow(id);
    }

}

