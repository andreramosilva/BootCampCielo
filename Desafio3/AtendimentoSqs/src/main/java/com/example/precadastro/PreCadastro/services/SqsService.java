package com.example.precadastro.PreCadastro.services;


import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.*;

import java.util.List;
import java.util.Stack;

public class SqsService {

    //public static void main(String[] args) {

    String queueUrl = "https://sqs.us-east-1.amazonaws.com/223025438730/fila-atendimento-cielo";

    // Inicialize o cliente SQS
    AmazonSQS sqs = AmazonSQSClientBuilder.standard()
            .withCredentials(new ProfileCredentialsProvider()) // ou configure suas credenciais de outra forma
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("https://sqs.us-east-1.amazonaws.com", "us-east-1"))
            .build();

    public void enviaMensagem(String mensagem) {
        try {
            // Enviar uma mensagem para a fila
            SendMessageRequest sendMessageRequest = new SendMessageRequest(queueUrl, mensagem);
            sqs.sendMessage(sendMessageRequest);

        } catch (AmazonServiceException ase) {
            System.out.println("Erro na AWS: " + ase.getMessage());
        } catch (AmazonClientException ace) {
            System.out.println("Erro no cliente: " + ace.getMessage());
        }


    }

    public List<Message> recebeMensagem() {
        List<Message> mensagens = new Stack<>();
        try {
            // Receber mensagens da fila
            ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
            receiveMessageRequest.setMaxNumberOfMessages(10); // Número máximo de mensagens a serem recebidas
            ReceiveMessageResult receiveMessageResult = sqs.receiveMessage(receiveMessageRequest);


            for (Message message : receiveMessageResult.getMessages()) {
                System.out.println("Corpo da Mensagem: " + message.getBody());
                mensagens.add(message);
                // Excluir a mensagem após processá-la
                String messageReceiptHandle = message.getReceiptHandle();
                sqs.deleteMessage(new DeleteMessageRequest(queueUrl, messageReceiptHandle));
            }

        } catch (AmazonServiceException ase) {
            System.out.println("Erro na AWS: " + ase.getMessage());
        } catch (AmazonClientException ace) {
            System.out.println("Erro no cliente: " + ace.getMessage());
        }
        return mensagens;
    }

}


