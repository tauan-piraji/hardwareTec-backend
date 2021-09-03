package com.tauanoliveira.softwaretec.service;

import javax.mail.internet.MimeMessage;

import com.tauanoliveira.softwaretec.domain.OrdemServico;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage msg) {
        LOG.info("Simulando envio de email....");
        LOG.info(msg.toString());
        LOG.info("Email enviado!");
    }

    @Override
    public void sendOrderComcluidoHtmlEmail(OrdemServico entity) {
        // TODO Auto-generated method stub
    }

    @Override
    public void sendHtmlEmail(MimeMessage msg) {
        LOG.info("Simulando envio de email HTML....");
        LOG.info(msg.toString());
        LOG.info("Email enviado!");
    }

}