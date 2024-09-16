package com.example.deliveryservice.utils;

import com.example.deliveryservice.dto.CommentsDtoRequest;
import com.example.deliveryservice.dto.CommentsDtoResponse;
import com.example.deliveryservice.model.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    //convert entity to dto
    public CommentsDtoResponse mapToDto(Comment comment) {

        ModelMapper mapper = new ModelMapper();
        CommentsDtoResponse commentsDtoResponse = mapper.map(comment, CommentsDtoResponse.class);

        return commentsDtoResponse;

    }

    //convert dto to entity
    public Comment mapToEntity(CommentsDtoRequest commentsDtoRequest) {

        ModelMapper mapper = new ModelMapper();
        Comment comment = mapper.map(commentsDtoRequest, Comment.class);

        return  comment;


    }
}
