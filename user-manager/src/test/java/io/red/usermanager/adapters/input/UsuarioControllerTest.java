package io.red.usermanager.adapters.input;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.red.usermanager.domain.entities.Usuario;
import io.red.usermanager.domain.usecases.NovoUsuario;
import io.red.usermanager.domain.usecases.port.UsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = UsuarioController.class)
@AutoConfigureMockMvc
class UsuarioControllerTest {

    static String USER_API = "/v1/user-manager";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UsuarioRepository usuarioRepository;

    @MockBean
    NovoUsuario novoUsuario;


    @Test
    @DisplayName("Deve criar um usuario valido")
    void deveCriarUmUsuarioValido() throws Exception {

        final var novoUsuario = criarUsuario();
        final var usuarioSalvo = new Usuario.UsuarioBuilder()
                .id(1L)
                .nomeUsuario("Fulano")
                .nome("fulano")
                .email("fulano@oi.com")
                .senha("123456")
                .build();

        BDDMockito.given(usuarioRepository.criar(Mockito.any(Usuario.class)))
                .willReturn(usuarioSalvo);
        String json = new ObjectMapper().writeValueAsString(novoUsuario);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(USER_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc
                .perform(requestBuilder)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").value(1L))
                .andExpect(jsonPath("nomeUsuario").value(usuarioSalvo.getNomeUsuario()))
                .andExpect(jsonPath("nome").value(usuarioSalvo.getNomeUsuario()))
                .andExpect(jsonPath("email").value(usuarioSalvo.getEmail()))
                .andExpect(jsonPath("senha").value(usuarioSalvo.getSenha()));
    }


    @Test
    void listar() {
    }

    private Usuario criarUsuario() {
        return new Usuario.UsuarioBuilder()
                .nomeUsuario("Fulano")
                .nome("fulano")
                .email("fulano@oi.com")
                .senha("123456")
                .build();
    }
}