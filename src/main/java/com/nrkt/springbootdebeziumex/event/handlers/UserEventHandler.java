package com.nrkt.springbootdebeziumex.event.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nrkt.springbootdebeziumex.dto.PayloadType;
import com.nrkt.springbootdebeziumex.event.base.EventHandler;
import com.nrkt.springbootdebeziumex.event.base.MessageHandler;
import com.nrkt.springbootdebeziumex.model.User;
import com.nrkt.springbootdebeziumex.service.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserEventHandler extends MessageHandler<User> implements EventHandler {

    UserService userService;

    public UserEventHandler(ObjectMapper mapper, UserService userService) {
        super(mapper);
        this.userService = userService;
    }

    @PostConstruct
    public void action() {
        initActions();
    }

    @Override
    public void initActions() {
        actions.put(PayloadType.CREATE, (before, after) -> userService.addUser(after));
        actions.put(PayloadType.UPDATE, (before, after) -> userService.editUser(after));
        actions.put(PayloadType.DELETE, (before, after) -> userService.deleteUser(before.getId()));
    }
}
