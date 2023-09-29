import com.example.precadastro.PreCadastro.controllers.dto.ClienteRequest;
import com.example.precadastro.PreCadastro.controllers.dto.ClienteResponse;
import com.example.precadastro.PreCadastro.exceptions.ClienteAlreadyExistsException;
import com.example.precadastro.PreCadastro.exceptions.ClienteNotFoundException;
import com.example.precadastro.PreCadastro.models.ClienteFisico;
import com.example.precadastro.PreCadastro.models.ClienteJuridico;
import com.example.precadastro.PreCadastro.repositories.ClienteFisicoRepository;
import com.example.precadastro.PreCadastro.repositories.ClienteJuridicoRepository;
import com.example.precadastro.PreCadastro.repositories.ClienteRepository;
import com.example.precadastro.PreCadastro.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteJuridicoRepository clienteJuridicoRepository;

    @Mock
    private ClienteFisicoRepository clienteFisicoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCadastrarClienteFisico() {
        ClienteRequest clienteRequest = new ClienteRequest();
        clienteRequest.setCpf("12345678901");
        clienteRequest.setMcc("MCC123");
        clienteRequest.setNome("João");
        clienteRequest.setEmail("joao@example.com");

        when(clienteFisicoRepository.existsByCpf(clienteRequest.getCpf())).thenReturn(false);
        when(clienteFisicoRepository.save(any(ClienteFisico.class))).thenReturn(new ClienteFisico());

        ClienteResponse response = clienteService.cadastrarClienteFisico(clienteRequest);

        verify(clienteFisicoRepository, times(1)).save(any(ClienteFisico.class));
        assertNotNull(response);
    }

    @Test
    public void testCadastrarClienteFisicoClienteJaExiste() {
        ClienteRequest clienteRequest = new ClienteRequest();
        clienteRequest.setCpf("12345678901");
        clienteRequest.setMcc("MCC123");
        clienteRequest.setNome("João");
        clienteRequest.setEmail("joao@example.com");

        when(clienteFisicoRepository.existsByCpf(clienteRequest.getCpf())).thenReturn(true);

        assertThrows(ClienteAlreadyExistsException.class, () -> clienteService.cadastrarClienteFisico(clienteRequest));
    }

    @Test
    public void testCadastrarClienteJuridico() {
        ClienteRequest clienteRequest = new ClienteRequest();
        clienteRequest.setCnpj("12345678901234");
        clienteRequest.setMcc("MCC456");
        clienteRequest.setRazaoSocial("Empresa XYZ");
        clienteRequest.setNomeContato("Contato");
        clienteRequest.setEmailContato("contato@example.com");

        when(clienteJuridicoRepository.existsByCnpj(clienteRequest.getCnpj())).thenReturn(false);
        when(clienteJuridicoRepository.save(any(ClienteJuridico.class))).thenReturn(new ClienteJuridico());

        ClienteResponse response = clienteService.cadastrarClienteJuridico(clienteRequest);

        verify(clienteJuridicoRepository, times(1)).save(any(ClienteJuridico.class));
        assertNotNull(response);
    }

    @Test
    public void testCadastrarClienteJuridicoClienteJaExiste() {
        ClienteRequest clienteRequest = new ClienteRequest();
        clienteRequest.setCnpj("12345678901234");
        clienteRequest.setMcc("MCC456");
        clienteRequest.setRazaoSocial("Empresa XYZ");
        clienteRequest.setNomeContato("Contato");
        clienteRequest.setEmailContato("contato@example.com");

        when(clienteJuridicoRepository.existsByCnpj(clienteRequest.getCnpj())).thenReturn(true);

        assertThrows(ClienteAlreadyExistsException.class, () -> clienteService.cadastrarClienteJuridico(clienteRequest));
    }

    @Test
    public void testConsultarClienteJuridico() {
        Long id = 1L;
        when(clienteJuridicoRepository.findById(id)).thenReturn(Optional.of(new ClienteJuridico()));

        ClienteResponse response = clienteService.consultarCliente(id, "pj");

        assertNotNull(response);
    }

    @Test
    public void testConsultarClienteFisico() {
        Long id = 1L;
        when(clienteFisicoRepository.findById(id)).thenReturn(Optional.of(new ClienteFisico()));

        ClienteResponse response = clienteService.consultarCliente(id, "pf");

        assertNotNull(response);
    }

    @Test
    public void testConsultarClienteNaoEncontrado() {
        Long id = 1L;
        when(clienteFisicoRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ClienteNotFoundException.class, () -> clienteService.consultarCliente(id, "pf"));
    }

    @Test
    public void testListarClientes() {
        when(clienteJuridicoRepository.findAll()).thenReturn(List.of(new ClienteJuridico()));
        when(clienteFisicoRepository.findAll()).thenReturn(List.of(new ClienteFisico()));

        assertNotNull(clienteService.listarClientes());
    }

    @Test
    public void testAtualizarClienteFisico() {
        Long id = 1L;
        ClienteRequest clienteRequest = new ClienteRequest();
        clienteRequest.setCpf("12345678901");
        clienteRequest.setMcc("MCC123");
        clienteRequest.setNome("João");
        clienteRequest.setEmail("joao@example.com");

        when(clienteFisicoRepository.findById(id)).thenReturn(Optional.of(new ClienteFisico()));
        when(clienteFisicoRepository.save(any(ClienteFisico.class))).thenReturn(new ClienteFisico());

        ClienteResponse response = clienteService.atualizarCliente(id, clienteRequest, "pf");

        verify(clienteFisicoRepository, times(1)).save(any(ClienteFisico.class));
        assertNotNull(response);
    }

    @Test
    public void testAtualizarClienteJuridico() {
        Long id = 1L;
        ClienteRequest clienteRequest = new ClienteRequest();
        clienteRequest.setCnpj("12345678901234");
        clienteRequest.setMcc("MCC456");
        clienteRequest.setRazaoSocial("Empresa XYZ");
        clienteRequest.setNomeContato("Contato");
        clienteRequest.setEmailContato("contato@example.com");

        when(clienteJuridicoRepository.findById(id)).thenReturn(Optional.of(new ClienteJuridico()));
        when(clienteJuridicoRepository.save(any(ClienteJuridico.class))).thenReturn(new ClienteJuridico());

        ClienteResponse response = clienteService.atualizarCliente(id, clienteRequest, "pj");

        verify(clienteJuridicoRepository, times(1)).save(any(ClienteJuridico.class));
        assertNotNull(response);
    }

    @Test
    public void testAtualizarClienteNaoEncontrado() {
        Long id = 1L;
        ClienteRequest clienteRequest = new ClienteRequest();
        clienteRequest.setCpf("12345678901");
        clienteRequest.setMcc("MCC123");
        clienteRequest.setNome("João");
        clienteRequest.setEmail("joao@example.com");

        when(clienteFisicoRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ClienteNotFoundException.class, () -> clienteService.atualizarCliente(id, clienteRequest, "pf"));
    }

    @Test
    public void testExcluirClienteFisico() {
        Long id = 1L;
        when(clienteFisicoRepository.existsById(id)).thenReturn(true);

        assertDoesNotThrow(() -> clienteService.excluirCliente(id, "pf"));
    }

    @Test
    public void testExcluirClienteJuridico() {
        Long id = 1L;
        when(clienteJuridicoRepository.existsById(id)).thenReturn(true);

        assertDoesNotThrow(() -> clienteService.excluirCliente(id, "pj"));
    }

    @Test
    public void testExcluirClienteNaoEncontrado() {
        Long id = 1L;
        when(clienteFisicoRepository.existsById(id)).thenReturn(false);

        assertThrows(ClienteNotFoundException.class, () -> clienteService.excluirCliente(id, "pf"));
    }
}
