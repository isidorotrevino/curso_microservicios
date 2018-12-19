package com.ies.curso.dia3.service;

public class EmailTask implements Runnable {

    private String email;
    private String message;
    private EmailUseCase emailUseCase;

    public EmailTask(EmailUseCase emailUseCase, String email, String message) {
        this.email = email;
        this.message = message;
        this.emailUseCase = emailUseCase;
    }

    @Override
    public void run() {
        emailUseCase.send(email, message);
    }

}
