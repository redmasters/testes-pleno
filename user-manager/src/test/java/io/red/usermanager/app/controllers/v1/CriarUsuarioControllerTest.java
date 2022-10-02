package io.red.usermanager.app.controllers.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.red.usermanager.app.controllers.v1.request.CriarUsuarioRequest;
import io.red.usermanager.core.usecases.CriarUsuario;
import io.red.usermanager.mocks.UsuarioMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CriarUsuarioController.class)
@AutoConfigureMockMvc
class CriarUsuarioControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CriarUsuario criarUsuario;

    private String API_URL = "/v1/user-manager/usuario";

    @Test
    @DisplayName("Deve criar um usuario valido")
    void deveCriarUmUsuarioValido() throws Exception {
        var criarUsuarioRequest = UsuarioMock.toRequest();
        var usuarioResponse = UsuarioMock.toResponse();
        var usuarioModel = UsuarioMock.toModel();
        var json = new ObjectMapper().writeValueAsString(criarUsuarioRequest);

        BDDMockito.given(criarUsuario.criar(criarUsuarioRequest.toModel()))
                .willReturn(usuarioModel);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(API_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc
                .perform(requestBuilder)
                .andExpect();
    }
}