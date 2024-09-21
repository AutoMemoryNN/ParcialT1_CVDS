package com.stock.manager.monitorstock;

public record ServiceResponse<T>(boolean ok, String message, T data) {}

