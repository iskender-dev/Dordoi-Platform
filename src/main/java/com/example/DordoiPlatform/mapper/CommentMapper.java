package com.example.DordoiPlatform.mapper;

import com.example.DordoiPlatform.dto.product.comment.CommentRequest;
import com.example.DordoiPlatform.dto.product.comment.CommentResponse;
import com.example.DordoiPlatform.entities.Comment;
import com.example.DordoiPlatform.entities.Product;

import java.util.List;

public interface CommentMapper {
    Comment toDtoComment(Comment comment , CommentRequest commentRequest);
    CommentResponse toDtoCommentResponse(Comment comment);
    List<CommentResponse> toDtoCommentResponses(List<Comment> comments);
}
