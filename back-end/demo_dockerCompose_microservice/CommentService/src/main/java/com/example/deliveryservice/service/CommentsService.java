package com.example.deliveryservice.service;

import com.example.deliveryservice.dto.CommentsDtoRequest;
import com.example.deliveryservice.dto.CommentsDtoResponse;
import com.example.deliveryservice.exception.AlreadyExistException;

import java.util.List;

public interface CommentsService {


    List<CommentsDtoResponse> getAllComment();


    CommentsDtoResponse createComment(CommentsDtoRequest commentsDtoRequest) throws AlreadyExistException;

    CommentsDtoResponse updateComment(String idComment,CommentsDtoRequest commentsDtoRequest);

    boolean deleteComment(String idComment);

    CommentsDtoResponse getCommentById(String idComment);

    CommentsDtoResponse getCommentByIdCarRideAndIdUser (int idCarRide, int idUser);
    List<CommentsDtoResponse> getCommentsByIdUser (int idUser);
}
