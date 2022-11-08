package io.red.usermanager.app.controllers.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.red.usermanager.core.models.Usuario;
import io.red.usermanager.core.repositories.UsuarioRepository;
import io.red.usermanager.core.usecases.CriarUsuario;
import io.red.usermanager.mocks.UsuarioMock;
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
@WebMvcTest(controllers = CriarUsuarioController.class)
@AutoConfigureMockMvc
class CriarUsuarioControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CriarUsuario criarUsuario;

    @MockBean
    UsuarioRepository usuarioRepository;

    static String API_URL = "/v1/usuario";

    @Test
    @DisplayName("Deve criar um usuario valido")
    void deveCriarUmUsuarioValido() throws Exception {
        var criarUsuarioRequest = UsuarioMock.toRequest();
        var usuarioResponse = UsuarioMock.toResponse();
        var usuarioModel = UsuarioMock.toModel();

        BDDMockito.given(criarUsuario.criar(Mockito.any(Usuario.class)))
                .willReturn(usuarioModel);
        var json = new ObjectMapper().writeValueAsString(criarUsuarioRequest);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(API_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc
                .perform(requestBuilder)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").value(1L))
                .andExpect(jsonPath("nome").value(usuarioModel.getNome()))
                .andExpect(jsonPath("nomeUsuario").value(usuarioModel.getNomeUsuario()))
                .andExpect(jsonPath("email").value(usuarioModel.getEmail()));
    }
}
