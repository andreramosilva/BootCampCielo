package com.example.precadastro.PreCadastro.services;

import com.example.precadastro.PreCadastro.controllers.dto.ClienteRequest;
import com.example.precadastro.PreCadastro.controllers.dto.ClienteResponse;
import com.example.precadastro.PreCadastro.exceptions.ClienteAlreadyExistsException;
import com.example.precadastro.PreCadastro.exceptions.ClienteNotFoundException;
import com.example.precadastro.PreCadastro.exceptions.FailedValidationException;
import com.example.precadastro.PreCadastro.models.ClienteFisico;
import com.example.precadastro.PreCadastro.models.ClienteJuridico;
import com.example.precadastro.PreCadastro.repositories.ClienteFisicoRepository;
import com.example.precadastro.PreCadastro.repositories.ClienteJuridicoRepository;
import com.example.precadastro.PreCadastro.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ClienteService {

    @Autowired
    private ClienteJuridicoRepository clienteJuridicoRepository;

    @Autowired
    private ClienteFisicoRepository clienteFisicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    public ClienteResponse cadastrarClienteFisico(ClienteRequest clienteRequest) {
        if (clienteRequest.getCpf() != null && clienteFisicoRepository.existsByCpf(clienteRequest.getCpf())) {
            throw new ClienteAlreadyExistsException("Cliente com CPF já cadastrado.");
        }


        ClienteResponse response = new ClienteResponse();
        if (validarDadosClienteFisico(clienteRequest)) {
            ClienteFisico cliente = new ClienteFisico(clienteRequest.getCpf(), clienteRequest.getMcc(), clienteRequest.getNome(), clienteRequest.getEmail());
            BeanUtils.copyProperties(clienteRequest, cliente);
            ClienteFisico savedCliente = clienteFisicoRepository.save(cliente);
            BeanUtils.copyProperties(savedCliente, response);
            return response;
        }
        return response;
    }

    public ClienteResponse cadastrarClienteJuridico(ClienteRequest clienteRequest) {
        ClienteResponse response = new ClienteResponse();

        if (clienteRequest.getCnpj() != null && clienteJuridicoRepository.existsByCnpj(clienteRequest.getCnpj())) {
            throw new ClienteAlreadyExistsException("Cliente com CNPJ já cadastrado.");
        }

        if (validarDadosClienteJuridico(clienteRequest)) {
            ClienteJuridico cliente = new ClienteJuridico(clienteRequest.getCpf(), clienteRequest.getMcc(), clienteRequest.getCnpj(), clienteRequest.getRazaoSocial(), clienteRequest.getNomeContato(), clienteRequest.getEmailContato());
            BeanUtils.copyProperties(clienteRequest, cliente);
            ClienteJuridico savedCliente = clienteJuridicoRepository.save(cliente);
            BeanUtils.copyProperties(savedCliente, response);
            return response;
        }

        return response;
    }

    public ClienteResponse cadastrarCliente(ClienteRequest clienteRequest) {
        ClienteResponse response = new ClienteResponse();

        if (clienteRequest.getFlag().equals("pj") && clienteRequest.getCnpj() != null && clienteRequest.getRazaoSocial() != null && clienteRequest.getEmailContato() != null) {
            response = cadastrarClienteJuridico(clienteRequest);
        } else if (clienteRequest.getFlag().equals("pf")) {
            response = cadastrarClienteFisico(clienteRequest);

        }
        return response;
    }

    public ClienteResponse consultarCliente(Long id, String type) {
        ClienteResponse response = new ClienteResponse();
        if (type.equals("pj")) {
            Optional<ClienteJuridico> optionalCliente = clienteJuridicoRepository.findById(id);
            if (optionalCliente.isPresent()) {
                ClienteJuridico cliente = optionalCliente.get();
                BeanUtils.copyProperties(cliente, response);
                return response;
            } else {
                throw new ClienteNotFoundException("Cliente não encontrado.");
            }
        } else if (type.equals("pf")) {
            Optional<ClienteFisico> optionalCliente = clienteFisicoRepository.findById(id);
            if (optionalCliente.isPresent()) {
                ClienteFisico cliente = optionalCliente.get();
                BeanUtils.copyProperties(cliente, response);
                return response;
            } else {
                throw new ClienteNotFoundException("Cliente não encontrado.");
            }
        }
        return response;

    }

    public List<ClienteResponse> listarClientes() {
        List<ClienteJuridico> clienteJuridicos = clienteJuridicoRepository.findAll();
        List<ClienteFisico> clienteFisicos = clienteFisicoRepository.findAll();

        List<ClienteResponse> combinedResponses = Stream.concat(
                clienteJuridicos.stream()
                        .map(clienteJuridico -> {

                            ClienteResponse response = new ClienteResponse();

                            BeanUtils.copyProperties(clienteJuridico, response);
                            return response;

                        }),
                clienteFisicos.stream()
                        .map(clienteFisico -> {

                            ClienteResponse response = new ClienteResponse();
                            BeanUtils.copyProperties(clienteFisico, response);

                            return response;

                        })
        )

                .collect(Collectors.toList());


        return combinedResponses;
    }

    public ClienteResponse atualizarCliente(Long id, ClienteRequest clienteRequest, String type) {
        ClienteResponse response = new ClienteResponse();
        if (type.equals("pf")) {
            Optional<ClienteFisico> optionalCliente = clienteFisicoRepository.findById(id);
            if (optionalCliente.isPresent()) {
                ClienteFisico cliente = optionalCliente.get();
                BeanUtils.copyProperties(clienteRequest, cliente);
                ClienteFisico updatedCliente = clienteFisicoRepository.save(cliente);
                BeanUtils.copyProperties(updatedCliente, response);
                return response;
            } else {
                throw new ClienteNotFoundException("Cliente não encontrado.");
            }
        } else if (type.equals("pj")) {
            Optional<ClienteJuridico> optionalCliente = clienteJuridicoRepository.findById(id);
            if (optionalCliente.isPresent()) {
                ClienteJuridico cliente = optionalCliente.get();
                BeanUtils.copyProperties(clienteRequest, cliente);
                ClienteJuridico updatedCliente = clienteJuridicoRepository.save(cliente);
                BeanUtils.copyProperties(updatedCliente, response);
                return response;
            } else {
                throw new ClienteNotFoundException("Cliente não encontrado.");
            }
        }
        return response;
    }

    public void excluirCliente(Long id, String type) {
        if (type.equals("pf")) {
            if (!clienteFisicoRepository.existsById(id)) {
                throw new ClienteNotFoundException("Cliente não encontrado.");
            }
            clienteFisicoRepository.deleteById(id);
        } else if (type.equals("pj")) {
            if (!clienteJuridicoRepository.existsById(id)) {
                throw new ClienteNotFoundException("Cliente não encontrado.");
            }
            clienteJuridicoRepository.deleteById(id);
        }

    }

    private Boolean validarDadosClienteFisico(ClienteRequest clienteRequest) {
        if (validaCpf(clienteRequest.getCpf()) &&
                validaEmail(clienteRequest.getEmail()) &&
                validaNome(clienteRequest.getNome())) {
            return true;
        }
        throw new FailedValidationException("Campos invalidos verifique os campos enviados!");

    }

    private Boolean validarDadosClienteJuridico(ClienteRequest clienteRequest) {
        if (validaCnpj(clienteRequest.getCnpj()) &&
                validaCpf(clienteRequest.getCpf()) && validaEmail(clienteRequest.getEmailContato()) &&
                validaNome(clienteRequest.getNomeContato()) &&
                validaNome(clienteRequest.getRazaoSocial())) {
            return true;

        }
        throw new FailedValidationException("Campos invalidos verifique os campos enviados!");

    }

    private Boolean validaCpf(String cpf) {
        //validacao baseada na descricao do problema
        if (cpf.length() == 11) {
            return true;
        }
        return false;
    }


    private Boolean validaCnpj(String cnpj) {
        //validaçao baseada na descricao do problema
        if (cnpj.charAt(0) == '0' && cnpj.length() == 14) {
            return true;
        }
        return false;
    }

    private boolean validaEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }


    private Boolean validaNome(String nome) {
        if (nome.length() > 50) {
            return false;
        }

        return true;
    }

    private Boolean validaMcc(String mcc) {
        if (mcc.length() > 4) {
            return false;
        }
        return true;
    }
}

