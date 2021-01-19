package com.dove.Dove_user_backend.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class PostRequest {

    private String clubName;

    private String title;

    private String writer;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String link;

}
