package com.example.DordoiPlatform.mapper.impl;

import com.example.DordoiPlatform.dto.product.comment.CommentRequest;
import com.example.DordoiPlatform.dto.product.comment.CommentResponse;
import com.example.DordoiPlatform.entities.Comment;
import com.example.DordoiPlatform.entities.Product;
import com.example.DordoiPlatform.mapper.CommentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment toDtoComment(Comment comment, CommentRequest commentRequest) {
        comment.setText(commentRequest.getText());
        comment.setCreatedAt(LocalDateTime.now());
        return comment;
    }

    @Override
    public CommentResponse toDtoCommentResponse(Comment comment) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(comment.getId());
        commentResponse.setText(comment.getText());
        commentResponse.setCreatedAt(comment.getCreatedAt());
        commentResponse.setProduct(comment.getProduct().getName());
        commentResponse.setUser(comment.getUser().getName());
        return commentResponse;
    }

    @Override
    public List<CommentResponse> toDtoCommentResponses(List<Comment> comments) {
        List<CommentResponse> commentResponses = new ArrayList<>();
        for (Comment comment : comments) {
            commentResponses.add(toDtoCommentResponse(comment));
        }
        return commentResponses;
    }
}
