package com.example.deliveryservice.dto;


import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommentsDtoResponse {
    private String idComment;
    private int idUser;
    private int idCarRide;
    private int idDriver;
    private  float note;
    private String comment;
    private LocalDate date;


}
