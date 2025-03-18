package com.example.DordoiPlatform.service.impl;

import com.example.DordoiPlatform.dto.product.comment.CommentRequest;
import com.example.DordoiPlatform.dto.user.UserRequest;
import com.example.DordoiPlatform.entities.Comment;
import com.example.DordoiPlatform.entities.Product;
import com.example.DordoiPlatform.entities.User;
import com.example.DordoiPlatform.exception.CustomException;
import com.example.DordoiPlatform.mapper.CommentMapper;
import com.example.DordoiPlatform.repository.CommentRepository;
import com.example.DordoiPlatform.repository.ProductRepository;
import com.example.DordoiPlatform.repository.UserRepository;
import com.example.DordoiPlatform.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper;

    @Override
    public void add(CommentRequest commentRequest, Long userId, Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            throw new CustomException("Product not found", HttpStatus.NOT_FOUND);
        }

        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new CustomException("User not found", HttpStatus.NOT_FOUND);
        }

        Comment comment = commentMapper.toDtoComment(new Comment(), commentRequest);
        comment.setProduct(product.get());
        comment.setUser(user.get());

        commentRepository.save(comment);
    }
}
