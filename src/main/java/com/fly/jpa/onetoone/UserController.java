package com.fly.jpa.onetoone;

import com.fly.jpa.onetoone.domain.Users;
import com.fly.jpa.onetoone2.domain.UsersTwo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UsersService usersService;

    @GetMapping("{id}")
    public Users get(@PathVariable Long id) {
        return usersService.get(id);
    }

    @GetMapping()
    public List<Users> all() {
        return usersService.all();
    }

    @PostMapping()
    public Long save(Users usersTwo) {
        return usersService.save(usersTwo);
    }

}
