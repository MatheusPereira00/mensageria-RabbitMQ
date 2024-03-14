package com.ms.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import static com.ms.user.message.UserMessage.MESSAGE_EMAIL;
import static com.ms.user.message.UserMessage.MESSAGE_NAME;

public record UserRecord(@NotBlank(message = MESSAGE_NAME) String name,
                         @NotBlank(message = MESSAGE_EMAIL) @Email String email) {}
