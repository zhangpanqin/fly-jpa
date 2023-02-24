package com.fly.jpa.onetoone2;

import com.fly.jpa.onetoone2.domain.UsersTwo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users2")
public class UserTwoController {
    private final UsersTwoService usersService;

    @GetMapping("{id}")
    public UsersTwo get(@PathVariable Long id) {
        return usersService.get(id);
    }

    @GetMapping()
    public List<UsersTwo> all() {
        return usersService.all();
    }
}
