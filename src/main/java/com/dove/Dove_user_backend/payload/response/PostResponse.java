package com.dove.Dove_user_backend.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Builder
public class PostResponse {

    private String clubName;

    private String title;

    private String writer;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;

    private String link;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdAt;

}
