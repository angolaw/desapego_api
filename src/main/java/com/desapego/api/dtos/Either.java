package com.desapego.api.dtos;

import lombok.Getter;

@Getter
public class Either<L, R> {
    private final L  left;
    private final R right;

    public Either(L left, R right){
        this.left = left;
        this.right = right;
    }
    public static <L, R> Either<L,R> left(L left){
        return new Either<>(left, null);
    }
    public static <L, R> Either<L,R> right(R right){
        return new Either<>(null, right);
    }


}
