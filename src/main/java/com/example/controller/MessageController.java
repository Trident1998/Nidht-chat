package com.example.controller;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import com.example.MessageMapper;
import com.example.MessageRequestDto;
import com.example.model.Message;
import com.example.service.MessageService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class MessageController {
    private final MessageService messageService;
    private final MessageMapper messageMapper;

    public MessageController(MessageService messageService, MessageMapper messageMapper) {
        this.messageService = messageService;
        this.messageMapper = messageMapper;
    }

    @SneakyThrows
    @GetMapping
    public String index(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return "welcome";
        }
        List<Message> allMessages = messageService.getFiftyMessages();
        model.addAttribute("list", allMessages);
        return "index";
    }

    @PostMapping
    public String write(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String userName = Arrays.stream(cookies)
                .filter(c -> c.getName().equals("user_name"))
                .map(Cookie::getValue)
                .findFirst()
                .get();
         MessageRequestDto requestDto = new MessageRequestDto();
         requestDto.setMessage(request.getParameter("message"));
         requestDto.setUserName(userName.replaceAll("\\+", " "));
         messageService.save(messageMapper.mapToModel(requestDto));
        model.addAttribute("list", messageService.getAllMessages());
        return "index";
    }

    @GetMapping("/refresh")
    public String refresh(Model model) {
        List<Message> allMessages = messageService.getFiftyMessages();
        model.addAttribute("list", allMessages);
        return "index";
    }

    @SneakyThrows
    @PostConstruct
    public Message send() {
        Message message = new Message();
        message.setTime(LocalTime.now());
        message.setUserName("Dima");
        message.setMessage("Hello new job");

        Thread.sleep(1000);
        Message message1 = new Message();
        message1.setTime(LocalTime.now());
        message1.setUserName("Vova");
        message1.setMessage("go Ahead!!");

        Thread.sleep(2000);
        Message message2 = new Message();
        message2.setTime(LocalTime.now());
        message2.setUserName("Roma");
        message2.setMessage("Stop!!!");

        List<Message> messages = List.of( message, message1, message2, message, message1, message2, message, message1, message2, message2, message, message1, message2);
        messages.forEach(messageService::save);
        return message;
    }
}
